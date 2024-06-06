package com.oderzy.whatsapp;

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
public class Wmessage implements Serializable {

	private static final long serialVersionUID = 4161591502770774764L;
	@Id
	private String id;
	private String from_;
	private String timestamp_;
	private String type_;
	/*private String contextId;
	private String contextFrom;*/
	private String text_;
/*	private String InteractionType;
	private String interactionId;
	private String interactionTitle;
	private String interactionDesc;
	private String button;*/

}
