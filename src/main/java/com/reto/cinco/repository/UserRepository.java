package com.reto.cinco.repository;

import com.reto.cinco.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);

    List<User> findByMonthBirthtDay(String monthBirthtDay);

    @Query("{ monthBirthtDay: ?0}")
    List <User> usuariosCumpleMes(String monthBirthtDay);
}

