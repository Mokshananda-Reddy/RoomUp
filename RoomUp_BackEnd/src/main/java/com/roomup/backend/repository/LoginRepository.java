package com.roomup.backend.repository;

import com.roomup.backend.model.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<LoginDetails, String> {
    @Query(value = "SELECT * from login_details l where l.username = :username and l.role = :role" , nativeQuery = true)
    LoginDetails getPasswordByUsername(@Param("username") String username, @Param("role") String role);

}
