package com.timucin.shortyserver.service;

import java.util.List;
import java.util.Optional;

import com.timucin.shortyserver.domain.UrlMapping;

public interface UrlMappingService {
	Optional<UrlMapping> findById(Long id);
	List<UrlMapping> findAll();
	Optional<UrlMapping> findByHashedValue(String hashedValue);
	Optional<UrlMapping> findByRedirectUrl(String redirectUrl);
	UrlMapping save(UrlMapping urlMapping);
	void delete(UrlMapping urlMapping);
	void deleteById(Long id);
}
