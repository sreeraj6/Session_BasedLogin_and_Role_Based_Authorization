package com.example.LibraryManagementRoleFilter.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bookrecords")
public class BookRecord {

    @Id
    @Column(name = "rid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long rid;

    @Column(name = "bid")
    Long bid;

    @Column(name = "userid")
    Long uid;

    @Column(name = "givenDate")
    Date giveDate;

    @Column(name = "returnDate")
    Date returnDate;
}
