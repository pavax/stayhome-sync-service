package com.pavax.stayhome.syncservice.service;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BusinessEntryDto {

	@NotNull
	@Size(max = 36)
	@NotBlank
	private String id;

	@Size(max = 20)
	@NotBlank
	private String providerName;

	@Size(max = 255)
	@NotBlank
	private String name;

	@Size(max = 1000)
	@NotBlank
	private String description;

	@Pattern(regexp = "^[1-9][0-9][0-9][0-9]$")
	@NotBlank
	private String zipCode;

	@Size(max = 255)
	private String website;

	@Pattern(regexp = "^(0|0041|\\+41)?[1-9\\s][0-9\\s]{1,12}$")
	@Size(max = 255)
	private String phone;

	@Email
	@Size(max = 255)
	private String email;

	@NotEmpty
	private Set<String> categories;

	private String delivery;

	public String getId() {
		return id;
	}

	public BusinessEntryDto setId(String id) {
		this.id = id;
		return this;
	}

	public String getProviderName() {
		return providerName;
	}

	public BusinessEntryDto setProviderName(String providerName) {
		this.providerName = providerName;
		return this;
	}

	public String getName() {
		return name;
	}

	public BusinessEntryDto setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public BusinessEntryDto setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getZipCode() {
		return zipCode;
	}

	public BusinessEntryDto setZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	public String getWebsite() {
		return website;
	}

	public BusinessEntryDto setWebsite(String website) {
		this.website = website;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public BusinessEntryDto setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public BusinessEntryDto setEmail(String email) {
		this.email = email;
		return this;
	}

	public Set<String> getCategories() {
		return categories;
	}

	public BusinessEntryDto setCategories(Set<String> categories) {
		this.categories = categories;
		return this;
	}

	public String getDelivery() {
		return delivery;
	}

	public BusinessEntryDto setDelivery(String delivery) {
		this.delivery = delivery;
		return this;
	}
}
