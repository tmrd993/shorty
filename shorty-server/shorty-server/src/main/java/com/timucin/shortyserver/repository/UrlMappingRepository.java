package com.timucin.shortyserver.repository;

import com.timucin.shortyserver.domain.UrlMapping;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
	Optional<UrlMapping> findByHashedValue(String hashedValue);
	Optional<UrlMapping> findByRedirectUrl(String redirectUrl);
}
