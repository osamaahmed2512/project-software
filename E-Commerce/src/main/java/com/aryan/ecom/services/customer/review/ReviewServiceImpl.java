package com.aryan.ecom.services.customer.review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aryan.ecom.dto.OrderedProductsResponseDto;
import com.aryan.ecom.dto.ProductDto;
import com.aryan.ecom.dto.ReviewDto;
import com.aryan.ecom.model.CartItems;
import com.aryan.ecom.model.Order;
import com.aryan.ecom.model.Product;
import com.aryan.ecom.model.Review;
import com.aryan.ecom.model.User;
import com.aryan.ecom.repository.OrderRepository;
import com.aryan.ecom.repository.ProductRepository;
import com.aryan.ecom.repository.ReviewRepository;
import com.aryan.ecom.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	private final OrderRepository orderRepository;
	
	private final ProductRepository productRepository;
	
	private final UserRepository userRepository;
	
	private final ReviewRepository reviewRepository;

	public OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId) {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		OrderedProductsResponseDto orderedProductsResponseDto = new OrderedProductsResponseDto();
		if (optionalOrder.isPresent()) {
			orderedProductsResponseDto.setOrderAmount(optionalOrder.get().getAmount());

			List<ProductDto> productDtoList = new ArrayList<>();
			for (CartItems cartItems : optionalOrder.get().getCartItems()) {
				ProductDto productDto = new ProductDto();
				productDto.setId(cartItems.getProduct().getId());
				productDto.setName(cartItems.getProduct().getName());
				productDto.setPrice(cartItems.getPrice());
				productDto.setQuantity(cartItems.getQuantity());
				productDto.setByteImg(cartItems.getProduct().getImg());

				productDtoList.add(productDto);
			}

			orderedProductsResponseDto.setProductDtoList(productDtoList);
			;
		}
		return orderedProductsResponseDto;
	}
	
	public ReviewDto giveReview(ReviewDto reviewDto) throws IOException {
		Optional<Product> optionalProduct = productRepository.findById(reviewDto.getProductId());
		Optional<User> optionalUser = userRepository.findById(reviewDto.getUserId());
		
		if(optionalProduct.isPresent() && optionalUser.isPresent()) {
			Review review = new Review();
			
			review.setDescription(reviewDto.getDescription());
			review.setRating(reviewDto.getRating());
			review.setUser(optionalUser.get());
			review.setProduct(optionalProduct.get());
			review.setImg(reviewDto.getImg().getBytes());
			
			return reviewRepository.save(review).getDto();
		}
		return null;
	}
	
}
