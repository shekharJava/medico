package com.oderzy.customer.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViewData {

	protected int action;
	protected String title;
	protected int viewCode;
	protected List<CategoryData> data;
}
