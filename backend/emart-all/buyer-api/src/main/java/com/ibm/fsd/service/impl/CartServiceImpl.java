package com.ibm.fsd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fsd.entity.Cart;
import com.ibm.fsd.exception.BusinessException;
import com.ibm.fsd.repository.CartRepository;
import com.ibm.fsd.service.CartService;

/**
 * 
 * cart service
 *
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	@Override
	public Cart save(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public void delete(String productCode) {
		Cart cart = cartRepository.findByProductCode(productCode);
		if (cart == null) throw new BusinessException("20", "Shopping cart item does not exist!");
		cartRepository.delete(cart);
	}
}
