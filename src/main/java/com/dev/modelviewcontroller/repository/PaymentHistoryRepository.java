package com.dev.modelviewcontroller.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.modelviewcontroller.Entity.PaymentHistory;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
}
