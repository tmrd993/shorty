package com.timucin.shortyserver.service;

import java.util.Optional;

import com.timucin.shortyserver.domain.UrlMapping;

public interface UrlMappingService {
	Optional<UrlMapping> findById(Long id);
	Optional<UrlMapping> findByHashedValue(String hashedValue);
	Optional<UrlMapping> findByRedirectUrl(String redirectUrl);
}
