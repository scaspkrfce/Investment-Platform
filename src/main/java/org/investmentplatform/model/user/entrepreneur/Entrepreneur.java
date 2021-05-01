package org.investmentplatform.model.user.entrepreneur;

import io.swagger.annotations.ApiModelProperty;

public class Entrepreneur 
{
	@ApiModelProperty(notes = "Company Id of the investor.", 
    required = true, position = 0)
	private String companyId;
}
