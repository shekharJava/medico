package com.oderzy.whatsapp.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {

	private String product_retailer_id;
	private int quantity;
	private String currency;
	
}
