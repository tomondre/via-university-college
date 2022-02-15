package com.example.dataserver.persistence.repository;

import com.example.dataserver.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<Category, Integer> {
//    Page<Category> getAll(Pageable pageable);
}
