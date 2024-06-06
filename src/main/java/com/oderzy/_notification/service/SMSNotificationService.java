package com.oderzy._notification.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oderzy.$config.constants.$Notification;

@Service
public class SMSNotificationService {
	@org.springframework.context.annotation.Lazy
	@Autowired
	private RestTemplate restTemplate;

	public void sendShippingSms(String orderId, double amt, String user) {
		HttpHeaders headers = null;
		JSONObject json = null;
		HttpEntity<String> request;
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		try {
			json = new JSONObject();
			json.put("From", $Notification.sms_Sender);
			json.put("To", user);
			json.put("TemplateName", $Notification.sms_Ship);
			json.put("VAR1", orderId);
			json.put("VAR2", amt);
			request = new HttpEntity<String>(json.toString(), headers);
			restTemplate.postForEntity($Notification.sms_URI, request, String.class);

		} catch (JSONException | NullPointerException e) {
		}

		/* ResponseEntity<String> response = */

	}

	public void sendFailedSms(String orderId, String user) {
		HttpHeaders headers = null;
		JSONObject json = null;
		HttpEntity<String> request;
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		try {
			json = new JSONObject();
			json.put("From", $Notification.sms_Sender);
			json.put("To", user);
			json.put("TemplateName", $Notification.sms_Fail);
			json.put("VAR1", orderId);
			request = new HttpEntity<String>(json.toString(), headers);

			restTemplate.postForEntity($Notification.sms_URI, request, String.class);

		} catch (JSONException | NullPointerException n) {

		}

	}

}
