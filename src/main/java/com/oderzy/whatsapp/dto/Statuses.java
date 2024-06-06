package com.oderzy.whatsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Statuses {

	private String id;
	private String recipient_id;
	private String status;
	private String timestamp;
	private String type;
	private String conversation;
	private String pricing;
	private Error[] errors;
}
