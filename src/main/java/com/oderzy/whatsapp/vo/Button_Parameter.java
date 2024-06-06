package com.oderzy.whatsapp.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Button_Parameter {

	private String type;
	private String text;
	//unique id for thi which be returned by whook when user rply
	private String id;


}
