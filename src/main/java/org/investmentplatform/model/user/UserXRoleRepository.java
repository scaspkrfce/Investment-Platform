package org.investmentplatform.model.user;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserXRoleRepository extends JpaRepository<UserXRole, Long>
{
	Collection<UserXRole> findByUser(User user);
}
