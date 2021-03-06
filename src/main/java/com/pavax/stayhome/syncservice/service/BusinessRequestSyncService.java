package com.pavax.stayhome.syncservice.service;

import com.pavax.stayhome.syncservice.domain.BusinessRequest;
import com.pavax.stayhome.syncservice.domain.BusinessRequestRepository;
import com.pavax.stayhome.syncservice.domain.PostalCode;
import com.pavax.stayhome.syncservice.domain.PostalCodeRepository;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class BusinessRequestSyncService {

	private final BusinessRequestRepository businessRequestRepository;

	private final PostalCodeRepository postalCodeRepository;

	public BusinessRequestSyncService(BusinessRequestRepository businessRequestRepository, PostalCodeRepository postalCodeRepository) {
		this.businessRequestRepository = businessRequestRepository;
		this.postalCodeRepository = postalCodeRepository;
	}

	public void sync(BusinessEntryDto businessEntryDto) {
		final PostalCode postalCode = this.postalCodeRepository.getByZipCode(businessEntryDto.getZipCode());
		final String correlationId = extractCorrelationId(businessEntryDto);
		final BusinessRequest businessRequest = this.businessRequestRepository.findByCorrelationId(correlationId)
				.orElse(new BusinessRequest())
				.setSourceUUid(correlationId)
				.setName(businessEntryDto.getName())
				.setDescription(businessEntryDto.getDescription())
				.setLocation(postalCode.getId())
				.setWebsite(businessEntryDto.getWebsite())
				.setPhone(businessEntryDto.getPhone())
				.setEmail(businessEntryDto.getEmail())
				.setCategory(String.join(",", businessEntryDto.getCategories()))
				.setDelivery(businessEntryDto.getDelivery());
		businessRequest.setCheckSum(this.buildCheckSum(businessRequest));
		this.businessRequestRepository.save(businessRequest);
	}

	private String buildCheckSum(BusinessRequest businessRequest) {
		final String s = businessRequest.getUuid() +
				businessRequest.getName() +
				businessRequest.getDescription() +
				businessRequest.getLocation() +
				businessRequest.getWebsite() +
				businessRequest.getPhone() +
				businessRequest.getEmail() +
				businessRequest.getCategory() +
				businessRequest.getDelivery();
		return DigestUtils.md5DigestAsHex(s.getBytes());
	}

	private String extractCorrelationId(BusinessEntryDto businessEntryDto) {
		return String.format("%s-%s", businessEntryDto.getProviderName(), businessEntryDto.getId());
	}

}
