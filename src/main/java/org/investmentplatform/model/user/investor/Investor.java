package org.investmentplatform.model.user.investor;

import io.swagger.annotations.ApiModelProperty;

public class Investor
{
	@ApiModelProperty(notes = "Description of the investor.", 
    required = true, position = 0)
	private String description;
	@ApiModelProperty(notes = "Comercial interests of the investor.", 
    required = true, position = 1)
	private String listOfInterests;

}
