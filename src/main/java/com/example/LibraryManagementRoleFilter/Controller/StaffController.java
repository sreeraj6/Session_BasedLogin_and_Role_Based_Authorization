package com.example.LibraryManagementRoleFilter.Controller;

import com.example.LibraryManagementRoleFilter.Dto.BookAssignResponse;
import com.example.LibraryManagementRoleFilter.Model.BookRecord;
import com.example.LibraryManagementRoleFilter.Model.Books;
import com.example.LibraryManagementRoleFilter.Service.AdminService;
import com.example.LibraryManagementRoleFilter.Service.StaffService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private StaffService staffService;
    @GetMapping("/list-book")
    public List<Books> listBooks() {
        return adminService.listAllBooks();
    }

    @GetMapping("/list-available")
    public List<Books> listAvailable(){
        return adminService.listAvailableBook();
    }

    @PostMapping("/assign-book/{uid}")
    BookAssignResponse assignBook(@PathVariable("uid") Long uid, @RequestParam(name = "bid") Long bid){
        return staffService.assignBook(uid,bid);
    }

    @PostMapping("/recieved-book/{uid}")
    BookAssignResponse bookRecieved(@PathVariable("uid") Long uid, @RequestParam(name = "bid") Long bid) {
        return staffService.bookRecieved(uid,bid);
    }


    @GetMapping("/history")
    List<BookRecord> bookLogList(){
        return adminService.BookLogList();
    }
}
