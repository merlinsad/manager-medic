package com.med.rest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.med.rest.domain.entitys.User;

public interface UserRepository extends JpaRepository<User, Long>{

   public UserDetails findByLogin(String username);
}
