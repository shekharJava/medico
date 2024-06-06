package com.oderzy.whatsapp.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Components {

	private String type;
	private Parameter[] parameters;
	private String sub_type;
	private String index;

}
