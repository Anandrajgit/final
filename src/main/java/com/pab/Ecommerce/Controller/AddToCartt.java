//package com.pab.Ecommerce.Controller;
//
//import java.security.Principal;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.pab.Ecommerce.BeanClass.CartItems;
//import com.pab.Ecommerce.Service.AddToCartSer;
//
//@Controller
//public class AddToCartt {
//
//	@Autowired (required=false)
//	private AddToCartSer cartService;
//	
//	 @PostMapping("/addToCart/{userid}")
//	 public String addToCart(@PathVariable String id, @ModelAttribute CartItems cartItems, Principal principal){
//
//	     //to save to cartItem table.
//	     cartService.addToCart(id, cartItems, principal.getName());
//
//	     return "products";
//	 }
//
//	 @GetMapping("/myCart")
//	 public  String myCart ( @AuthenticationPrincipal Principal principal, Model model){
//
//	    List<CartItems> cartItems =  cartService.myCart(principal.getName());
//	    model.addAttribute("cartItems",cartItems);
//	     return "myCart";
//	 }
//	
//}
