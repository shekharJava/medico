package com.oderzy.customer.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class NewMessages {

	public List<Query> message = new ArrayList<Query>();

	public Map<String, String> reply = new ConcurrentHashMap<>();

	public Message getReply(String sender) {
		Message m = new Message(reply.get(sender));
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			@Override
			public void run() {
				 message.removeIf(m-> m.sender.equals(sender));
			}

		});
		
		return m;
	}

}
