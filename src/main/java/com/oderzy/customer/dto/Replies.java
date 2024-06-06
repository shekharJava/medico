package com.oderzy.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Replies {

	protected Message[] replies;

	public static Replies construct(String msg) {
		Replies r = new Replies();
		r.setReplies(new Message[] { new Message(msg) });
		return r;
	}
}
