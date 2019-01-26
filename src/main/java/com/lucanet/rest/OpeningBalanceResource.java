package com.lucanet.rest;

import com.lucanet.model.core.Repository;
import com.lucanet.model.entities.OpeningBalance;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/opening-balance")
@RestController
@Api(value="Opening balance operations", description="Contains READ operations related to opening balance")
public class OpeningBalanceResource {

    @Autowired
    Repository<OpeningBalance> repository;

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<OpeningBalance> getAll(@RequestParam("fiscalYear") int fiscalYear, @RequestParam("accountingArea") String accountingArea) {
        return repository.getAll()
                .stream()
                .filter(posting -> fiscalYear == 0 || posting.getFiscalYear() == fiscalYear)
                .filter(posting -> accountingArea == null || posting.getAccountingAreaNumber().equals(accountingArea))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public OpeningBalance getById(@PathVariable("id") long id) {
        return repository.getById(id);
    }

}