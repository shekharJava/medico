package com.oderzy.customer.model.query;

public class CustomerAddressQuery {

	public static final String getCustomerAddressCountByMobile = "select  count(c.id) from customer_address c where c.user.mobile = :mobile";

	public static final String getCustomerInfoByMobile = "select new  com.oderzy.customer.dto.CustomerInfo( c.user.mobile, c.user.name,  c.houseNo, c.road, c.area, c.user.area, c.landmark, c.city, c.phone, c.user.membership) from customer_address c where c.user.mobile = :mobile";

	public static final String getCustomerAreaCityByMobile = "select new  com.oderzy.dto.AreaCityDTO( c.city, c.area) from customer_address c where c.user.mobile = :mobile ";

	public static final String getCustomerProfileByMobile = "select new com.oderzy.customer.dto.CustomerProfileDTO( c.user.mobile, c.user.name,   c.phone,c.placeCode, c.houseNo, c.road, c.landmark, c.area) from customer_address c where c.user.mobile = :mobile";

	public static final String getAddressesByMobile = "select new com.oderzy.customer.dto.CustomerAddressDTO(c.id, c.phone, c.placeCode, c.houseNo, c.road, c.landmark, c.area, c.city, c.pincode ) from customer_address c where c.user.mobile = :mobile";

	public static final String getByRoad = "select new com.oderzy.customer.dto.CustomerDTO(c.user.mobile, c.user.name,  c.user.area) from customer_address c where c.road = :road";

	public static final String getByLandmark = "select new com.oderzy.customer.dto.CustomerDTO(c.user.mobile, c.user.name,  c.user.area) from customer_address c where c.landmark = :landmark";

	public static final String getByCity = "select new com.oderzy.customer.dto.CustomerDTO(c.user.mobile, c.user.name,  c.user.area) from customer_address c where c.city = :city";

	public static final String getByPincode = "select new com.oderzy.customer.dto.CustomerDTO(c.user.mobile, c.user.name,  c.user.area) from customer_address c where c.pincode = :pincode";

	public static final String getCoordinate = "select new com.oderzy.helper.distance.Coordinate(c.user.mobile, c.lattitude, c.longitude ,c.area) from customer_address c where c.user.mobile = :mobile";

	public static final String getAreaByMobile = "select c.user.area from customer_address c where c.user.mobile = :mobile";
	
	public static final String getCityByMobile = "select  c.city from customer_address c where c.user.mobile = :mobile";

	public static final String getAreaTypeByMobile = "select  c.area from customer_address c where c.user.mobile = :mobile";

	/* ,,,,,,,,,,,,,,,,,,,,,Sort Query,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,, */
	public static final String sortByRoad = "select new com.oderzy.customer.dto.CustomerDTO(c.user.mobile, c.user.name,  c.user.area) from customer_address c ORDER BY c.road ";

	public static final String sortByCity = "select new com.oderzy.customer.dto.CustomerDTO(c.user.mobile, c.user.name,  c.user.area) from customer_address c ORDER BY c.city ";

	public static final String sortByPincode = "select new com.oderzy.customer.dto.CustomerDTO(c.user.mobile, c.user.name,  c.user.area) from customer_address c ORDER BY c.pincode ";

	/*
	 * ,,,,,,,,,,,,,,,,,,,,,Sort Query In Area,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
	 */
	public static final String sortByJoinDateInArea = "select new com.oderzy.customer.dto.CustomerDTO(c.user.mobile, c.user.name,  c.user.area) from customer_address c where c.area = :area ORDER BY c. user.joinDate";

	public static final String sortByNameInArea = "select new com.oderzy.customer.dto.CustomerDTO(c.user.mobile, c.user.name,  c.user.area) from customer_address c where c.area = :area ORDER BY c.user.name ";

	/* ,,,,,,,,,,,,,,,,,,,,Updation Query...,,,,,,,,, */

	public static final String updatePlaceCode = "update  customer_address c  set c.placeCode = :placeCode where c.id = :id ";

	public static final String updateAddress = "update  customer_address c set c.phone = :phone, c.houseNo = :houseNo , c.road = :road , c.landmark = :landmark  where c.id = :id ";


	public static final String updatePhone = "update  customer_address c set c.phone = :phone where c.id = :id";


	public static final String updateCoordinates = "update  customer_address c  set c.lattitude = :lat, c.longitude = :lon where c.id = :id ";


}
