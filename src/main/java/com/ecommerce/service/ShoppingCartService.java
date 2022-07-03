package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Buyer;
import com.ecommerce.model.PurchaseHistory;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.model.TransactionHistory;
import com.ecommerce.repository.BuyerRepository;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.PurchaseRepository;
import com.ecommerce.repository.TransactionRepository;
import com.ecommerce.response.CartResponse;

@Service
public class ShoppingCartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private BuyerRepository buyerRepository;
	
//	@Autowired
//	private ItemRepository itemrepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
//	public List<ShoppingCart> getAllCartItems(Integer buyerId){
//		return cartRepository.findAllByBuyerId(buyerId);
//	}
	public List<CartResponse> getAllCartItems(Integer buyerId){
		List<CartResponse> cartResponse = new ArrayList<CartResponse>();
		List<ShoppingCart> shoppingCart = cartRepository.getAllCartItems(buyerId);
		for(ShoppingCart cart : shoppingCart) {
			CartResponse setCart = new CartResponse();
			setCart.setCartId(cart.getCartId());
			setCart.setItemId(cart.getItemId());
			setCart.setItemQuantity(cart.getItemQuantity());
			setCart.setUnitPrice(cart.getUnitPrice());
			cartResponse.add(setCart);
		}
		return cartResponse;
	}
	
	public Optional<ShoppingCart> addCartItem(ShoppingCart shoppingCartItem, Integer buyerId) {
		
		System.out.println("Service"+buyerId);
		return buyerRepository.findById(buyerId).map(buyer -> {
			shoppingCartItem.setBuyerId(buyer);
			return cartRepository.save(shoppingCartItem);
		});
		
	}
	
	public void deleteCartItemById(Integer cartItemId) {
		cartRepository.deleteById(cartItemId);
	}
	
	public void emptyCart(Integer buyerId) {
		//Optional<Buyer> buyerInfo = buyerRepository.findById(buyerId);
		System.out.println(buyerId);
		cartRepository.emptyCart(buyerId);
	}
	
	public CartResponse updateCart(CartResponse cartResponse) {
		ShoppingCart newCart = null;
		CartResponse cartResp = new CartResponse();
		Optional<ShoppingCart> cartItem = cartRepository.findById(cartResponse.getCartId());
		
		if(cartItem.isPresent()) {
		newCart = cartItem.get();
		newCart.setItemQuantity(cartResponse.getItemQuantity());
		cartRepository.save(newCart);
		cartResp.setCartId(newCart.getCartId());
		cartResp.setItemId(newCart.getItemId());
		cartResp.setItemQuantity(newCart.getItemQuantity());
		return cartResp;
		}
		
		return null;
		
	}
	
	
	public void checkoutCart(Integer buyerId) {
		
		Double totalAmount = 0.00;
		TransactionHistory transaction = null;
		PurchaseHistory purchaseHistory = null;
		
		List<ShoppingCart> getAllCart = cartRepository.getAllCartItems(buyerId);
		for(ShoppingCart cart : getAllCart) {
			totalAmount += cart.getUnitPrice()*cart.getItemQuantity();
			
		}
		Optional<Buyer> buyer  = buyerRepository.findById(buyerId);
		transaction = new TransactionHistory();
		transaction.setBuyerId(buyer.get());
		transaction.setTotalAmount(totalAmount);
		transaction.setTransactionType("Debited");
		transaction.setTransactionRemarks("PaymentDone");
		
		transactionRepository.save(transaction);
		
		for(ShoppingCart cart : getAllCart) {
			purchaseHistory = new PurchaseHistory();
			
			purchaseHistory.setTransactionHistory(transaction);
			purchaseHistory.setItemId(cart.getItemId());
			purchaseHistory.setBuyerId(buyer.get());
			purchaseHistory.setPurchaseRemarks("purchased");
			purchaseHistory.setNumberOfItems(cart.getItemQuantity());
			purchaseRepository.save(purchaseHistory);
		}
		
//		deleteCart = new ShoppingCartService();
//		deleteCart.emptyCart(buyerId);
			cartRepository.emptyCart(buyerId);
		
	}
	
	

}
