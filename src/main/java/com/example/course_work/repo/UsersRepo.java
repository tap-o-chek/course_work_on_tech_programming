package com.example.course_work.repo;

import com.example.course_work.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepo extends JpaRepository<User,Long> {
    // Ignore Case гарантирует что запрос не зависит от регистра
    @Query(value = "select * from where lastName.account like :lastName ", nativeQuery = true)
    User findByLastNameIgnoreCase(String lastName);
}
