package com.example.testhr.Repository;

import com.example.testhr.Entyties.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
