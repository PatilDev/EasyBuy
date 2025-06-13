package com.dev.modelviewcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.modelviewcontroller.Entity.PaymentHistory;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Integer> {

    List<PaymentHistory> findByUser_Id(int userId);
}
