package com.lucanet.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import com.lucanet.model.core.Repository;
import com.lucanet.model.entities.CostCenter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/cost-centers")
@RestController
@Api(value="Cost centre operations", description="Contains READ operations related to cost centers")
public class CostCentersResource {

	@Autowired
	private Repository<CostCenter> repository;

	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<CostCenter> getAll() {
		return repository.getAll();
	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public CostCenter getById(@PathVariable("id") long id) {
		return repository.getById(id);
	}

}