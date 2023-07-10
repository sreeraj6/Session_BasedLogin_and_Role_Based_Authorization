package com.example.LibraryManagementRoleFilter.Repository;

import com.example.LibraryManagementRoleFilter.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

    List<Books> findAllByStatus(int status);
}
