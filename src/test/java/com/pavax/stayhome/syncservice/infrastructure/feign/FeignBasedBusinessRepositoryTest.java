package com.pavax.stayhome.syncservice.infrastructure.feign;

import java.util.List;

import com.pavax.stayhome.syncservice.domain.BusinessRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class FeignBasedBusinessRepositoryTest {

	@Autowired
	private FeignBasedBusinessRepository repository;

	@Test
	void findByCorrelationId() {
		final List<BusinessRequest> results = this.repository.findByCorrelationId("pado-test-001");

	}

}
