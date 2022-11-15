package com.pab.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pab.Ecommerce.BeanClass.CategoryDetails;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryDetails,Integer>{

}
