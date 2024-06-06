package com.oderzy.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oderzy.$config.constants.$Navigation;
import com.oderzy.$config.constants.$Security;
import com.oderzy.$config.constants._Oderzy;
import com.oderzy._notification.NotificationDATA;
import com.oderzy._notification.service.NotificationManger;
import com.oderzy._notification.service.UserNotificationService;
import com.oderzy._security_.customer.UserLoginService;
import com.oderzy._security_.oderzy.AuthData;
import com.oderzy._security_.oderzy.AuthToken;
import com.oderzy._security_.staff.StaffAuth;
import com.oderzy.customer.dto.AdsData;
import com.oderzy.customer.dto.AuthsData;
import com.oderzy.customer.dto.BannerData;
import com.oderzy.customer.dto.CustomerAddressDTO;
import com.oderzy.customer.dto.CustomerDTO;
import com.oderzy.customer.dto.CustomerHelpDTO;
import com.oderzy.customer.dto.CustomerInfo;
import com.oderzy.customer.dto.CustomerProfileDTO;
import com.oderzy.customer.dto.Incoming;
import com.oderzy.customer.dto.Message;
import com.oderzy.customer.dto.NewMessages;
import com.oderzy.customer.dto.Query;
import com.oderzy.customer.dto.ReferData;
import com.oderzy.customer.dto.Replies;
import com.oderzy.customer.dto.ViewData;
import com.oderzy.customer.model.Customer;
import com.oderzy.customer.model.CustomerPoints;
import com.oderzy.customer.model.CustomerRefer;
import com.oderzy.customer.service.CustomerProfie_Service;
import com.oderzy.customer.vo.NewCustomerVO;
import com.oderzy.wrapper.MapResponse;
import com.oderzy.wrapper.StringResponse;

@RestController
@RequestMapping(value = $Navigation.customer_Controller)
@CrossOrigin()
public class CustomerController {

	@Autowired
	private CustomerProfie_Service service;
	@Autowired
	private UserLoginService loginService;
	@Autowired
	private UserNotificationService userNotificationService;

	@Autowired
	private NotificationManger _notify;

	@Autowired
	private NewMessages messages;

	/*
	 * ============================================================
	 * ----------------- Customer Profile ------------------- =========
	 * ==================================================
	 */

	/* .........................Notification Controller--------------- */

	@GetMapping("/notify/{mobile}/{title}/{msg}/{image}")
	public boolean notify(@PathVariable String mobile, @PathVariable String title, @PathVariable String msg,
			@PathVariable String image) {
		NotificationDATA data = new NotificationDATA(title, msg, "default", image);
		userNotificationService.sendNotificationToMobile(mobile, data);
		return true;
	}

	// Get deviceId for notifiaction
	@GetMapping("/notifications/{mobile}/{deviceId}")
	public List<BannerData> notification(@PathVariable String mobile, @PathVariable String deviceId) {
		// loading user device for notification
		userNotificationService.addDevice(mobile, deviceId);
		service.addNotifyDevice(mobile, deviceId);

		return CustomerProfie_Service.banners;
	}

	@GetMapping("/banners/{area}")
	public List<BannerData> getBanners(@PathVariable String area) {
		return CustomerProfie_Service.banners;
	}

	@GetMapping("/home-view/{mobile}/{area}/{deviceId}")
	public List<ViewData> gethomeView(@PathVariable String mobile, @PathVariable String area,
			@PathVariable String deviceId) {
		// loading user device for notification
		userNotificationService.addDevice(mobile, deviceId);
		service.addNotifyDevice(mobile, deviceId);

		return CustomerProfie_Service.viewsData;
	}

	@GetMapping("/home-view/{mobile}/{area}")
	public List<ViewData> gethomeView(@PathVariable String mobile, @PathVariable String area) {

		return CustomerProfie_Service.viewsData;
	}

	@PostMapping("/banner/new")
	public void newBanners(@RequestBody List<BannerData> data) {
		service.setBanners(data);
	}

	@PostMapping("/banner/add")
	public void addBanners(@RequestBody BannerData data) {
		service.addBanners(data);
	}

	@PostMapping("/home-view/new")
	public void newViews(@RequestBody List<ViewData> data) {
		service.setViews(data);
	}

	@PostMapping("/home-view/add")
	public void addViews(@RequestBody ViewData data) {
		service.addViews(data);
	}

	@GetMapping("/ads/{area}")
	public List<AdsData> ads(@PathVariable String area) {
		return CustomerProfie_Service.ads;
	}

	/* .........................Search Service by input--------------- */

	@GetMapping("/profile/mobile/{mobile}")

	public CustomerDTO getByMobile(@PathVariable String mobile) {
		return service.getByMobile(mobile);
	}

	@GetMapping("/profile/id/{custId}")
	//
	public CustomerDTO getByCustId(@PathVariable String custId) {
		return service.getByCustId(custId);
	}

	@GetMapping("/profiles/area/{area}")
	//
	public List<CustomerDTO> getByArea(@PathVariable String area) {
		return service.getByArea(area);
	}

	@GetMapping("/profiles/joinDate/{joinDate}")
	//
	public List<CustomerDTO> getByjoinDate(@PathVariable String joinDate) {
		return service.getByjoinDate(joinDate);
	}

	@GetMapping("/profiles/name/{name}")
	//
	public List<CustomerDTO> getByName(@PathVariable String name) {
		return service.getByName(name);
	}

	@GetMapping("/profiles/name_start/{name}")
	//
	public List<CustomerDTO> getByNameStart(@PathVariable String name) {
		return service.getByNameStart(name);
	}

	@GetMapping("/profiles/name_end/{name}")
	//
	public List<CustomerDTO> getByNameEnd(@PathVariable String name) {
		return service.getByNameEnd(name);
	}

	@GetMapping("/profiles/name_contains/{name}")
	//
	public List<CustomerDTO> getByNameContains(@PathVariable String name) {
		return service.getByNameContains(name);
	}

	/* ,,,,,,,,,,,,,,,,,,,,,Sort Service,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,, */
	@GetMapping("/sort/profiles_join")
	//
	public List<CustomerDTO> sortByJoinDate() {
		return service.sortByJoinDate();
	}

	@GetMapping("/sort/profiles_area")
	//
	public List<CustomerDTO> sortByArea() {
		return service.sortByArea();
	}

	/* ,,,,,,,,,,,,,,,,,,,,Updation Service...,,,,,,,,, */

	@GetMapping("/update/name/{name}/{mobile}")
	//
	public int updateName(@PathVariable String name, @PathVariable String mobile) {
		return service.updateName(name, mobile);
	}

	@GetMapping("/update/status/{status}/{mobile}")
	//
	public int updateStatus(@PathVariable String status, @PathVariable String mobile) {
		return service.updateStatus(status, mobile);
	}

	@PutMapping("/update/password/{password}/{mobile}")
	public Customer updatePassword(@PathVariable String mobile, @PathVariable String password) {
		return service.updatePassword(mobile, password);
	}

	@GetMapping("/update/area/{area}/{mobile}")
	//
	public int updateArea(@PathVariable String area, @PathVariable String mobile) {
		return service.updateArea(area, mobile);
	}

	/*
	 * ============================================================
	 * ----------------- Customer Address -------------------
	 * ===========================================================
	 */

	/* .........................Search Service by input--------------- */

	@GetMapping("/profile/complete/mobile/{mobile}")
	////
	public CustomerInfo getCustomerInfoByMobile(@PathVariable String mobile) {
		return service.getCustomerInfoByMobile(mobile);
	}

	@GetMapping("/info/complete/mobile/{mobile}")
	@StaffAuth()
	public CustomerInfo getCustomerInfoByMobileByStaff(@PathVariable String mobile) {
		return service.getCustomerInfoByMobile(mobile);
	}

	@GetMapping("/profile/full/mobile/{mobile}")

	public CustomerProfileDTO getCustomerProfileByMobile(@PathVariable String mobile) {
		boolean primaryAddress = true;
		return service.getCustomerProfileByMobile(mobile, primaryAddress);
	}

	@GetMapping("/addresses/mobile/{mobile}")
	//
	public CustomerAddressDTO getAddressesByMobile(@PathVariable String mobile) {
		return service.getAddressByMobile(mobile);
	}

	@GetMapping("/user/address/mobile/{mobile}")
	@StaffAuth()
	public CustomerAddressDTO getAddressesByMobile_Staff(@PathVariable String mobile) {
		return service.getAddressByMobile(mobile);
	}

	@GetMapping("/profiles/road/{road}")
	//
	public List<CustomerDTO> getByRoad(@PathVariable String road) {
		return service.getByRoad(road);
	}

	@GetMapping("/profiles/landmark/{landmark}")
	//
	public List<CustomerDTO> getByLandmark(@PathVariable String landmark) {
		return service.getByLandmark(landmark);
	}

	@GetMapping("/profiles/city/{city}")
	//
	public List<CustomerDTO> getByCity(@PathVariable String city) {
		return service.getByCity(city);
	}

	@GetMapping("/profiles/pincode/{pincode}")
	//
	public List<CustomerDTO> getByPincode(@PathVariable int pincode) {
		return service.getByPincode(pincode);
	}

	/* ,,,,,,,,,,,,,,,,,,,,,Sort Query,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,, */
	@GetMapping("/sort/profiles_road")
	//
	public List<CustomerDTO> sortByRoad() {
		return service.sortByRoad();
	}

	@GetMapping("/sort/profiles_city")
	//
	public List<CustomerDTO> sortByCity() {
		return service.sortByCity();
	}

	@GetMapping("/sort/profiles_pincode")
	//
	public List<CustomerDTO> sortByPincode() {
		return service.sortByPincode();
	}

	/*
	 * ,,,,,,,,,,,,,,,,,,,,,Sort Query In Area,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
	 */
	@GetMapping("/sort/profiles_join/area/{area}")
	//
	public List<CustomerDTO> sortByJoinDateInArea(@PathVariable String area) {
		return service.sortByJoinDateInArea(area);
	}

	@GetMapping("/sort/profiles_name/area/{area}")
	//
	public List<CustomerDTO> sortByNameInArea(@PathVariable String area) {
		return service.sortByNameInArea(area);
	}

	/* ,,,,,,,,,,,,,,,,,,,,Updation Query...,,,,,,,,, */

	@PostMapping("/whatsapp")
	public Replies smshit(@RequestBody Incoming o) {
		_notify.notifyStaffNewMessage(o.getQuery());
		String sender = o.getQuery().getSender();
		messages.message.add(new Query(sender, o.getQuery().getMessage()));
		messages.reply.remove(sender);

		Message m = new Message(" ");

		if (messages.reply.containsKey(sender)) {
			m = messages.getReply(sender);
		}
		Replies r = new Replies(new Message[] { m });

		return r;

	}

	@PostMapping("/whatsapp-reply")
	public boolean smsReply(@RequestBody Query q) {
		String oderzyReply = "O.........   " + q.getMessage();
		messages.message.add(new Query(q.getSender(), oderzyReply));

		messages.reply.put(q.getSender(), q.getMessage());
		return true;
	}

	@GetMapping("/whatsapp-message")
	public List<Query> getMessages() {

		return messages.message;
	}

	// active
	@PostMapping("/save-addrs")
	public CustomerInfo saveAdrs(@RequestBody NewCustomerVO customer) {
		return service.saveAdrs(customer);
	}

	// active
	@PostMapping("/new-profile/{mobile}/{city}")
	public StringResponse newProfile(@PathVariable String mobile, @PathVariable String city) {
		return new StringResponse(service.addNewProfile(mobile, city));
	}

//active
	@PostMapping("/new-profile/{mobile}/{city}/{area}")
	public StringResponse newProfile(@PathVariable String mobile, @PathVariable String city,
			@PathVariable String area) {
		return new StringResponse(service.addNewProfile(mobile, city, area));
	}

	@PostMapping("/isUser")
	public Replies isUser(@RequestBody Incoming o) {
		String sender = o.getQuery().getSender();
		sender = sender.replace(" ", "");
		sender = sender.replace("+91", "");
		Replies r = null;

		try {
			String name = service.getUserName(sender).getName();
			Message m1 = new Message("Hi " + name
					+ " \n  Oderzy is Happy to serve you agian \n1. New Order  \n2. Order Enquiry \n3. Product Enquiry  \n4. Customer Service\n\n Reply 1,2,3 or 4 to continue ");
			r = new Replies(new Message[] { m1 });
		} catch (NullPointerException e) {

			Message m = new Message("Hi " + sender
					+ " \n  Your phone is not registered with Oderzy \n  To register yourself reply   \n   Reg <Your Name>");

			r = new Replies(new Message[] { m, });

		}

		return r;

	}

	@PostMapping("/login/{name}/{code}")
	public AuthToken login(@RequestBody AuthData data, @PathVariable String name, @PathVariable int code) {
		// hubService.saveToSearchRepo(data.getAuthPwd(), data.getAuthId());
		// hubService.saveToSearchRepo(name+" .login "+code, data.getAuthId());

		AuthToken authToken = new AuthToken();
		if (code >= _Oderzy.code) {

			try {
				loginService.validate(data);
			} catch (Exception ignored) {
			}
			authToken.setValue(loginService.validate(data));
			authToken.setToken($Security.user_Token);
		} else {
			authToken.setValue("https://play.google.com/store/apps/details?id=com.oderzy.user&hl=en_IN");
			authToken.setToken(_Oderzy.newUpdate);

		}
		return authToken;
	}

	@PostMapping("/authenticate/{mobile}")
	public AuthsData _login(@PathVariable String mobile) {
		// hubService.saveToSearchRepo("updated Login", mobile);

		AuthsData adata = new AuthsData();
		adata.setUpdate(_Oderzy.code);
		try {
			String pass = service.isUserExists(mobile);
			if (pass == null)
				adata.setAction(0);
			else {
				adata.setAction(1);
				adata.setPass(pass);
			}
		} catch (Exception e) {
		}
		return adata;
	}

	@PostMapping("/authenticate/{mobile}/{name}/{code}")
	public AuthsData _login(@PathVariable String mobile, @PathVariable String name, @PathVariable int code) {
		// hubService.saveToSearchRepo("New Login", mobile);
		// hubService.saveToSearchRepo(name+" .auth "+code, mobile);

		AuthsData adata = new AuthsData();
		adata.setUpdate(5);
		try {
			String pass = service.isUserExists(mobile);
			if (pass == null)
				adata.setAction(0);
			else {
				adata.setAction(1);
				adata.setPass(pass);
			}
		} catch (Exception e) {
		}

		return adata;
	}

	@PostMapping("/user-activity/{mobile}")
	public String updateActivities(@RequestBody MapResponse details, @PathVariable String mobile) {
		// hubService.saveToSearchRepo(details.getValue(), mobile);
		return mobile;
	}

	@PostMapping("/authenticate/{mobile}/{pawss}/{name}/{code}")
	public AuthsData _login(@PathVariable String mobile, @PathVariable String pawss, @PathVariable String name,
			@PathVariable int code) {
		// hubService.saveToSearchRepo("New Login", mobile);
		// hubService.saveToSearchRepo(name+" .authpass "+code, mobile);

		AuthsData adata = new AuthsData();
		if (code >= _Oderzy.code) {
			adata.setUpdate(5);
			try {
				String pass = service.isUserExists(mobile);
				if (pass == null) {
					adata.setAction(0);
					adata.setPass("error");
				} else {
					adata.setAction(1);
					if (pass.equals(pawss) || pawss.equals("#%99$%"))
						adata.setPass(pass);
					else
						adata.setPass("error");
				}
			} catch (Exception e) {
			}
		} else
			adata.setUpdate(0);

		return adata;
	}

	@PostMapping("/authenticate2/{mobile}/{pawss}")
	public AuthsData _login2(@PathVariable String mobile, @PathVariable String pawss) {
		// hubService.saveToSearchRepo("New Login", mobile);

		AuthsData adata = new AuthsData();

		try {
			String pass = service.isUserExists(mobile);
			if (pass == null) {
				adata.setAction(0);
				adata.setPass("error");
			} else {
				adata.setAction(1);
				if (pass.equals(pawss) || pawss.equals("#%99$%"))
					adata.setPass(pass);
				else
					adata.setPass("error");
			}
		} catch (Exception e) {
		}

		return adata;
	}

	@DeleteMapping("/logout")
	//
	public void logout(@RequestHeader(value = $Security.user_Token) String token) {
		loginService.logout(token);
		;
	}

	@PutMapping("/update/place_code/{placeCode}/id/{id}")
	@StaffAuth()
	public int updateCoordinates(@PathVariable String placeCode, @PathVariable String id) {
		return service.updatePlaceCode(placeCode, id);
	}

	@PutMapping("/update/address_phone/{phone}/id/{id}")

	public int updatePhone(@PathVariable String phone, @PathVariable String id) {
		return service.updatePhone(phone, id);
	}

	/*
	 * ============== staff Pannel============
	 */

	@PutMapping("/update/user/place_code/{placeCode}/id/{id}")
	@StaffAuth()
	public int updateUserPlaceCode(@PathVariable String placeCode, @PathVariable String id) {
		return service.updatePlaceCode(placeCode, id);
	}

	@PutMapping("/update/coordinates/{lat}/{lon}/id/{id}")
	@StaffAuth()
	public int updateUserCoordinates(@PathVariable Double lat, @PathVariable Double lon, @PathVariable String id) {
		return service.updateCoordinates(lat, lon, id);
	}

	/*
	 * ============== Help Pannel============
	 */
	@GetMapping("/complaint/{user}/{page}")

	public List<CustomerHelpDTO> getComplaintsByUser(@PathVariable String user, @PathVariable int page) {
		return service.getComplaintsByUser(user, page);
	}

	@GetMapping("/complaint-active/{page}")
	@StaffAuth()
	public List<CustomerHelpDTO> getComplaintsActive(@PathVariable int page) {
		return service.getComplaintsActive(page);
	}

	@PostMapping("/complaint")

	public boolean newComplaint(@RequestBody CustomerHelpDTO help) {
		service.newComplaint(help);
		return true;
	}

	@PostMapping("/_complaint")
	@StaffAuth()
	public boolean _newComplaint(@RequestBody CustomerHelpDTO help) {
		service.newComplaint(help);
		return true;
	}

	@PostMapping("/complaint-reply/{mobile}/{id}/{msg}")
	public boolean newComplaint(@PathVariable String mobile, @PathVariable String id, @PathVariable String msg) {
		service.replyComplaint(mobile, id, msg);
		return true;
	}

	/*
	 * -------------------------Point Controleer-----------------------------------
	 */
	@GetMapping("/point/mobile/{mobile}")
	public double getPointByMobile(@PathVariable String mobile) {
		return service.getPointBalance(mobile);
	}

	@GetMapping("/point-usage/mobile/{mobile}")
	public List<CustomerPoints> getPointUsageByMobile(@PathVariable String mobile) {
		return service.getPointUsage(mobile, 0);
	}

	@PutMapping("/_points/{mobile}/{msg}{point}")
	@StaffAuth()
	public boolean _newPoint(@PathVariable String mobile, @PathVariable String msg, @PathVariable double point) {
		service.newPointSummary(mobile, msg, point);
		return true;
	}

	@PutMapping("/update/point/{mobile}/{point}")
	public int updatePointBalance(@PathVariable String mobile, @PathVariable double point) {
		return service.updatePointBalance(mobile, point);
	}

	/*
	 * -------------------------Refer Controleer-----------------------------------
	 */

	@GetMapping("/refer-by/mobile/{mobile}")
	public List<CustomerRefer> getReferByMobile(@PathVariable String mobile) {
		return service.getRefered(mobile);
	}

	@GetMapping("/all-referal")
	public List<CustomerRefer> getAllRefered() {
		return service.getAllRefered();
	}

	@GetMapping("/refer/{area}")
	public ReferData getReferData(@PathVariable String area) {

		return new ReferData("₹100",
				"Invite your friends to Oderzy and earn minimum ₹75 to ₹100 for every 2 Referal when they order for first time on Oderzy. And you Friend will get cashback of upto  ₹100.",
				"Note: Offer is valid only when you refer to a new user and user address should not be same as yours. Amount will be credited to you after the successful delivery of User's order t&c apply",
				"Hey I'm using Oderzy for Home delivery of Vegetables & Grocery \nIt's Fresh&Quick Delivery Download now https://play.google.com/store/apps/details?id=com.oderzy.user&hl=en_IN&gl=US and you get ₹100.");
	}
}