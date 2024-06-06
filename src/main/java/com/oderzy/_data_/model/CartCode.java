package com.oderzy._data_.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartCode implements Serializable {

	private static final long serialVersionUID = 1489778597846298624L;

	@Id
	private String code;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(columnDefinition = "DATE")
	private LocalDate date;
	
	
	
}
