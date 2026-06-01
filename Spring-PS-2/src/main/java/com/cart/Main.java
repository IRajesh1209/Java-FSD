package com.billing;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* =====================================================
                SPRING BOOT MAIN
===================================================== */

@SpringBootApplication
public class BillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingApplication.class, args);
    }
}

/* =====================================================
                    PRODUCT ENTITY
===================================================== */

@Entity
@Table(name = "products")
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private double price;

    private double gst;

    private int quantity;

    private double total;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void calculateTotal() {

        double subtotal = price * quantity;

        double gstAmount = subtotal * gst / 100;

        this.total = subtotal + gstAmount;
    }
}

/* =====================================================
                    REPOSITORY
===================================================== */

interface ProductRepository extends JpaRepository<Product, Long> {

}

/* =====================================================
                    CONTROLLER
===================================================== */

@RestController
@CrossOrigin("*")
class BillingController {

    @Autowired
    private ProductRepository repository;

    /* =========================
            ADD PRODUCT
    ========================= */

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {

        product.calculateTotal();

        return repository.save(product);
    }

    /* =========================
            GET ALL
    ========================= */

    @GetMapping("/all")
    public List<Product> getAllProducts() {

        return repository.findAll();
    }

    /* =========================
            BILL SUMMARY
    ========================= */

    @GetMapping("/bill")
    public String getBillSummary() {

        List<Product> products = repository.findAll();

        double subtotal = 0;
        double gstTotal = 0;
        double grandTotal = 0;

        for(Product p : products) {

            double itemSubtotal = p.getPrice() * p.getQuantity();

            double itemGST = itemSubtotal * p.getGst() / 100;

            subtotal += itemSubtotal;

            gstTotal += itemGST;

            grandTotal += p.getTotal();
        }

        return
                "=========== BILL SUMMARY ===========\n" +
                        "Subtotal : ₹" + subtotal + "\n" +
                        "GST Total: ₹" + gstTotal + "\n" +
                        "Grand Total : ₹" + grandTotal + "\n" +
                        "===================================";
    }

    /* =========================
            DELETE PRODUCT
    ========================= */

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {

        repository.deleteById(id);

        return "Product Deleted Successfully";
    }
}