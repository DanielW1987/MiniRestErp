package com.lucanet.model.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.lucanet.model.core.Identifiable;
import com.lucanet.model.core.ObjectID;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement(localName = "postingLine")
@NoArgsConstructor
@Getter
@ApiModel(value="Posting line", description="Resource which represent a posting line.")
public class PostingLine implements Identifiable {

  @JacksonXmlProperty(isAttribute = true)
  private long   id;
  private int    lineNumber;
  private String accountNumber;
  private String costCenterNumber;
  private long   value;
  private int    decimalDigits;
  private String postingLineDescription;

  public PostingLine(int lineNumber, String accountNumber, String costCenterNumber, long value, int decimalDigits, String postingLineDescription) {
    this.id = ObjectID.nextId();
    this.lineNumber = lineNumber;
    this.accountNumber = accountNumber;
    this.costCenterNumber = costCenterNumber;
    this.value = value;
    this.decimalDigits = decimalDigits;
    this.postingLineDescription = postingLineDescription;
  }

}