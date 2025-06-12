package com.dev.modelviewcontroller.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.modelviewcontroller.Entity.Product;
import com.dev.modelviewcontroller.Entity.UserCart;
import com.dev.modelviewcontroller.Service.CartService;
import com.dev.modelviewcontroller.repository.CartRepository;
import com.dev.modelviewcontroller.repository.PaymentHistoryRepository;
import com.dev.modelviewcontroller.repository.ProductRepository;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    // Display the cart page with all items
   @GetMapping("/cart")
public String viewCart(Model model) {
    List<UserCart> cartItems = cartService.getAllItem();

    int total = 0;
    for (UserCart item : cartItems) {
        total += item.getCPA() * item.getQuantity();
    }

    model.addAttribute("cartItems", cartItems);
    model.addAttribute("totalAmount", total); // pass total to the view

    return "cart";
}

    // Handle product addition to cart
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("productId") int productId,
                            @RequestParam("userAddress") String userAddress,
                            @RequestParam("quantity") int quantity) {

        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            UserCart cartItem = new UserCart();
            cartItem.setCPName(product.getProductName());
            cartItem.setCPA(product.getProductAmount());
            cartItem.setUserAdd(userAddress);
            cartItem.setQuantity(quantity);

            cartRepository.save(cartItem);
        }

        return "redirect:/cart"; // After adding, redirect to the cart page
    }
    @PostMapping("/cart/delete/{cartId}")
public String deleteCartItem(@PathVariable("cartId") int cartId) {
    cartRepository.deleteById(cartId);
    return "redirect:/cart"; // reload cart page after deletion
}
@Autowired
private PaymentHistoryRepository paymentHistoryRepository;
@GetMapping("/payment/history")
public String viewPaymentHistory(Model model) {
    model.addAttribute("historyList", paymentHistoryRepository.findAll());
    return "paymenthistory";
}

}
