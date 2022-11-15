package com.pab.Ecommerce.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pab.Ecommerce.BeanClass.CategoryDetails;
import com.pab.Ecommerce.BeanClass.CompanyDetails;
import com.pab.Ecommerce.Repository.CategoryRepository;
import com.pab.Ecommerce.Repository.CompanyRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository cateReposit;

	public void insertRecords(CategoryDetails category) {
		cateReposit.save(category);
	}
	
	public List<CategoryDetails> getAllCategories(){
		return cateReposit.findAll();
	}	 
}
