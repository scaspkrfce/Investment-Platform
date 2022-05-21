package org.investmentplatform.model.access;

import java.util.Optional;

import org.investmentplatform.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRepository extends JpaRepository<Access, Long>
{
	Optional<Access> findByUserId(Long userId);
	
}