package com.bookManageSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookManageSystem.entity.Book_entity;

public interface Book_repository extends JpaRepository<Book_entity, Integer> {

}
