package com.dev.modelviewcontroller.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dev.modelviewcontroller.Entity.Product;
import com.dev.modelviewcontroller.Service.ProductService;
import com.dev.modelviewcontroller.repository.ProductRepository;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/productType")
    public String productsByType(@ModelAttribute Product product, Model model) {
        String list = product.getProductType();
        model.addAttribute("list", list);
        return "ProductCategory";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @PostMapping("/addProduct")
    public String saveProduct(@RequestParam("productName") String name,@RequestParam("productType") String type,@RequestParam("productAmount") int amount, @RequestParam("productQuantity") int quantity,@RequestParam("image") MultipartFile file) throws IOException {
        
        Product product = new Product();
        product.setProductName(name);
        product.setProductType(type);
        product.setProductAmount(amount);
        product.setProductQuantity(quantity);
        product.setImage(file.getBytes());

        productService.addproduct(product);
        return "redirect:/productList";
    }

    @GetMapping("/productList")
    public String viewAll(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "productList";
    }

    @GetMapping("/product-image/{id}")
    @ResponseBody
    public byte[] getImage(@PathVariable int id) {
        Product product = productService.getProductById(id);
        return product.getImage();
    }

    @GetMapping("/search")
public String searchByName(@RequestParam("query") String type, Model model) {
    List<Product> searchResults = productRepository.findByProductType(type);
    
    if (searchResults.isEmpty()) {
        model.addAttribute("message", "No products found for your search.");
    }
    
    model.addAttribute("searchResults", searchResults);
    return "productByName";
}
}
