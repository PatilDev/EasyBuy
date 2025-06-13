# 🛍️ EasyBuy – Spring Boot E-Commerce Project

**EasyBuy** is a full-stack e-commerce web application built using Spring Boot, Thymeleaf, JPA, and integrated with Razorpay for online payments. It provides features like product listing, cart management, and secure checkout.

---

## 🧑‍💻 Tech Stack

### 🔹 Frontend
- Thymeleaf (HTML templating)
- HTML5 & CSS3

### 🔹 Backend
- Spring Boot
- Spring Data JPA (Hibernate ORM)
- Razorpay API (payment gateway integration)

### 🔹 Database
- MySQL

---

## 📦 Project Modules

### 1. 👤 `User`
- Handles registration and login.
- Credentials validated from the database.

### 2. 📦 `Product`
- Stores product details: name, price, description, image.
- Displayed on the user interface.

### 3. 🛒 `Cart`
- Temporarily stores selected items per user.
- Items are passed to Razorpay during checkout.

### 4. 💳 `Payment`
- Stores transaction details from Razorpay.
- Linked with the cart and user for order history.

---

## 💳 Razorpay Integration

- Integrated Razorpay’s **test payment gateway** using API keys.
- Users can simulate payments using Razorpay Checkout.
- Payment confirmation and Razorpay Payment ID are saved for records.
- 
## 👨‍💼 Developed By
   **Devendra Patil**

