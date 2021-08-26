package com.timucin.shortyserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.timucin.shortyserver.dao.UrlDao;
import com.timucin.shortyserver.domain.UrlMapping;
import com.timucin.shortyserver.service.UrlMappingService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UrlMappingRestController {
	
	private final UrlMappingService urlMappingService;
	
	private static final int HASHED_VAL_LEN = 8;
	
	public UrlMappingRestController(UrlMappingService urlMappingService) {
		this.urlMappingService = urlMappingService;
	}
	
	@PostMapping("/hashAndSave")
	public UrlMapping createNewMapping(@RequestBody UrlDao urlDao) {
		
		System.out.println("Saving " + urlDao.getOriginalUrl() + " ...");
		
		String hashedValue = DigestUtils
				.md5DigestAsHex(urlDao.getOriginalUrl().getBytes())
				.substring(0, HASHED_VAL_LEN);
		
		UrlMapping mapping = new UrlMapping();
		mapping.setHashedValue(hashedValue);
		mapping.setRedirectUrl(urlDao.getOriginalUrl());
		
		urlMappingService.save(mapping);
		
		return mapping;
	}
	
	@GetMapping("/{hashedValue}")
	public UrlMapping getUrlMapping(@PathVariable("hashedValue") String hashedValue) {
		
		UrlMapping mapping = urlMappingService.findByHashedValue(hashedValue)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		return mapping;
	}
	
}
