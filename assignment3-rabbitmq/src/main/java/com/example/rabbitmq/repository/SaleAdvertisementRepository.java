package com.example.rabbitmq.repository;

import com.example.rabbitmq.entity.SaleAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleAdvertisementRepository extends JpaRepository<SaleAdvertisement, Long> {

}
