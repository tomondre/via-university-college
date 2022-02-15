package com.example.dataserver.persistence.repository;

import com.example.dataserver.models.Order;
import com.example.dataserver.models.ProviderVouchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.ArrayList;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{
    Page<Order> getAllByUser_Id(@Param("customer_id") int id, Pageable pageable);

    Order getOrderById(@Param("id") int id);

    @Query(nativeQuery = true)
    ArrayList<ProviderVouchers> getProviderVouchers(int providerId);
}
