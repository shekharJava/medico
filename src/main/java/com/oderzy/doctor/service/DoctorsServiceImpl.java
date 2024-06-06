package com.oderzy.doctor.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.oderzy.$config.constants.$Delivery;
import com.oderzy.$config.constants._Order;
import com.oderzy._exception_.oderzy.doctor.NoDoctorFoundException;
import com.oderzy._notification.service.NotificationManger;
import com.oderzy.doctor.dto.DoctorsAppointmentDTO;
import com.oderzy.doctor.dto.DoctorsAppointmentVO;
import com.oderzy.doctor.dto.DoctorsDTO;
import com.oderzy.doctor.dto.DoctorsTimeDTO;
import com.oderzy.doctor.model.Doctors;
import com.oderzy.doctor.model.DoctorsAppointment;
import com.oderzy.doctor.repositery.DoctorsAppointmentRepositery;
import com.oderzy.doctor.repositery.DoctorsRepositery;
import com.oderzy.doctor.repositery.DoctorsTimeRepositery;
import com.oderzy.helper.OrderCodeGenerator;
import com.oderzy.wrapper.MyLocalDate;

@Service
public class DoctorsServiceImpl implements DoctorService {

	@Autowired
	private DoctorsRepositery repo;
	@Autowired
	private DoctorsAppointmentRepositery aRepo;
	@Autowired
	private DoctorsTimeRepositery tRepo;
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate updateSql;
	@Autowired
	private NotificationManger notificationManger;
	@Autowired
	private OrderCodeGenerator orderCodeGenerator;

	public List<DoctorsDTO> getAllDoctors(String area) throws NoDoctorFoundException {
		System.out.println("here exexexxeex");
		List<DoctorsDTO> dataDoctorsDTOs = repo.findByArea(area);
		if (dataDoctorsDTOs.isEmpty())
			throw new NoDoctorFoundException("\nRecord unavailble for " + area);
		return dataDoctorsDTOs;
	}

	public static int sumMe(int c, int y) {
		return c + y;
	}

	public List<DoctorsDTO> getAllDoctorsByCategory(String category, String area) {

		return repo.findByAreaAndCategory(area, category);
	}

	@Transactional
	public List<DoctorsTimeDTO> getAvailableSlots(String mobile, int days) {
		List<DoctorsTimeDTO> list = tRepo.findAllByMobile(mobile, "Active");
		return getDayStringNew(list, days);
	}

	public List<DoctorsTimeDTO> getDayStringNew(List<DoctorsTimeDTO> list, int dayCount) {
		List<DoctorsTimeDTO> timedata = new ArrayList<DoctorsTimeDTO>();
		LocalTime time = LocalTime.now();
		LocalDate date = LocalDate.now();
		List<DoctorsTimeDTO> listCopy = new ArrayList<>(list);

		String targetDay = "";
		String currDay = "S";

		int index = 0;
		if (time.isAfter($Delivery._8PM))
			date = date.plusDays(1);

		while (!currDay.equals(targetDay)) {
			currDay = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

			for (int i = 0; i < list.size(); i++) {

				targetDay = list.get(i).getDay();

				if (targetDay.equals(currDay)) {
					index = i;
					break;
				}
			}

			if (targetDay.equals(currDay))
				break;
			date = date.plusDays(1);
		}

		for (int i = 0; i < dayCount; i++) {
			DoctorsTimeDTO dtd = null;

			if (i >= (list.size() - index))
				list.addAll(listCopy);
			dtd = new DoctorsTimeDTO(list.get(index));
			LocalDate dateOfDay = date
					.with(TemporalAdjusters.nextOrSame(DayOfWeek.valueOf(dtd.getDay().toUpperCase())));
			dtd.setDate(dateOfDay.toString());
			timedata.add(dtd);
			index += 1;
			date = dateOfDay.plusDays(1);

		}
		return timedata;
	}

	public List<DoctorsAppointmentDTO> getAllBookingByUser(String mobile) {

		return aRepo.findByPatientMobile(mobile);
	}

	public List<DoctorsAppointmentDTO> getAllBookingByStatus(String status) {

		return aRepo.findByStatus(status);
	}

	public List<DoctorsAppointmentDTO> getAllBookingByDr(String mobile) {

		return aRepo.findByMobile(mobile);
	}

	public String newBooking(DoctorsAppointmentVO vo) {
		Doctors d = repo.findByMobile(vo.getMobile());
		String bid = orderCodeGenerator.getOrderCode().toString();
		try {
			aRepo.save(new DoctorsAppointment(bid, vo.getMobile(), d.getCategory(), d.getArea(), d.getAddress(),
					d.getGps(), vo.getBookingSlot(), " ", d.getFees(), d.isHomeVisit(), d.getName(), "REQUESTED",
					vo.getPatient(), vo.getPatientMobile(), "", MyLocalDate.now()));
		} catch (Exception e) {
			bid = "Booking Failed Please Retry";
		}
		notificationManger.notifyUserMsg(vo.getPatientMobile(), "Hi " + vo.getPatient(),
				"Your Doctor Appointment is Requested we will notify once Booking Confirmed");

		return bid;
	}

	public void confirmBooking(String bookingId, String token, String info) {
		DoctorsAppointment da = aRepo.findByBookingId(bookingId);
		updateSql = new JdbcTemplate(dataSource);
		updateSql.update("Update doctors_appointment Set    status = ?,  info = concat(info,?) where boooking_id = ?",
				_Order._Status_Booked, info, bookingId);

		notificationManger.notifyUserMsg(da.getPatientMobile(), "Hi " + da.getPatient(),
				"Your Doctor Appointment is Confirmed \n  Token : " + token);
	}

	public void FailedBooking(String bookingId, String token, String info) {
		DoctorsAppointment da = aRepo.findByBookingId(bookingId);
		updateSql = new JdbcTemplate(dataSource);
		updateSql.update("Update doctors_appointment Set    status = ?,  info = concat(info,?) where boooking_id = ?",
				_Order._Status_Failed, info, bookingId);

		notificationManger.notifyUserMsg(da.getPatientMobile(), "Hi " + da.getPatient(),
				"Your Doctor Appointment is Failed check app for more details: ");
	}

}
