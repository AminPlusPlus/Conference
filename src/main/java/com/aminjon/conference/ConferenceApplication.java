package com.aminjon.conference;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ConferenceApplication {

	@Value("${app.version}")
	private String appVersion;

	public static void main(String[] args) {
		SpringApplication.run(ConferenceApplication.class, args);
	}

	@RequestMapping("/")
	public Map welcomePage(){
		Map<String,String> mapAppVersion = new HashMap<>();
		mapAppVersion.put("App Version",appVersion);
		return mapAppVersion;
	}
}
