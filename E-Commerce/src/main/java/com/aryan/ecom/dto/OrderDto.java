package com.aryan.ecom.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.aryan.ecom.enums.OrderStatus;
import lombok.Data;

@Data
public class OrderDto {
	private Long id;

	private String orderDescription;

	private Date date;

	private Long amount;

	private String address;

	private String payment;

	private OrderStatus orderStatus;

	private Long totalAmount;

	private Long discount;

	private UUID trackingId;

	private String userName;

	private List<CartItemsDto> cartItems;
	
	private String couponName;
	
	private String couponCode;
}
