package com.bookManageSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookManageSystem.entity.Author_entity;

public interface Author_repository extends JpaRepository<Author_entity, Integer> {

}
