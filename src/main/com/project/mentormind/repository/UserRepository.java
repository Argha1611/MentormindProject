package com.project.mentormind.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.mentormind.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {
}
