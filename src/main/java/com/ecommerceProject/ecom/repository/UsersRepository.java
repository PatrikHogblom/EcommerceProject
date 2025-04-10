package com.ecommerceProject.ecom.repository;

import com.ecommerceProject.ecom.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
    //todo: findbyrole -> to find existing admin, not prio
}
