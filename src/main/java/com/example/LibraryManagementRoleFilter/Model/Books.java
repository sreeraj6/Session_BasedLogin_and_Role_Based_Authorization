package com.example.LibraryManagementRoleFilter.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "book")
public class Books {

    @Id
    @Column(name = "bid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bid;

    @Column(name = "name")
    String name;

    @Column(name = "author")
    String author;

    @Column(name = "status")
    int status;
}
