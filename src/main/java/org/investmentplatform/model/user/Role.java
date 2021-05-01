package org.investmentplatform.model.user;

import io.swagger.annotations.ApiModelProperty;

public class Role 
{
	@ApiModelProperty(notes = "Unique identifier of the role.", 
    required = true, position = 0)
	private int roleId;
	@ApiModelProperty(notes = "Name of the role", 
    required = true, position = 1)
	private String roleName;
}
