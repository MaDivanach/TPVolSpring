package com.sopra.TPVolSpring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sopra.TPVolSpring.model.UserRole;

public interface UserRoleRepositoy extends JpaRepository<UserRole, Integer> {
	@Query("select distinct u.role from UserRole u where u.user.username=?1")
	List<String>findCustomRoleByUsername(String username);
 
}
