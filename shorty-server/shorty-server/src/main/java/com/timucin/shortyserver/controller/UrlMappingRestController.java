package com.timucin.shortyserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timucin.shortyserver.domain.UrlMapping;
import com.timucin.shortyserver.service.UrlMappingService;

@RestController
@RequestMapping("/api")
public class UrlMappingRestController {
	
	private final UrlMappingService urlMappingService;
	
	public UrlMappingRestController(UrlMappingService urlMappingService) {
		this.urlMappingService = urlMappingService;
	}
	
	@PostMapping("/hashAndSave")
	public UrlMapping createNewMapping(@RequestBody String originalUrl) {
		
		
		UrlMapping mapping = new UrlMapping();
		mapping.setHashedValue("TESTEST");
		mapping.setRedirectUrl("TESTURLRURLRL");
		
		return mapping;
	}

}
