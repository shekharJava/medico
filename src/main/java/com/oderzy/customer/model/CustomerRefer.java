 package com.oderzy.customer.model;

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
public class CustomerRefer implements Serializable {

	private static final long serialVersionUID = -5135477680559426048L;
	
	@Id
	//new user
	protected String mobile;
	//existing user who have invite user
	protected String referMobile;
	//refer note is active or rewarded
	protected String note;
}

