package org.investmentplatform.model.userxrole;

import java.util.Collection;

import org.investmentplatform.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserXRoleRepository extends JpaRepository<UserXRole, Long>
{
	Collection<UserXRole> findByUser(User user);
}