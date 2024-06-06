package com.oderzy._notification.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.oderzy.$config.constants.$Notification;
import com.oderzy._notification.NotificationDATA;

public class BoyNotificationService {

	@Lazy
	@Autowired
	private RestTemplate restTemplate;

	// this map will contain all deviceInfo based on DeliveryBoyMobile
	// Map<BoyMobile, DeviceId>
	private static ConcurrentHashMap<String, String> deviceByMobile = new ConcurrentHashMap<>();

	public void addDevice(String mobile, String deviceId) {
		deviceByMobile.put(mobile, deviceId);
	}

	private String getDevice(String mobile) {
		return deviceByMobile.get(mobile);
	}

	private List<String> getAllDevice() {
		return new ArrayList<>(deviceByMobile.values());
	}

	public void sendNotificationToDeviceId(String mobile, NotificationDATA notify) {
		HttpHeaders headers = null;
		JSONObject json = null;
		JSONObject jsonNotification = null;
		HttpEntity<String> request;

		String deviceId = getDevice(mobile);
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", $Notification.firebase_keySTAFFs);
		try {
			json = new JSONObject();
			jsonNotification = new JSONObject();
			jsonNotification.put("title", notify.getTitle());
			jsonNotification.put("body", notify.getBody());
			jsonNotification.put("sound", notify.getSound());
			jsonNotification.put("image", notify.getImage());

			json.put("notification", jsonNotification);
			json.put("priority", "High");
			json.put("to", deviceId.trim());
			request = new HttpEntity<>(json.toString(), headers);

			restTemplate.postForEntity($Notification.firebase_URI, request, String.class);
		} catch (JSONException | NullPointerException n) {

		}

	}

	public void sendNotificationToAllDevice(NotificationDATA notify) {
		HttpHeaders headers = null;
		JSONObject json = null;
		JSONObject jsonNotification = null;

		List<String> devices = getAllDevice();
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", $Notification.firebase_keySTAFFs);
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

				HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);

				restTemplate.postForEntity($Notification.firebase_URI, request, String.class);
			}
		} catch (JSONException e) {
		}
	}
}
