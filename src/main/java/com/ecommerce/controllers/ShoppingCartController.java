package com.ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Buyer;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.response.CartResponse;
import com.ecommerce.service.ShoppingCartService;

@CrossOrigin("*")
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService cartService;
	
	@GetMapping(value = "/getAll/{bid}")
	public List<CartResponse> getAllCartItems(@PathVariable("bid") Integer buyerId) {
	return cartService.getAllCartItems(buyerId);
	}
//	@GetMapping(value = "/getAll")
//	public List<ShoppingCart> getAllCartItems() {
//		return cartService.getAllCartItems();
//	}
	
	@PostMapping(value="/addcartitem/{bid}")
	public ShoppingCart addCartItem(@PathVariable("bid") Integer buyerId,@RequestBody ShoppingCart shoppingCartItem) {
		//System.out.println("Adding"+shoppingCartItem.getItemQuantity());
		Optional<ShoppingCart> savedItem = cartService.addCartItem(shoppingCartItem, buyerId);
		return savedItem.get();
	}
	
	@DeleteMapping(value = "/deletecartitembyid/{cartitem}")
	public void deleteCartItem(@PathVariable("cartitem") Integer cartItemId) {
		cartService.deleteCartItemById(cartItemId);
	}
	
	@DeleteMapping(value = "/deleteall/{bid}")
	public void emptyCart(@PathVariable("bid") Integer buyerId) {
		cartService.emptyCart(buyerId);
	}
	
	@PutMapping(value = "/update",produces = "application/json")
	public CartResponse updateCart(@RequestBody CartResponse cartResponse) {
		return cartService.updateCart(cartResponse);
	}
	
	@GetMapping(value = "/checkout/{bid}")
	public void checkoutCart(@PathVariable("bid") Integer buyerId) {
		cartService.checkoutCart(buyerId);
	
	}

}
