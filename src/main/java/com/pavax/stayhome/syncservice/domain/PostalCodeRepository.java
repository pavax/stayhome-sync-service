package com.pavax.stayhome.syncservice.domain;

import java.util.Optional;

import springfox.documentation.annotations.Cacheable;

public interface PostalCodeRepository {

	Optional<PostalCode> findByZipCode(String zipCode);

	PostalCode getByZipCode(String zipCode);

}
