package com.oderzy.whatsapp.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Header {

	private Media image;
	private Media document;
	private Media video;
	private String text;
	private String type;

}
