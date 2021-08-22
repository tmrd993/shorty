package com.timucin.shortyserver.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.timucin.shortyserver.domain.UrlMapping;
import com.timucin.shortyserver.repository.UrlMappingRepository;

public class UrlMappingServiceImpl implements UrlMappingService {
	
	private final UrlMappingRepository urlMappingRepository;
	
	@Autowired
	public UrlMappingServiceImpl(UrlMappingRepository urlMappingRepository) {
		this.urlMappingRepository = urlMappingRepository;
	}

	@Override
	public Optional<UrlMapping> findById(Long id) {
		return urlMappingRepository.findById(id);
	}

	@Override
	public Optional<UrlMapping> findByHashedValue(String hashedValue) {
		return urlMappingRepository.findByHashedValue(hashedValue);
	}

	@Override
	public Optional<UrlMapping> findByRedirectUrl(String redirectUrl) {
		return urlMappingRepository.findByRedirectUrl(redirectUrl);
	}

	@Override
	public List<UrlMapping> findAll() {
		return this.urlMappingRepository.findAll();
	}

	@Override
	public UrlMapping save(UrlMapping urlMapping) {
		return this.urlMappingRepository.save(urlMapping);
	}

	@Override
	public void delete(UrlMapping urlMapping) {
		this.urlMappingRepository.delete(urlMapping);
	}

	@Override
	public void deleteById(Long id) {
		this.urlMappingRepository.deleteById(id);
	}

}