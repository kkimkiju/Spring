package com.kh.totalEx.repository;

import com.kh.totalEx.entitiy.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
