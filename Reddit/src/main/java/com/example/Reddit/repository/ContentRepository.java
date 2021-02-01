package com.example.Reddit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Reddit.model.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

}
