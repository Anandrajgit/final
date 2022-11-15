package com.pab.Ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pab.Ecommerce.BeanClass.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long>{

	List<CartItems>  findByUsername(String username);
}
