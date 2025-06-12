package com.dev.modelviewcontroller.Service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorpayService {

    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecret;

    // Create Razorpay order
    public String createOrder(int amount, String currency, String receiptId) {
        try {
            RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);

            // Prepare order details
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount * 100); // amount in paise
            orderRequest.put("currency", currency);
            orderRequest.put("receipt", receiptId);
            orderRequest.put("payment_capture", 1); // auto capture

            // Create the order
            Order order = razorpayClient.orders.create(orderRequest);

            // Return only the order ID
            return order.get("id");
        } catch (RazorpayException e) {
            e.printStackTrace();
            return null;
        }
    }
}
