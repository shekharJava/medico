package com.oderzy.doctor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DoctorsTime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6658710951314293200L;
	@Id
	protected String sl;
	protected String mobile;
	protected String day;
	protected String timee;
	protected String status;
}
