package com.oderzy.staff.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oderzy._exception_.oderzy.InvalidOTP;
import com.oderzy._notification.service.NotificationManger;
import com.oderzy.staff.dto.StaffDTO;
import com.oderzy.staff.dto.StaffProfileDTO;
import com.oderzy.staff.dto.StaffVO;
import com.oderzy.staff.model.Staff;
import com.oderzy.staff.repositery.StaffRepositery;
import com.oderzy.vo.UserProfile;

@Service
public class StaffService {

	@Autowired
	private StaffRepositery repo;

	@Autowired
	private NotificationManger notificationManger;

	public StaffDTO profileByStaffId(int staffId) {
		return repo.getByStaffId(staffId);
	}

	public StaffProfileDTO profileByMobileComplete(String mobile) {
		return repo.getByMobileComplete(mobile);
	}

	public StaffDTO profileByMobile(String mobile) {
		return repo.getByMobile(mobile);
	}

	public StaffDTO profileBySecondaryMobile(String mobile) {
		return repo.getBySecondaryMobile(mobile);
	}

	public List<StaffDTO> profilesByName(String name) {
		return repo.getByName(name);
	}

	public List<StaffDTO> profilesByCity(String city) {
		return repo.getByCity(city);
	}

	public List<StaffDTO> profilesByJoinDate(Date joinDate) {
		return repo.getByJoinDate(joinDate);
	}

	public List<StaffDTO> sortProfilesByJoinDate() {
		return repo.sortByJoinDate();
	}

	/*-----------------Updation Query-------------------*/
	public int updateMobile(String newmobile, String mobile) {
		return repo.updateMobile(newmobile, mobile);
	}

	public int updateEmail(String email, String mobile) {
		return repo.updateEmail(email, mobile);
	}

	public int updateSecondaryMobile(String newmobile, String mobile) {
		return repo.updateSecondaryMobile(newmobile, mobile);
	}

	public int updateName(String name, String mobile) {
		return repo.updateName(name, mobile);
	}

	public int updateDOB(Date dob, String mobile) {
		return repo.updateDOB(dob, mobile);
	}

	public int updatePassword(String password, String mobile, String otp) {
		if (notificationManger.getOTP(mobile).equals(otp)) {

			return repo.updatePassword(password, mobile);
		}
		throw new InvalidOTP();
	}

	public void passwordResetRequest(String mobile, String deviceid, String appType) {
		notificationManger.addPasswordReset(mobile, deviceid, appType);
	}

	public int updateIdentity(String identityType, String identityProof, String mobile) {
		return repo.updateIdentity(identityType, identityProof, mobile);
	}

	public int updateAddress(String line1, String city, int pincode, String mobile) {
		return repo.updateAddress(line1, city, pincode, mobile);
	}

	public Staff registerNewStaff(UserProfile p, int hiringManager) {

		Staff staff = new Staff(p.mobile, p.mobileHome, p.name, p.email, p.password, p.dob, p.line1, p.city, p.pincode,
				new Date(), p.identityType, p.identityProof, hiringManager);
		return repo.save(staff);

	}

	public Staff add(StaffVO staff) {
		return repo.save(new Staff(staff));
	}

}
