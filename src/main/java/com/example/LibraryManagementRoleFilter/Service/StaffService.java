package com.example.LibraryManagementRoleFilter.Service;

import com.example.LibraryManagementRoleFilter.Dto.BookAssignResponse;
import com.example.LibraryManagementRoleFilter.Model.BookRecord;
import com.example.LibraryManagementRoleFilter.Model.Books;
import com.example.LibraryManagementRoleFilter.Repository.BookRecordRepository;
import com.example.LibraryManagementRoleFilter.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StaffService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookRecordRepository bookRecordRepository;

    public BookAssignResponse assignBook(Long uid, Long bid) {
        Books currBook = bookRepository.getById(bid);

        if(currBook.getStatus() == 0) {
            return new BookAssignResponse(null, "Book Not Available");
        }
        var order = BookRecord
                .builder().uid(uid)
                .bid(bid).giveDate(new Date())
                .build();
        bookRecordRepository.save(order);


        currBook.setStatus(0);
        bookRepository.save(currBook);
        return new BookAssignResponse(bid, "Book assigned to user");
    }


    public BookAssignResponse bookRecieved(Long uid, Long bid) {
        BookRecord existRecord = bookRecordRepository.findByUidAndAndBid(uid,bid).get();
        existRecord.setReturnDate(new Date());
        bookRecordRepository.save(existRecord);
        Books book = bookRepository.getById(bid);
        book.setStatus(1);
        return new BookAssignResponse(uid, "Book returned Successfully");
    }
}
