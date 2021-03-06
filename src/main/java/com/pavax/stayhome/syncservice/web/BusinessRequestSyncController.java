package com.pavax.stayhome.syncservice.web;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.pavax.stayhome.syncservice.service.BusinessEntryDto;
import com.pavax.stayhome.syncservice.service.BusinessRequestSyncService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/business-entry")
public class BusinessRequestSyncController {

	private final BusinessRequestSyncService businessRequestSyncService;

	public BusinessRequestSyncController(BusinessRequestSyncService businessRequestSyncService) {
		this.businessRequestSyncService = businessRequestSyncService;
	}

	@PostMapping("/")
	public void upsert(@RequestBody @Validated BusinessEntryDto businessEntryDto) {
		this.businessRequestSyncService.sync(businessEntryDto);
	}

	@PostMapping("/_bulk")
	public void bulkUpsert(@RequestBody @Validated BulkOperation bulkOperation) {
		for (BusinessEntryDto entry : bulkOperation.entries) {
			this.businessRequestSyncService.sync(entry);
		}
	}

	public static class BulkOperation {

		@Valid
		@NotEmpty
		public List<BusinessEntryDto> entries;

	}

}
