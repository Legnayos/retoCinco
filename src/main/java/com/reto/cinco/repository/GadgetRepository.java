package com.reto.cinco.repository;

import com.reto.cinco.entity.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GadgetRepository extends MongoRepository<Gadget,Integer> {
    @Query("{'price': { $lte :?0 } }")
    public List<Gadget> gadgetsPrecioMenorIgual(double price);

    public List<Gadget> findAllByPriceLessThanEqual(double price);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Gadget> findByDescLike(String desc);

    public List<Gadget> findByDescriptionContains(String desc);
}
