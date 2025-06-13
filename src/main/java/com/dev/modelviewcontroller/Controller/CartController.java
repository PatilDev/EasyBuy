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
import com.dev.modelviewcontroller.Entity.UserTable;
import com.dev.modelviewcontroller.Service.CartService;
import com.dev.modelviewcontroller.repository.CartRepository;
import com.dev.modelviewcontroller.repository.PaymentHistoryRepository;
import com.dev.modelviewcontroller.repository.ProductRepository;
import com.dev.modelviewcontroller.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    // Display the cart page with all items for the logged-in user
    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session) {
        Object userIdObj = session.getAttribute("userId");
        if (userIdObj == null) {
            return "redirect:/logInPage";
        }

        int userId = (Integer) userIdObj;
        List<UserCart> cartItems = cartRepository.findByUserId(userId);

        int total = 0;
        for (UserCart item : cartItems) {
            total += item.getCPA() * item.getQuantity();
        }

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalAmount", total);
        return "cart";
    }

    // Handle product addition to cart
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("productId") int productId,
                            @RequestParam("userAddress") String userAddress,
                            @RequestParam("quantity") int quantity,
                            HttpSession session) {

        Object userIdObj = session.getAttribute("userId");
        if (userIdObj == null) {
            return "redirect:/logInPage";
        }

        int userId = (Integer) userIdObj;

        UserTable user = userRepository.findById(userId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);

        if (user != null && product != null) {
            UserCart cartItem = new UserCart();
            cartItem.setCPName(product.getProductName());
            cartItem.setCPA(product.getProductAmount());
            cartItem.setUserAdd(userAddress);
            cartItem.setQuantity(quantity);
            cartItem.setUser(user);
            cartRepository.save(cartItem);
        }

        return "redirect:/cart";
    }

    // Delete cart item by cart ID
    @PostMapping("/cart/delete/{cartId}")
    public String deleteCartItem(@PathVariable("cartId") int cartId) {
        cartRepository.deleteById(cartId);
        return "redirect:/cart";
    }

    // Show payment history page
    @GetMapping("/payment/history")
public String viewPaymentHistory(Model model, HttpSession session) {
    Object userIdObj = session.getAttribute("userId");
    if (userIdObj == null) {
        return "redirect:/logInPage";
    }

    int userId = (Integer) userIdObj;
    model.addAttribute("historyList", paymentHistoryRepository.findByUser_Id(userId));
    return "paymenthistory";
}


}
