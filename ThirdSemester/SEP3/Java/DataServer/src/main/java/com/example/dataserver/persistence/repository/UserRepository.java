package com.example.dataserver.persistence.repository;

import com.example.dataserver.models.Provider;
import com.example.dataserver.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
  Page<User> getAllByProvider_isApproved(@Param("is_approved") boolean userInfo_approved, Pageable pageable);
  User getUserById(@Param("user_id") int id);
  User getUserByEmailAndPassword(@Param("email")String email, @Param("password")String password);
  Page<User> getAllByCustomer_FirstNameIsNotNull(Pageable pageable);
  Page<User> findAllByCustomer_FirstNameContainingIgnoreCase(@Param("first_name") String name, Pageable pageable);
  Page<User> findAllByProvider_isApprovedAndProvider_CompanyNameContainingIgnoreCase(@Param("is_approved") boolean isApproved, @Param("company_name") String name, Pageable pageable);
}
