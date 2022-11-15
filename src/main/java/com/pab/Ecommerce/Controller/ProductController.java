package com.pab.Ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pab.Ecommerce.BeanClass.ProductDetails;
import com.pab.Ecommerce.Service.ProductService;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/listProducts")
	public String showExampleView(Model model)
	{
		List<ProductDetails> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "/ViewProducts1";
	}
    @GetMapping("/entry")
    public String showAddProduct(Model model)
    {
    	List<ProductDetails> products = productService.getAllProduct();
		model.addAttribute("products", products);
    	return "/ViewProducts1";
    }
    
    
    @PostMapping("/addP")
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("compName") String compName,
    		@RequestParam("cateName") String cateName,
    		@RequestParam("procId") String procId,
            @RequestParam("procName") String procName,
			@RequestParam("description") String description,
			@RequestParam("price") String price)
    {
    	productService.saveProductToDB(file, compName,cateName
    			,procId,procName,description,price);
    	return "redirect:/listProducts";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
    	
    	productService.deleteProductById(id);
    	return "redirect:/listProducts";
    }
    
    @PostMapping("/changeName")
    public String changePname(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name)
    {
    	productService.chageProductName(id, name);
    	return "redirect:/listProducts.html";
    }
    @PostMapping("/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
    		@RequestParam("newDescription") String description)
    {
    	productService.changeProductDescription(id, description);
    	return "redirect:/listProducts.html";
    }
    
    @PostMapping("/changePrice")
    public String changePrice(@RequestParam("id") Long id ,
    		@RequestParam("newPrice") String price)
    {
    	productService.changeProductPrice(id, price);
    	return "redirect:/listProducts.html";
    }
	
}
