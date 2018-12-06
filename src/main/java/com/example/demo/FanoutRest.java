package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/fanout")
public class FanoutRest {

	private final FanoutSender sender;

	@Autowired
	public FanoutRest(FanoutSender sender) {
		this.sender = sender;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void sendMessage(@RequestBody Map<String, String> message) {
		sender.send(message.get("valor"));
	}
}