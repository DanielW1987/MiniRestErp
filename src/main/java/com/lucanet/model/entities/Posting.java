package com.lucanet.model.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.lucanet.model.core.Identifiable;
import com.lucanet.model.core.ObjectID;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@JacksonXmlRootElement(localName = "posting")
@NoArgsConstructor
@Getter
@ApiModel(value="Posting", description="Resource which represent a posting.")
public class Posting implements Identifiable {

  @JacksonXmlProperty(isAttribute = true)
  private long              id;
  private String            accountingAreaNumber;
  private int               fiscalYear;
  private int               postingNumber;
  private String            creator;
  private String            postingDescription;
  private String            dmsCode;
  private LocalDate         postingDate;
  private LocalDate         creationDate;

  @JacksonXmlElementWrapper(localName = "postingLines")
  private List<PostingLine> postingLines;

  public Posting(String accountingAreaNumber, int fiscalYear, int postingNumber, LocalDate postingDate, String creator,
          LocalDate creationDate, String postingDescription, String dmsCode, List<PostingLine> postingLines) {
    this.id = ObjectID.nextId();
    this.accountingAreaNumber = accountingAreaNumber;
    this.fiscalYear = fiscalYear;
    this.postingNumber = postingNumber;
    this.postingDate = postingDate;
    this.creator = creator;
    this.creationDate = creationDate;
    this.postingDescription = postingDescription;
    this.dmsCode = dmsCode;
    this.postingLines = postingLines;
  }

}