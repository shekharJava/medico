package com.oderzy._notification.service;

import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.oderzy.$config.constants.$Notification;
import com.oderzy.$config.constants._Oderzy;
import com.oderzy._notification.NotificationDATA;
import com.oderzy._notification.PasswordCall;
import com.oderzy.customer.dto.Query;
import com.oderzy.service.general.model.GeneralPickup;

@Service
public class NotificationManger {

	@Lazy
	@Autowired
	private UserNotificationService userService;
	
	@Autowired
	private StaffNotificationService staffService;
	// this will store <mobile, Password> which are requested for password reset
	private static Map<String, PasswordCall> passwordCallMap;

	/*
	 * ----------------Order otification GeneralPickup---------------------------
	 */

	@PostConstruct
	public void init() {
		passwordCallMap = new ConcurrentHashMap<String, PasswordCall>();
	}

	public void notifyStaffNewMessage(Query q) {
		NotificationDATA data = new NotificationDATA(q.getSender(), q.getMessage(), "notification_default.ogg", "");

		staffService.sendNotificationToAllDevice(data, $Notification.firebase_keyAdmin);
		staffService.sendNotificationToAllDevice(data, $Notification.firebase_keySTAFFs);
	}

	public void notifyStaffNewComplaint(String sender, String msg) {
		NotificationDATA data = new NotificationDATA(sender, msg, "notification_default.ogg", "");

		staffService.sendNotificationToAllDevice(data, $Notification.firebase_keyAdmin);
		staffService.sendNotificationToAllDevice(data, $Notification.firebase_keySTAFFs);
	}

	/*
	 * public void notifyStaffNewOrder() { NotificationDATA data = new
	 * NotificationDATA("Order : " + "" , "we have a new Order Please check ",
	 * "notification_default.ogg", "");
	 * 
	 * staffService.sendNotificationToAllDevice(data,
	 * _Notification.firebase_keyAdmin);
	 * staffService.sendNotificationToAllDevice(data,
	 * _Notification.firebase_keySTAFFs); this.notifyUserOrderPlaced(o); }
	 */
	/*
	 * public void notifyStoreNewOrder(Orders o) { NotificationDATA data = new
	 * NotificationDATA("Order : " + "" + o.getDeliverySpeed(),
	 * " new store Order completed ", "notification_default.ogg", "");
	 * 
	 * staffService.sendNotificationToAllDevice(data,
	 * _Notification.firebase_keyAdmin);
	 * staffService.sendNotificationToAllDevice(data,
	 * _Notification.firebase_keySTAFFs); }
	 */
	public void notifyStaffNewService(GeneralPickup s) {

		NotificationDATA data = new NotificationDATA("New Service " + s.getPickupType(), "New Service request ",
				"notification_default1.ogg", "");
		staffService.sendNotificationToAllDevice(data, $Notification.firebase_keyAdmin);
		staffService.sendNotificationToAllDevice(data, $Notification.firebase_keySTAFFs);
	}

	/*
	 * ----------------Missed Call otification
	 * GeneralPickup---------------------------
	 */public void notifyStaffNewCall() {
		NotificationDATA data = new NotificationDATA("New Call ",
				"One new Call recevied from customero \n help the customer ", "default", "image");

		staffService.sendNotificationToAllDevice(data, $Notification.firebase_keyAdmin);
		staffService.sendNotificationToAllDevice(data, $Notification.firebase_keySTAFFs);
	}

	/*
	 * ----------------User otification GeneralPickup---------------------------
	 */
	public void notifyUserMsg(String mobile, String title, String msg) {
		NotificationDATA data = new NotificationDATA(title, msg, "notification_default.ogg", "");
		userService.sendNotificationToMobile(mobile, data);
	}

	public void notifyUserMsg(String mobile, String title, String msg, String image) {
		NotificationDATA data = new NotificationDATA(title, msg, "default", image);
		userService.sendNotificationToMobile(mobile, data);
	}

	public void notifyUserReplyOfComplaint(String receiver, String msg) {
		NotificationDATA data = new NotificationDATA("Oderzy Support", msg, "notification_default.ogg", "");
		userService.sendNotificationToMobile(receiver, data);
	}

	public void notifyNewUserOffer(String mobile) {
		NotificationDATA data = new NotificationDATA("Welcome to Oderzy",
				"₹40 added to your wallet \n Explore the App and place your first order", "default", "image");
		userService.sendNotificationToMobile(mobile, data);
	}
	/*
	 * public void notifyUserOrderPlaced(Orders o) { NotificationDATA data = new
	 * NotificationDATA("Hi " + o.getCustomerName(),
	 * "Your order  has been Paced and it will be processed soon", "default",
	 * "image"); userService.sendNotificationToMobile(o.getCustomerMobile(), data);
	 * }
	 */

	/*
	 * public void notifyUserOrderAccepted(Orders o) { NotificationDATA data = new
	 * NotificationDATA("Hi " + o.getCustomerName(),
	 * "Your order  has been Accepted and it will be processed soon", "default",
	 * "image"); userService.sendNotificationToMobile(o.getCustomerMobile(), data);
	 * }
	 */

	public void notifyUserPickupAccepted(GeneralPickup p) {
		NotificationDATA data = new NotificationDATA("Hey ", p.getPickupType() + " pickup  is" + p.getStatus(),
				"default", "image");
		userService.sendNotificationToMobile(p.getCustomerMobile(), data);
	}
	/*
	 * 
	 * public void notifyUserOrderShipped(Orders o) { NotificationDATA data = new
	 * NotificationDATA("Hey " + o.getCustomerName(),
	 * "Your order Shipped   \n  pay by cash Rs." + o.getNetAmount(), "default",
	 * "image"); userService.sendNotificationToMobile(o.getCustomerMobile(), data);
	 * 
	 * smsNotificationService.sendShippingSms(o.getOrderCode(), o.getNetAmount(),
	 * o.getCustomerMobile()); }
	 * 
	 * public void notifyUserOrderDelivered(Orders o) { NotificationDATA data = new
	 * NotificationDATA("Hey " + o.getCustomerName(),
	 * "Your order is Delivered successfully ", "default", "image");
	 * userService.sendNotificationToMobile(o.getCustomerMobile(), data); }
	 * 
	 * public void notifyUserOrderFailed(Orders o) { NotificationDATA data = new
	 * NotificationDATA("Hey " + o.getCustomerName(),
	 * "Your order has been canceled of  Rs." + o.getNetAmount(), "default",
	 * "image"); userService.sendNotificationToMobile(o.getCustomerMobile(), data);
	 * smsNotificationService.sendFailedSms(o.getOrderCode(),
	 * o.getCustomerMobile()); }
	 */

	public void notifyUserOrderRescheduled(String orderid, String user, String msg) {
		NotificationDATA data = new NotificationDATA("Hey ", msg, "default", "image");
		userService.sendNotificationToMobile(user, data);
	}

	/*
	 * public void notifyUserIndividually(String mobile, String msg) {
	 * NotificationDATA data = new NotificationDATA("Hey ",
	 * "Your order has been Rescheduled check for details", "default", "image");
	 * userService.sendNotificationToMobile(mobile, data); }
	 */

	public void notifyAllUserAdvise(NotificationDATA data) {
		userService.sendNotificationToAllDevice(data);
	}

	/*
	 * ----------------Password notification
	 * GeneralPickup---------------------------
	 */

	public boolean isPasswordRequest(String mobile) {
		return passwordCallMap.containsKey(mobile);
	}

	public String getOTP(String mobile) {
		String otp = passwordCallMap.get(mobile).getOtp();
		passwordCallMap.remove(mobile);
		return otp;
	}

	public void addPasswordReset(String mobile, String deviceId, String appType) {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[6];
		random.nextBytes(bytes);

		passwordCallMap.put(mobile, new PasswordCall(mobile, appType, deviceId, String.valueOf(bytes)));
	}

	public void sendPasswordOTP(String mobile) {
		PasswordCall call = passwordCallMap.get(mobile);
		NotificationDATA data = new NotificationDATA(call.getOtp(), "use this otp to reset the password", "default",
				"image");
		switch (call.getAppType()) {
		case _Oderzy.userApp:
			userService.sendNotificationToDeviceId(call.getDeviceId(), data);
			break;

		case _Oderzy.staffApp:
			staffService.sendNotificationToDeviceId(call.getDeviceId(), data, $Notification.firebase_keyAdmin);
			break;
		default:
			break;
		}

	}

}
