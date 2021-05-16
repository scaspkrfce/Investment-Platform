package org.investmentplatform.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "this class represents roles")
@Entity

public class Role 
{
	@Id
	@ApiModelProperty(notes = "Unique identifier of the role.", 
    required = true, position = 0)
	private int roleId;
	@ApiModelProperty(notes = "Name of the role", 
    required = true, position = 1)
	private String roleName;
}
