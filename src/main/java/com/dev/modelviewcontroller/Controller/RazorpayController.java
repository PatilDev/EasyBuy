package com.dev.modelviewcontroller.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.modelviewcontroller.Entity.PaymentHistory;
import com.dev.modelviewcontroller.Entity.UserCart;
import com.dev.modelviewcontroller.Service.RazorpayService;
import com.dev.modelviewcontroller.repository.CartRepository;
import com.dev.modelviewcontroller.repository.PaymentHistoryRepository;
import com.razorpay.RazorpayException;

@Controller
public class RazorpayController {

    @Autowired
    private RazorpayService razorpayService;

    @Autowired
    private CartRepository userCartRepository;

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    // Step 1: Show checkout page from DB
    @GetMapping("/cart/checkout/{cartId}")
public String checkout(@PathVariable("cartId") int cartId, Model model) throws RazorpayException {
    UserCart cart = userCartRepository.findById(cartId).orElse(null);
    if (cart == null) {
        return "error";
    }

    int totalAmount = cart.getCPA() * cart.getQuantity(); // ✅ Correct total amount

    String receiptId = "order_rcpt_" + cart.getCartid();
    String orderId = razorpayService.createOrder(totalAmount, "INR", receiptId); // updated

    model.addAttribute("cart", cart);
    model.addAttribute("orderId", orderId);
    model.addAttribute("amount", totalAmount * 100); // Razorpay takes amount in paisa
    model.addAttribute("currency", "INR");
    model.addAttribute("apiKey", "rzp_test_g97vacSeEXMMaB");

    return "checkout";
}



    // Step 2: Payment handler callback (POST)
    @PostMapping("/payment/success")
    public String handlePaymentSuccess(@RequestParam("razorpay_payment_id") String paymentId,
                                       @RequestParam("razorpay_order_id") String orderId,
                                       @RequestParam("cartId") int cartId,Model model) {
        UserCart cart = userCartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            PaymentHistory history = new PaymentHistory(
    paymentId,
    orderId,
    cart.getCPName(),
    cart.getCPA() * cart.getQuantity(), // ✅ total paid
    "INR",
    cart.getUserAdd(),
    LocalDateTime.now(),
     cart.getUser());

            paymentHistoryRepository.save(history);
        }
model.addAttribute("paymentId", paymentId);
        return "success";
    }
}
