package com.lucanet.model.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.lucanet.model.core.Identifiable;
import com.lucanet.model.core.ObjectID;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JacksonXmlRootElement(localName = "costCenter")
@NoArgsConstructor
@Getter
@ToString(includeFieldNames = false, of = {"number", "name"})
@ApiModel(value="Cost center", description="Resource which represent a cost center.")
public class CostCenter implements Identifiable {

  @JacksonXmlProperty(isAttribute = true)
  private long   id;
  private String number;
  private String name;

  public CostCenter(String number, String name) {
    this.id = ObjectID.nextId();
    this.number = number;
    this.name = name;
  }

}