package com.oderzy.universe.user;

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
public class Person_Credential implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	private String lid;
	private String mobile;
	private String email;
	private String secQ;
	private String secA;
	private String Role;



}
