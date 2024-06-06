package com.oderzy.whatsapp.vo;

import com.oderzy.whatsapp.dto.Context;
import com.oderzy.whatsapp.dto.Text;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

	private String messaging_product;
	private String to;
	private Context context;
	private String type;
	private Text text;
	private Media image;
	private Media document;
	private Order order;

}
