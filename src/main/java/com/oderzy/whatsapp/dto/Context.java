package com.oderzy.whatsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Context {

	private String forwarded;
	private String frequently_forwarded;
	private String from;
	private String id;

}
