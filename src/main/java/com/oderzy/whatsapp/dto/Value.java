package com.oderzy.whatsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Value {

	private String messaging_product;
	private Metadata metadata;
	private Message[] messages;
	private Statuses[] statuses;
	private Error[] errors;

}
