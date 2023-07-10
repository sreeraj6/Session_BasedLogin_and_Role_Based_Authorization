package com.example.LibraryManagementRoleFilter.Repository;

import com.example.LibraryManagementRoleFilter.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
