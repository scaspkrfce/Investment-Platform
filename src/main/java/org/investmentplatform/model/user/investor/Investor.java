package org.investmentplatform.model.user.investor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "this class represents investors")
@Entity

public class Investor
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Unique identifier of the investor.", 
    required = true, position = 0, hidden = true)
	private Long investorId;
	@ApiModelProperty(notes = "Description of the investor.", 
    required = true, position = 1)
	private String description;
	@ApiModelProperty(notes = "Comercial interests of the investor.", 
    required = true, position = 2)
	private String listOfInterests;

}
