package com.oderzy._notification.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oderzy.$config.constants.$Notification;
import com.oderzy._notification.NotificationDATA;
import com.oderzy.customer.service.CustomerProfie_Service;

@Service
public class UserNotificationService {
	@Autowired
	private RestTemplate restTemplate;
	@Lazy
	@Autowired
	private CustomerProfie_Service userService;
	// this map will contain all deviceInfo based on UserMobile
	// Map<UserMobile, DeviceId>
	private static ConcurrentHashMap<String, String> deviceByMobile = new ConcurrentHashMap<String, String>();

	public void addDevice(String mobile, String deviceId) {
		deviceByMobile.put(mobile, deviceId);
	}

	private String getDevice(String mobile) {
		return deviceByMobile.get(mobile);
	}

	private List<String> getAllDevice() {
		return new ArrayList<String>(deviceByMobile.values());
	}

	public void sendNotificationToMobile(String mobile, NotificationDATA notify) {
		String deviceId = getDevice(mobile);
		try {
			if (deviceId.length() == 0) {
				deviceId = userService.getDeviceId(mobile);
			}
		} catch (NullPointerException n) {
			deviceId = userService.getDeviceId(mobile);
		}
		sendNotificationToDeviceId(deviceId, notify);
	}

	public void sendNotificationToDeviceId(String deviceId, NotificationDATA notify) {
		HttpHeaders headers = null;
		JSONObject json = null;
		JSONObject jsonNotification = null;

		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", $Notification.firebase_keyUSER);
		try {
			json = new JSONObject();
			jsonNotification = new JSONObject();
			jsonNotification.put("click_action", ".MainActivity");
			jsonNotification.put("title", notify.getTitle());
			jsonNotification.put("body", notify.getBody());
			jsonNotification.put("sound", notify.getSound());
			jsonNotification.put("image", notify.getImage());
			jsonNotification.put("ncode", notify.getImage());
			jsonNotification.put("keyword", notify.getImage());

			json.put("data", jsonNotification);
			json.put("priority", "High");
			json.put("to", deviceId.trim());
			HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);

			restTemplate.postForEntity($Notification.firebase_URI, request, String.class);
		} catch (Exception e) {
		}

		
	}

	public void sendNotificationToAllDevice(NotificationDATA notify) {
		HttpHeaders headers = null;
		JSONObject json = null;
		JSONObject jsonNotification = null;

		List<String> devices = getAllDevice();
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", $Notification.firebase_keyUSER);
		try {
			json = new JSONObject();
			jsonNotification = new JSONObject();
			jsonNotification.put("title", notify.getTitle());
			jsonNotification.put("body", notify.getBody());
			jsonNotification.put("sound", notify.getSound());
			jsonNotification.put("image", notify.getImage());

			json.put("notification", jsonNotification);
			json.put("priority", "High");
			for (String device : devices) {
				json.put("to", device.trim());

				HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);

				restTemplate.postForEntity($Notification.firebase_URI, request, String.class);
			}
		} catch (JSONException e) {
		}
	}
}
