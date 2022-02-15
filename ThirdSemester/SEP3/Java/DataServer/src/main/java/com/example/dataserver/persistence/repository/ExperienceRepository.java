package com.example.dataserver.persistence.repository;

import com.example.dataserver.models.Experience;
import com.example.dataserver.models.User;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>
{
  Page<Experience> getAllByExperienceProviderId(@Param("experience_provider_user_id") int id, Pageable pageable);
  Experience findById(@Param("id") int id);
  boolean existsByIdAndStockIsGreaterThanEqual(@Param("id") int id, @Param("stock") int quantity);
  Page<Experience> findAllByExperienceProviderIdAndNameContainsIgnoreCase(@Param("experience_provider_id")int id, @Param("name") String name, Pageable pageable);
  Page<Experience> getAllByStockGreaterThan(@Param("stock") int stock, Pageable pageable);
  Page<Experience> getAllByExperienceCategoryIdAndStockGreaterThan(int experienceCategory_id, int stock, Pageable pageable);
  ArrayList<Experience> findTop3ByStockAfter(int stock);
  Page<Experience> findAllByNameContainingIgnoreCaseAndPriceIsLessThanEqual(@Param("name") String name, @Param("price") double price, Pageable pageable);
}
