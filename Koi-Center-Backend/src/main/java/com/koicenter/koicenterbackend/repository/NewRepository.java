package com.koicenter.koicenterbackend.repository;

import com.koicenter.koicenterbackend.model.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends JpaRepository<News, String> {
}
