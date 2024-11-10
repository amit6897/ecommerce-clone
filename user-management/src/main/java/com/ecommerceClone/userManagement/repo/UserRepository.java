package com.ecommerceClone.userManagement.repo;

import com.ecommerceClone.userManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
