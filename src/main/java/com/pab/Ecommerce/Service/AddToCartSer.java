//package com.pab.Ecommerce.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.pab.Ecommerce.BeanClass.CartItems;
//import com.pab.Ecommerce.BeanClass.ProductDetails;
//import com.pab.Ecommerce.Repository.CartItemsRepository;
//import com.pab.Ecommerce.Repository.ProductRepository;
//
//public class AddToCartSer {
//
//	@Autowired
//	private CartItemsRepository cartItemsRepository;
//	
//	@Autowired
//	private ProductRepository productRepository;
//	
//	public void addToCart(String id, CartItems cartItems, String username){
//
//		ProductDetails product = productRepository.findById(id).orElse(null);  
//		    cartItems.setProduct(product);
//
//	           //cartItems.setSubTotal(product.getPrice());
//		       //cartItems.setSubTotal(product.getPrice());
//		        cartItems.setUsername(username);
//
//		        cartItemsRepository.save(cartItems);
//
//		}
//		public List<CartItems> myCart(String userName){
//
//		    List<CartItems> cartItems = new ArrayList<>();
//	
//		    cartItemsRepository.findByUsername(userName).forEach(cartItems::add);
//
//		    return cartItems;
//		}
//	
//	
//}
