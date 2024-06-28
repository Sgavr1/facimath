package com.facimath.facimath.repository;

import com.facimath.facimath.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    @Query(value = "Select t From Test t Where user.id = :id")
    List<Test> getAllByUser(Long id);

    @Query(value = "Select t From Test t Where user.id = :id And status = True")
    List<Test> getAllNotFinishByUser(Long id);
}