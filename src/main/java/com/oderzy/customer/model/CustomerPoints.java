 package com.oderzy.customer.model;

 import java.io.Serializable;
import java.time.LocalDateTime;

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
public class CustomerPoints implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5321343231479612472L;
	@Id
	protected String id;
	protected String mobile;
	protected String summary;
	protected double point;
	protected LocalDateTime date;

}
