package com.aryan.ecom.services.admin.coupon;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aryan.ecom.exceptions.ValidationException;
import com.aryan.ecom.model.Coupon;
import com.aryan.ecom.repository.CouponRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminCouponServiceImpl implements AdminCouponService {
	private final CouponRepository couponRepository; 
	
	public Coupon createCoupon(Coupon coupon) {
		System.out.println(coupon.getCode());
		if(couponRepository.existsByCode(coupon.getCode())) {
			throw new ValidationException("Coupon code already exists");
		}else {
			return couponRepository.save(coupon);
		}
	}
	
	public List<Coupon> getAllCoupon(){
		return couponRepository.findAll();
	}
}



// package com.aryan.ecom.services.admin.coupon;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.aryan.ecom.exceptions.ValidationException;
// import com.aryan.ecom.model.Coupon;
// import com.aryan.ecom.repository.CouponRepository;
// import com.aryan.ecom.services.AESUtils;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class AdminCouponServiceImpl implements AdminCouponService {
//     private final CouponRepository couponRepository;

//     public Coupon createCoupon(Coupon coupon) {
//         String encryptedCode = AESUtils.encrypt(coupon.getCode()); // Encrypt coupon code
//         coupon.setCode(encryptedCode);
//         if (couponRepository.existsByCode(encryptedCode)) {
//             throw new ValidationException("Coupon code already exists");
//         } else {
//             return couponRepository.save(coupon);
//         }
//     }

//     public List<Coupon> getAllCoupon() {
//         List<Coupon> coupons = couponRepository.findAll();
//         // Decrypt coupon codes
//         for (Coupon coupon : coupons) {
//             String decryptedCode = AESUtils.decrypt(coupon.getCode());
//             coupon.setCode(decryptedCode);
//         }
//         return coupons;
//     }
// }
