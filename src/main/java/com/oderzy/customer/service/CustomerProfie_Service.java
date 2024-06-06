package com.oderzy.customer.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

import javax.transaction.Transactional;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oderzy.$config.constants.$Customer;
import com.oderzy._exception_.oderzy.NoRecordFound;
import com.oderzy._notification.service.NotificationManger;
import com.oderzy.customer.dto.AdsData;
import com.oderzy.customer.dto.BannerData;
import com.oderzy.customer.dto.CustomerAddressDTO;
import com.oderzy.customer.dto.CustomerDTO;
import com.oderzy.customer.dto.CustomerHelpDTO;
import com.oderzy.customer.dto.CustomerInfo;
import com.oderzy.customer.dto.CustomerProfileDTO;
import com.oderzy.customer.dto.ViewData;
import com.oderzy.customer.model.Customer;
import com.oderzy.customer.model.CustomerAddress;
import com.oderzy.customer.model.CustomerHelp;
import com.oderzy.customer.model.CustomerPoints;
import com.oderzy.customer.model.CustomerRefer;
import com.oderzy.customer.repositery.CustomerAddressRepositery;
import com.oderzy.customer.repositery.CustomerHelpRepositery;
import com.oderzy.customer.repositery.CustomerPointsRepositery;
import com.oderzy.customer.repositery.CustomerReferRepositery;
import com.oderzy.customer.repositery.CustomerRepositery;
import com.oderzy.customer.vo.NewCustomerVO;
import com.oderzy.helper.CallCodeGenerator;
import com.oderzy.helper.CustomerCodeGenerator;
import com.oderzy.wrapper.MyLocalDate;

@Service
public class CustomerProfie_Service {

	@Autowired
	private CustomerRepositery repo;
	@Autowired
	private CustomerAddressRepositery addressRepo;
	@Autowired
	private CustomerCodeGenerator idGenerator;
	@Lazy
	@Autowired
	private NotificationManger notificationManger;
	@Autowired
	private CustomerHelpRepositery helpRepo;
	@Autowired
	private CustomerPointsRepositery pointRepo;
	@Autowired
	private CustomerReferRepositery referRepo;
	public static List<AdsData> ads;
	public static List<BannerData> banners;
	public static List<ViewData> viewsData;

	@Autowired
	private CallCodeGenerator helpidGenerator;

	/*
	 * ============================================================
	 * ----------------- Customer Profile -------------------
	 * ===========================================================
	 */
	

	/* .........................Search Service by input--------------- */

	public CustomerDTO getByMobile(String mobile) {
		CustomerDTO customer = repo.getByMobile(mobile);

		if (customer == null)
			throw new NoRecordFound("Customer Not exists with given mobile " + mobile);

		return customer;
	}

	public String isMember(String mobile) {
		if (repo.countByMobile(mobile) != 0) {
			return "YES";
		}
		return "NO";
	}

	public CustomerDTO getUserName(String mobile) {

		CustomerDTO customer = repo.getByMobile(mobile);

		return customer;
	}

	public String getDeviceId(String mobile) {

		return repo.getDeviceByMobile(mobile);

	}

	public CustomerDTO getByCustId(String custId) {
		CustomerDTO customer = repo.getByCustId(custId);

		if (customer == null)
			throw new NoRecordFound("Customer Not exists");

		return customer;
	}

	public String getCustomerArea(String customerMobile) {
		return repo.getAreaByMobile(customerMobile);
	}

	public String getCustomerCity(String mobile) {
		return addressRepo.getCityByMobile(mobile);
	}
	public String getCustomerAreaType(String mobile) {
		return addressRepo.getAreaTypeByMobile(mobile);
	}


	public List<CustomerDTO> getByArea(String area) {
		return repo.getByArea(area);
	}

	public List<CustomerDTO> getByjoinDate(String joinDate) {
		return repo.getByjoinDate(joinDate);
	}

	public List<CustomerDTO> getByName(String name) {
		List<CustomerDTO> customers = repo.getByName(name);

		if (customers.isEmpty())
			throw new NoRecordFound("Customer Not exists with given name " + name);

		return customers;
	}

	public List<CustomerDTO> getByNameStart(String name) {
		return repo.getByNameStart(name);
	}

	public List<CustomerDTO> getByNameEnd(String name) {
		return repo.getByNameEnd(name);
	}

	public List<CustomerDTO> getByNameContains(String name) {
		return repo.getByNameContains(name);
	}

	/* ,,,,,,,,,,,,,,,,,,,,,Sort Service,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,, */
	public List<CustomerDTO> sortByJoinDate() {
		return repo.sortByJoinDate();
	}

	public List<CustomerDTO> sortByArea() {
		return repo.sortByArea();
	}

	/* ,,,,,,,,,,,,,,,,,,,,Updation Service...,,,,,,,,, */

	public void sendNotificationToUser(String mobile, String title, String msg, String image) {
		String _msg = repo.getByMobile(mobile).getName();
		msg = _msg + msg;
		notificationManger.notifyUserMsg(mobile, title, msg, image);
	}

	public int updateName(String name, String mobile) {
		return repo.updateName(name, mobile);
	}

	public int updateStatus(String status, String mobile) {
		return repo.updateStatus(status, mobile);
	}

	public Customer updatePassword(String mobile, String password) {

		Customer c = repo.findByMobile(mobile);
		try {
			c.setPassword(password);
		} catch (NullPointerException n) {

			throw new NoRecordFound();
		}
		return repo.save(c);

	}

	
	public int updateArea(String area, String mobile) {
		return repo.updateArea(area, mobile);
	}

	public String isUserExists(String mobile) {
		return repo.getPassForUser(mobile, $Customer.Status$Active);
	}

	// Version 49

	@Transactional
	public String addNewProfile(String mobile, String city) {
		return addNewProfile(mobile, city, "Sambalpur");
	}

	@Transactional
	public String addNewProfile(String mobile, String city, String cityarea) {
		Customer customer = new Customer();
		String area = null;
		int pincode = 0;
		if (city.equals("Sambalpur") || city.equals("Burla")) {
			area = "SBP001";
			pincode = 768001;
		} else if (city.equals("Jamshedpur")) {
			area = "JSR001";
			pincode = 831001;
		} else if (city.equals("Patna") || city.equals("Banglore")) {
			area = "BLR001";
			pincode = 831001;
		}
		customer.setCustId(idGenerator.getCustomerCode());
		customer.setArea(area);
		customer.setPoint(0);
		customer.setMembership($Customer.$trial);
		customer.setMobile(mobile);
		customer.setJoinDate(new Date());
		customer.setPassword("pass");
		customer.setName("Guest");
		customer.setStatus($Customer.Status$Active);

		try {
			customer = repo.save(customer);
			CustomerAddress customerAddress = new CustomerAddress(customer, idGenerator.getCustomerAddressCode(),
					mobile, " ", " ", " ", "Inner", city, pincode);
			addressRepo.save(customerAddress);
			this.newPointSummary(mobile, "New User Welcome Balance", 30);
			notificationManger.notifyNewUserOffer(mobile);
		} catch (org.springframework.dao.DataIntegrityViolationException ex) {

			throw new NoRecordFound();
		}
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				    Thread.currentThread().interrupt();

				}
		
				notificationManger.notifyNewUserOffer(mobile);
			}

		});
		return area;
	}

	@Transactional
	public CustomerInfo saveAdrs(NewCustomerVO cv) {
		Customer c = repo.findByMobile(cv.getMobile());
		CustomerAddress ad = addressRepo.findFirstByUser_Mobile(cv.getMobile());

		c.setPassword(cv.getPassword());
		c.setName(cv.getName());
		c.setMembership($Customer.$newMembership);
		repo.save(c);
		ad.setLandmark(cv.getLandmark());
		ad.setRoad(cv.getRoad());
		addressRepo.save(ad);
		if (cv.getRefer().length() == 10)
			this.newReferal(cv.getMobile(), cv.getRefer());

		return this.getCustomerInfoByMobile(cv.getMobile());
	}


	/* ============================================================
	 * ----------------- Customer Address -------------------
	 * ===========================================================
	 */

	
	public CustomerInfo getCustomerInfoByMobile(String customerMobile) {
		CustomerInfo user;
		try {
			user = addressRepo.getCustomerInfoByMobile(customerMobile);
			user.getArea();
			return user;
		} catch (NullPointerException n) {

			try {
				user = repo.getCustomerInfoByMobile(customerMobile, $Customer.Status$Active);
				user.getClass();
				return user;
			} catch (NullPointerException nx) {

				throw new NoRecordFound("Customer doesn't exists");
			}
		}
	}

	public CustomerProfileDTO getCustomerProfileByMobile(String mobile, boolean status) {
		return addressRepo.getCustomerProfileByMobile(mobile);
	}

	public CustomerAddressDTO getAddressByMobile(String mobile) {
		return addressRepo.getAddressesByMobile(mobile);
	}

	public List<CustomerDTO> getByRoad(String road) {
		return addressRepo.getByRoad(road);
	}

	public List<CustomerDTO> getByLandmark(String landmark) {
		return addressRepo.getByLandmark(landmark);
	}

	public List<CustomerDTO> getByCity(String city) {
		return addressRepo.getByCity(city);
	}

	public List<CustomerDTO> getByPincode(int pincode) {
		return addressRepo.getByPincode(pincode);
	}

	/* ,,,,,,,,,,,,,,,,,,,,,Sort Query,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,, */
	public List<CustomerDTO> sortByRoad() {
		return addressRepo.sortByRoad();
	}

	public List<CustomerDTO> sortByCity() {
		return addressRepo.sortByCity();
	}

	public List<CustomerDTO> sortByPincode() {
		return addressRepo.sortByPincode();
	}

	/*
	 * ,,,,,,,,,,,,,,,,,,,,,Sort Query In Area,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
	 */
	public List<CustomerDTO> sortByJoinDateInArea(String area) {
		return addressRepo.sortByJoinDateInArea(area);
	}

	public List<CustomerDTO> sortByNameInArea(String area) {
		return addressRepo.sortByNameInArea(area);
	}

	/* ,,,,,,,,,,,,,,,,,,,,Updation Query...,,,,,,,,, */

	public int updatePlaceCode(String placeCode, String id) {
		return addressRepo.updatePlaceCode(placeCode, id);
	}

	public int updatePhone(String phone, String id) {
		return addressRepo.updatePhone(phone, id);
	}

	

	@Transactional
	public int updateCoordinates(double lat, double lon, String id) {
		this.updatePlaceCode("https://www.google.com/search?q=" + lat + "+" + lon, id);
		return addressRepo.updateCoordinates(lat, lon, id);
	}

	/*
	 * ============================================================
	 * ----------------- Customer help -------------------
	 * ===========================================================
	 */
	@Transactional
	public void newComplaint(CustomerHelpDTO help) {
		help.setHelpId(helpidGenerator.getCallerCode());
		help.setTime(MyLocalDate.now());
		helpRepo.save(CustomerHelp.build(help));
		String msg = help.getName() + "\n" + help.getQuery();
		notificationManger.notifyStaffNewComplaint(help.getMobile(), msg);
	}

	public void replyComplaint(String mobile, String id, String msg) {
		CustomerHelp help = helpRepo.getByHelpIdAndMobile(id, mobile);
		help.setQuery(help.getQuery() + "\nOderzy:\n" + msg);
		helpRepo.save(help);
		notificationManger.notifyUserReplyOfComplaint(mobile, msg);
	}

	public List<CustomerHelpDTO> getComplaintsActive(int page) {

		return helpRepo.findByStatus($Customer.$ComplaintActive);
	}

	public List<CustomerHelpDTO> getComplaintsByUser(String mobile, int page) {

		return helpRepo.findByMobileOrderByTime(mobile);
	}

	public void setViews(List<ViewData> data) {
		CustomerProfie_Service.viewsData = data;
	}

	public void addViews(ViewData data) {
		CustomerProfie_Service.viewsData.add(data);
	}

	public void setBanners(List<BannerData> data) {
		CustomerProfie_Service.banners = data;
	}

	public void addBanners(BannerData data) {
		CustomerProfie_Service.banners.add(data);
	}

	public void addNotifyDevice(String mobile, String deviceId) {
		Customer customer = repo.findByMobile(mobile);
		customer.setDeviceId(deviceId);
		repo.save(customer);
	}

	/*
	 * ============================================================
	 * ----------------- Customer Points -------------------
	 * ===========================================================
	 */
	public double getPointBalance(String mobile) {
		return repo.checkPointBalance(mobile);
	}
	@Transactional
	public int updatePointBalance(String mobile, double point) {
		String msg = "";
		if (point > 0)
			msg = "Points Added for extra cash paid";
		else
			msg = "Points Deducted for less amount paid";
		return this.newPointSummary(mobile, msg, point);

	}

	public List<CustomerPoints> getPointUsage(String mobile, Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo, 6);
		return pointRepo.findAllByOrderByMobileAsc(mobile, pageable);
	}

	@Transactional
	public int newPointSummary(String mobile, String details, double point) {
		String summary = details + " \n" + (LocalDate.now().toString());
		pointRepo
				.save(new CustomerPoints(helpidGenerator.getCallerCode(), mobile, summary, point, LocalDateTime.now()));
		return repo.updatePointBalance(mobile, point);
	}

	/*
	 * ============================================================
	 * ----------------- Customer Refers -------------------
	 * ===========================================================
	 */
	public List<CustomerRefer> getRefered(String mobile) {
		return referRepo.findByReferMobile(mobile);
	}

	public List<CustomerRefer> getAllRefered() {
		return referRepo.findAll();
	}

	public CustomerRefer newReferal(String mobile, String referBy) {

		return referRepo.save(new CustomerRefer(mobile, referBy, "New User"));
	}

}
