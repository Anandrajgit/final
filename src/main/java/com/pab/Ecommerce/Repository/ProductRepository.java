package com.pab.Ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pab.Ecommerce.BeanClass.CartItems;
import com.pab.Ecommerce.BeanClass.ProductDetails;

@Repository
public interface ProductRepository extends JpaRepository<ProductDetails,Long>{

}
