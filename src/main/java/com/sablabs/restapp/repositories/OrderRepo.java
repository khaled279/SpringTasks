package com.sablabs.restapp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sablabs.restapp.Entity.Order;

public interface OrderRepo extends  JpaRepository<Order,Integer> {
    @Modifying
    @Query(value = "INSERT INTO orders (total , userid) VALUES (:total , :userid)", nativeQuery =true)
    public void addOrder(@Param("total") Integer total ,@Param("userid") Integer userid);

}
