package com.example.LibraryManagementRoleFilter.Service;

import com.example.LibraryManagementRoleFilter.Model.BookRecord;
import com.example.LibraryManagementRoleFilter.Model.Books;
import com.example.LibraryManagementRoleFilter.Repository.BookRecordRepository;
import com.example.LibraryManagementRoleFilter.Repository.BookRepository;
import com.example.LibraryManagementRoleFilter.Model.User;
import com.example.LibraryManagementRoleFilter.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRecordRepository bookRecordRepository;

    public User addStaff(User newStaff) {
        newStaff.setPassword("123");
        return userRepository.save(newStaff);
    }

    public Books addBook(Books book) {
        return bookRepository.save(book);
    }

    public List<Books> listAllBooks(){
        return bookRepository.findAll();
    }
    public List<Books> listAvailableBook() {
        return bookRepository.findAllByStatus(1);
    }

    public List<BookRecord> BookLogList() {
        return bookRecordRepository.findAll();
    }
}
