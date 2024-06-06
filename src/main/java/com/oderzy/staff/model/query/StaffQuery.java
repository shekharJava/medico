package com.oderzy.staff.model.query;

public class StaffQuery {

	public static final String validate =  "select c.staffId from Staff c where c.mobile = :mobile And c.password = :pwd  And c.status = :status";

	public static final String getByStaffId = "select new com.oderzy.staff.dto.StaffDTO(s.staffId, s.mobile, s.name, s.area) from Staff s where s.staffId = :staffId";

	public static final String getByMobileComplete = "select new com.oderzy.staff.dto.StaffProfileDTO(s.staffId, s.secondaryMobile, s.mobile, s.name, s.email, s.dob, s.line1, s.city, s.pincode, s.joinDate, s.identityType, s.identityProof, s.hiringManger) from Staff s where s.mobile = :mobile";

	public static final String getByMobile = "select new com.oderzy.staff.dto.StaffDTO(s.staffId, s.mobile, s.name, s.area, s.authority) from Staff s where s.mobile = :mobile";

	public static final String getBySecondaryMobile = "select new com.oderzy.staff.dto.StaffDTO(s.staffId, s.mobile, s.name, s.area) from Staff s where s.secondaryMobile = :mobile";

	public static final String getByName = "select new com.oderzy.staff.dto.StaffDTO(s.staffId, s.mobile, s.name, s.area) from Staff s where s.name Like %:name";

	public static final String getByCity = "select new com.oderzy.staff.dto.StaffDTO(s.staffId, s.mobile, s.name, s.area) from Staff s where s.city = :city";

	public static final String getByHiringManger = "select new com.oderzy.staff.dto.StaffDTO(s.staffId, s.mobile, s.name, s.area) from Staff s where s.hiringManger = :hiringManger";

	public static final String getByJoinDate = "select new com.oderzy.staff.dto.StaffDTO(s.staffId, s.mobile, s.name, s.area) from Staff s where s.joinDate = :joinDate";

	public static final String sortByHiringManger = "select new com.oderzy.staff.dto.StaffDTO(s.staffId, s.mobile, s.name, s.area) from Staff s ORDER BY s.hiringManger";

	public static final String sortByJoinDate = "select new com.oderzy.staff.dto.StaffDTO(s.staffId, s.mobile, s.name, s.area) from Staff s ORDER BY s.joinDate";

	/*-----------------Updation Query-------------------*/
	public static final String updateMobile = "Update Staff s set s.mobile = :newmobile where s.mobile = :mobile";

	public static final String updateSecondaryMobile = "Update Staff s set s.secondaryMobile = :newmobile where s.mobile = :mobile";

	public static final String updateEmail = "Update Staff s set s.email = :email where s.mobile = :mobile";

	public static final String updateName = "Update Staff s set s.name = :name where s.mobile = :mobile";

	public static final String updateDOB = "Update Staff s set s.dob = :dob where s.mobile = :mobile";

	public static final String updatePassword = "Update Staff s set s.password = :password where s.mobile = :mobile";

	public static final String updateIdentity = "Update Staff s set s.identityType = :identityType , s.identityProof = :identityProof where s.mobile = :mobile";

	public static final String updateAddress = "Update Staff s set s.line1 = :line1 , s.city = :city , s.pincode = :pincode where s.mobile = :mobile";


}
