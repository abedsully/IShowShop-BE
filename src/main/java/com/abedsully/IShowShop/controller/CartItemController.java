package com.abedsully.IShowShop.controller;

import com.abedsully.IShowShop.exceptions.ResourceNotFoundException;
import com.abedsully.IShowShop.response.ApiResponse;
import com.abedsully.IShowShop.service.cart.ICardItemService;
import com.abedsully.IShowShop.service.cart.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cartItems")
public class CartItemController {
    private final ICardItemService cartItemService;
    private final ICartService cartService;

    @PostMapping("/add-to-cart")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestParam(required = false) Long cartId, @RequestParam Long productId, @RequestParam Integer quantity) {
        try {
            if(cartId == null) {
                cartId = cartService.initializeNewCart();
            }
            cartItemService.addItemToCart(cartId, productId, quantity);
            return ResponseEntity.ok(new ApiResponse("Item added successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), cartId));
        }
    }

    @DeleteMapping("remove-from-cart")
    public ResponseEntity<ApiResponse> removeItemFromCart(@RequestParam Long cartId, @RequestParam Long productId) {
        try {
            cartItemService.removeItemFromCart(cartId, productId);
            return ResponseEntity.ok(new ApiResponse("Item removed successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("update-quantity")
    public ResponseEntity<ApiResponse> updateItemQuantity(@RequestParam Long cartId, @RequestParam Long productId, @RequestParam Integer quantity) {
        try {
            cartItemService.updateItemQuantity(cartId, productId, quantity);
            return ResponseEntity.ok(new ApiResponse("Quantity updated successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
