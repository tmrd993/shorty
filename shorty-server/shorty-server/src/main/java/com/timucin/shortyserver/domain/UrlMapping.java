package com.timucin.shortyserver.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class UrlMapping {
	
	@Transient
	private static final int HASH_VAL_MAX_LEN = 12;
	
	@Transient
	private static final int REDIRECT_URL_MAX_LEN = 250;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "hashed_value", length = HASH_VAL_MAX_LEN, nullable = false)
	private String hashedValue;
	
	@Column(name = "redirect_url", length = REDIRECT_URL_MAX_LEN, nullable = false)
	private String redirectUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHashedValue() {
		return hashedValue;
	}

	public void setHashedValue(String hashedValue) {
		this.hashedValue = hashedValue;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	

}
