package com.lucanet.rest;

import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import com.lucanet.model.core.Repository;
import com.lucanet.model.entities.Posting;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/postings")
@RestController
@Api(value="Posting operations", description="Contains READ operations related to postings")
public class PostingsResource {

	@Autowired
	Repository<Posting> repository;

	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<Posting> getAll(@RequestParam("fiscalYear") int fiscalYear, @RequestParam("accountingArea") String accountingArea) {
		return repository.getAll()
				.stream()
				.filter(posting -> fiscalYear == 0 || posting.getFiscalYear() == fiscalYear)
				.filter(posting -> accountingArea == null || posting.getAccountingAreaNumber().equals(accountingArea))
				.collect(Collectors.toList());
	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Posting getById(@PathVariable("id") long id) {
		return repository.getById(id);
	}
	
}