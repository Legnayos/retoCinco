package com.reto.cinco.repository;

import com.reto.cinco.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Integer> {
    @Query("{'salesMan.zone': ?0}")
    public List<Order> findByZona(String zona);

    public List<Order> findAllBySalesMan_Zone(String zona);

    public List<Order> findAllBySalesMan_Id(int idSalesMan);

    @Query("{'salesMan.id': ?0}")
    public List<Order> encontrarOrdenesIdVen(int idSalesMan);
    public List<Order> findAllByStatusAndSalesMan_Id(String estado,int idSalesMan);

    @Query("{'status':?0 ,'salesMan.id': ?1}")
    public List<Order> encontrarOrdenesXEstadnIdVen(String estado,int idSalesMan);
}