
package org.investmentplatform.model.userxrole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.investmentplatform.model.user.Role;
import org.investmentplatform.model.user.User;

import io.swagger.annotations.ApiModel;
@ApiModel (description = "this class represents the relation between users and roles")
@Entity

public class UserXRole 
{
	@Id
    @Column(name="userXRole_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userXRoleid;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

	public Long getUserXRoleid() {
		return userXRoleid;
	}

	public void setUserXRoleid(Long userXRoleid) {
		this.userXRoleid = userXRoleid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
    
}