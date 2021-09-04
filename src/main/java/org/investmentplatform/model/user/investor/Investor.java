package org.investmentplatform.model.user.investor;

import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "this class represents investors")
@Entity

public class Investor
{
	@ApiModelProperty(notes = "Description of the investor.", 
    required = true, position = 0)
	private String description;
	@ApiModelProperty(notes = "Comercial interests of the investor.", 
    required = true, position = 1)
	private String listOfInterests;

}
