package com.lucanet.model.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.lucanet.model.core.Identifiable;
import com.lucanet.model.core.ObjectID;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@JacksonXmlRootElement(localName = "openingBalance")
@NoArgsConstructor
@Getter
@ApiModel(value="Opening Balance entry", description="Resource which represent an opening balance value for a specific account, accounting area and fiscal year.")
public class OpeningBalance implements Identifiable {

  @JacksonXmlProperty(isAttribute = true)
  private long   id;
  private String accountingAreaNumber;
  private int    fiscalYear;
  private String accountNumber;
  private long   value;
  private int    decimalDigits;

  public OpeningBalance(String accountingAreaNumber, int fiscalYear, String accountNumber, long value, int decimalDigits) {
    this.id = ObjectID.nextId();
    this.accountingAreaNumber = accountingAreaNumber;
    this.fiscalYear = fiscalYear;
    this.accountNumber = accountNumber;
    this.value = value;
    this.decimalDigits = decimalDigits;
  }
}