package com.oderzy.whatsapp.dto;

import com.oderzy.whatsapp.vo.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

	private String from;
	private String id;
	private String timestamp;
	private String type;
	private com.oderzy.whatsapp.dto.Context context;
	private Text text;
	private Interactive interactive;
	private Order order;
	private Media audio;
	private Media image;
	private Media sticker;
	private Media video;
	private Media document;
	private Button button;
	private Error errors;

}