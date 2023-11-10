package com.diagnosticapplication.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diagnosticapplication.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // You can define custom query methods if needed
}

