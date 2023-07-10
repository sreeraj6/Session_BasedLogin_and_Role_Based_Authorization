package com.example.LibraryManagementRoleFilter.Repository;

import com.example.LibraryManagementRoleFilter.Model.BookRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRecordRepository extends JpaRepository<BookRecord, Long> {

    @Query(value = "SELECT * FROM bookrecords where userid = :uid and bid = :bid order by rid desc limit 1",nativeQuery = true)
    Optional<BookRecord> findByUidAndAndBid(Long uid,Long bid);

}
