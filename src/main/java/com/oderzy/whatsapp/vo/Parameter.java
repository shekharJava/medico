package com.oderzy.whatsapp.vo;

import com.oderzy.whatsapp.dto.Media;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parameter {

	private String type;
	private String text;
	private String date_time;
	private Media image;
	private Media document;

}
