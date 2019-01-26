package com.lucanet.rest;

import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import com.lucanet.model.core.Repository;
import com.lucanet.model.entities.SubLedgerAccount;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sub-ledger-accounts")
@RestController
@Api(value="Sub ledger account operations", description="Contains READ operations related to sub ledger accounts")
public class SubLedgerAccountsResource {

	@Autowired
	private Repository<SubLedgerAccount> repository;

	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<SubLedgerAccount> getAll() {
		return repository.getAll();
	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public SubLedgerAccount getById(@PathVariable("id") long id) {
		return repository.getById(id);
	}
	
}