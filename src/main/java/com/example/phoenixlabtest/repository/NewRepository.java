package com.example.phoenixlabtest.repository;

import com.example.phoenixlabtest.model.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NewRepository extends JpaRepository<New, Long> {
}
