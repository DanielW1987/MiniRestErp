package com.lucanet.rest;

import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import com.lucanet.model.core.Repository;
import com.lucanet.model.entities.Account;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/accounts")
@RestController
@Api(value="Account operations", description="Contains READ operations related to accounts")
public class AccountsResource {

	@Autowired
	private Repository<Account> repository;

	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<Account> getAll() {
		return repository.getAll();
	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Account getById(@PathVariable("id") long id) {
		return repository.getById(id);
	}

}