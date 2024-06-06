package com.oderzy._notification.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.constraints.NotNull;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oderzy.$config.constants.$Notification;
import com.oderzy._notification.NotificationDATA;
import com.oderzy.customer.dto.Message;

@Service
public class StaffNotificationService {

	@Autowired
	@Lazy
	private RestTemplate restTemplate;

	// this map will contain all deviceInfo based on StaffMobile
	// Map<staffMobile, DeviceId>
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
		sendNotificationToDeviceId(deviceId, notify, $Notification.firebase_keySTAFFs);
		sendNotificationToDeviceId(deviceId, notify, $Notification.firebase_keyAdmin);
	}

	public void sendNotificationToDeviceId(String deviceId, NotificationDATA notify, String serverKey) {
		HttpHeaders headers = null;
		JSONObject json = null;
		JSONObject channel = null;
		HttpEntity<String> request;
		JSONObject jsonNotification = null;

		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", serverKey);

		try {
			channel = new JSONObject();
			channel.put("channel_id", "staff01");

			json = new JSONObject();
			jsonNotification = new JSONObject();
			jsonNotification.put("title", notify.getTitle());
			jsonNotification.put("body", notify.getBody());
			jsonNotification.put("sound", notify.getSound());
			jsonNotification.put("channel_id", "staff01");

			jsonNotification.put("image", notify.getImage());
			Message m = new Message("whatsapp");
			json.put("data", m);

			json.put("notification", jsonNotification);
			json.put("priority", "High");
			json.put("to", deviceId.trim());
		} catch (JSONException | NullPointerException n) {

		}
		try {
			request = new HttpEntity<String>(json.toString(), headers);

			restTemplate.postForEntity($Notification.firebase_URI, request, String.class);

		} catch (NullPointerException e) {
			// TODO: handle exception
		}
	}

	public void sendNotificationToAllDevice(NotificationDATA notify, String serverKey) {
		HttpHeaders headers = null;
		@NotNull
		JSONObject json = null;
		JSONObject jsonNotification = null;
		HttpEntity<String> request;
		List<String> devices = getAllDevice();
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", serverKey);
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

				request = new HttpEntity<String>( json.toString(), headers);

				restTemplate.postForEntity($Notification.firebase_URI, request, String.class);
			}
		} catch (JSONException | NullPointerException e) {
		}

	}

	public void sendNotificationToAllDeviceWithData(NotificationDATA notify, String serverKey) {
		HttpHeaders headers = null;
		JSONObject json = null;
		JSONObject jsonNotification = null;
		JSONObject data = null;

		List<String> devices = getAllDevice();
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", serverKey);
		try {
			json = new JSONObject();
			jsonNotification = new JSONObject();
			jsonNotification.put("title", notify.getTitle());
			jsonNotification.put("body", notify.getBody());
			jsonNotification.put("sound", notify.getSound());
			jsonNotification.put("image", notify.getImage());

			data = new JSONObject();
			data.put("whatsapp", true);
			json.put("notification", jsonNotification);
			jsonNotification.put("data", data);
			json.put("data", data);
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
