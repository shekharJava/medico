package com.oderzy.customer.model.query;

public class CustomerQuery {

	/* .........................Search Query by input--------------- */
	public static final String allMobile = "select c.mobile from Customer c where c.status =  :status";

	public static final String validate = "select c.custId from Customer c where c.mobile = :mobile And c.password = :pwd And c.status = :status";
	public static final String validate1 = "select c.custId from Customer c where c.mobile = :mobile And c.status = :status";
	public static final String authenticate = "select c.password from Customer c where c.mobile = :mobile And c.status = :status";

	public static final String getAreaByMobile = "select  c.area from Customer c where c.mobile = :mobile";
	public static final String getDeviceByMobile = "select  c.deviceId from Customer c where c.mobile = :mobile";

	public static final String getNameByMobile = "select  c.name from Customer c where c.mobile = :mobile";
	public static final String getCustomerInfoByMobile = "select new  com.oderzy.customer.dto.CustomerInfo( c.mobile, c.name,  c.area) from Customer c where c.mobile = :mobile AND c.status = :status";
	public static final String checkPointBalance = "Select c.point from Customer c where c.mobile = :mobile";

	public static final String getByMobile = "select new com.oderzy.customer.dto.CustomerDTO( c.mobile, c.name,  c.area) from Customer c where c.mobile = :mobile";

	public static final String getByCustId = "select new com.oderzy.customer.dto.CustomerDTO( c.mobile, c.name,  c.area) from Customer c where c.custId = :custId ";
	public static final String getByArea = "select new com.oderzy.customer.dto.CustomerDTO( c.mobile, c.name,  c.area) from Customer c where c.area = :area";

	public static final String getByjoinDate = "select new com.oderzy.customer.dto.CustomerDTO( c.mobile, c.name,  c.area) from Customer c where c.joinDate = :joinDate";

	public static final String getByName = "select new com.oderzy.customer.dto.CustomerDTO( c.mobile, c.name,  c.area) from Customer c where  c.name = Upper(:name)";
	public static final String getByNameStart = "select new com.oderzy.customer.dto.CustomerDTO( c.mobile, c.name,  c.area) from Customer c where  c.name Like %:name";
	public static final String getByNameEnd = "select new com.oderzy.customer.dto.CustomerDTO( c.mobile, c.name,  c.area) from Customer c where  c.name Like :name%";
	public static final String getByNameContains = "select new com.oderzy.customer.dto.CustomerDTO( c.mobile, c.name,  c.area) from Customer c where  c.name  Like %:name%";

	/* ,,,,,,,,,,,,,,,,,,,,,Sort Query,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,, */
	public static final String sortByJoinDate = "select new com.oderzy.customer.dto.CustomerDTO( c.mobile, c.name,  c.area) from Customer c ORDER BY c. joinDate";
	public static final String sortByArea = "select new com.oderzy.customer.dto.CustomerDTO( c.mobile, c.name,  c.area) from Customer c ORDER BY c.area ";

	/* ,,,,,,,,,,,,,,,,,,,,Updation Query...,,,,,,,,, */

	public static final String updateName = "update  Customer c set c.name = :name where c.mobile = :mobile";
	public static final String updatePassword = "update  Customer c set c.password = :newpwd where c.mobile = :mobile And c.password = :password";
	public static final String updateArea = "update  Customer c set c.area = :area where c.mobile = :mobile";
	public static final String updateStatus = "update  Customer c set c.status = :status where c.mobile = :mobile";

	public static final String updatePoint = "update  Customer c set c.point = c.point + :point where c.mobile = :mobile";;
}
