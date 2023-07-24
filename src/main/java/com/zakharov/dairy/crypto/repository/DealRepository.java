package com.zakharov.dairy.crypto.repository;

import com.zakharov.dairy.crypto.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealRepository extends JpaRepository<Deal,Long> {

    List<Deal> getAllDealsByOwnerId(Long ownerId);
}
