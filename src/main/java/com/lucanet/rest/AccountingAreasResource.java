package com.lucanet.rest;

import com.lucanet.model.core.Repository;
import com.lucanet.model.entities.AccountingArea;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/accounting-areas")
@Api(value="Accounting area operations", description="Contains READ operations related to accounting areas")
@RestController
public class AccountingAreasResource {

	@Autowired
	private Repository<AccountingArea> repository;
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<AccountingArea> getAll() {
		return repository.getAll();
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public AccountingArea getById(@PathVariable("id") long id) {
		return repository.getById(id);
	}
	
}