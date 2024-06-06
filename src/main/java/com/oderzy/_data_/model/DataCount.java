package com.oderzy._data_.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataCount implements Serializable {

	private static final long serialVersionUID = 7596538566564182628L;
	
	@Id
	private String dataType;
	private int dataValue;

}
