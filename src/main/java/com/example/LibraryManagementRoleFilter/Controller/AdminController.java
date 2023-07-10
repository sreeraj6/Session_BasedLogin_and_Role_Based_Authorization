package com.example.LibraryManagementRoleFilter.Controller;

import com.example.LibraryManagementRoleFilter.Model.BookRecord;
import com.example.LibraryManagementRoleFilter.Model.Books;
import com.example.LibraryManagementRoleFilter.Model.User;
import com.example.LibraryManagementRoleFilter.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add-staff")
    public User addStaff(@RequestBody User staff){
        return adminService.addStaff(staff);
    }

    @PostMapping("/add-book")
    public Books addBook(@RequestBody Books book) {
        return adminService.addBook(book);
    }

    @GetMapping("/list-book")
    public List<Books> listBooks(){
        return adminService.listAllBooks();
    }

    @GetMapping("/list-available")
    public List<Books> listAvailableBooks(){
        return adminService.listAvailableBook();
    }

    @GetMapping("/history")
    public List<BookRecord> bookRecordList() {
        return adminService.BookLogList();
    }
}
