package com.example.dataserver.persistence.repository;

import java.time.LocalDateTime;
import java.util.Set;

public interface ProviderVouchersTest {
    LocalDateTime getCreated_on();

    Set<OrderItemInfo> getItems();

    interface OrderItemInfo {
        String getName();

        String getVoucher();

        int getQuantity();
    }
}
