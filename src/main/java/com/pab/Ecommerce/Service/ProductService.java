package com.pab.Ecommerce.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pab.Ecommerce.BeanClass.ProductDetails;
import com.pab.Ecommerce.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	public void  saveProductToDB(MultipartFile file,String compName,String cateName
			,String procId,String procName , String description, String price)
	{
		ProductDetails p = new ProductDetails();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setCateName(cateName);
		p.setCompName(compName);
		p.setProcId(procId);
		p.setProcName(procName);
        p.setDescription(description);
        p.setPrice(price);
        
        productRepo.save(p);
	}
	public List<ProductDetails> getAllProduct()
	{
		return productRepo.findAll();
	}
    public void deleteProductById(Long id)
    {
    	productRepo.deleteById(id)
;
    }
    public void chageProductName(Long id ,String name)
    {
    	ProductDetails p = new ProductDetails();
    	p = productRepo.findById(id).get();
    	p.setProcName(name);
    	productRepo.save(p);    
    }
    public void changeProductDescription(Long id , String description)
    {
    	ProductDetails p = new ProductDetails();
    	p = productRepo.findById(id).get();
    	p.setDescription(description);
    	productRepo.save(p);
    }
    public void changeProductPrice(Long id,String price)
    {
    	ProductDetails p = new ProductDetails();
    	p = productRepo.findById(id).get();
    	p.setPrice(price);
    	productRepo.save(p);
    }
    
    public ProductDetails detailsById(Long id) {
		return productRepo.findById(id).get();
	}
}
