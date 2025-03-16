package com.scaler.ecomproductservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scaler.ecomproductservice.model.Category;
import com.scaler.ecomproductservice.model.Order;
import com.scaler.ecomproductservice.model.Price;
import com.scaler.ecomproductservice.model.Product;
import com.scaler.ecomproductservice.repository.CategoryRepository;
import com.scaler.ecomproductservice.repository.OrderRepository;
import com.scaler.ecomproductservice.repository.PriceRepository;
import com.scaler.ecomproductservice.repository.ProductRepository;

@Service
public class InitServiceImpl implements InitService {

    private ProductRepository productRepository;
    private PriceRepository priceRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;

    

    public InitServiceImpl(ProductRepository productRepository, PriceRepository priceRepository,
            OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }



    @Override
    public void initialize() {
        Category electronics = new Category();
        electronics.setCategoryName("Electronics");
        
        electronics = categoryRepository.save(electronics);

        Price priceIphone = new Price();
        priceIphone.setCurrency("INR");
        priceIphone.setAmount(100000);
        priceIphone.setDiscount(0);

        Price priceMacbook = new Price();
        priceMacbook.setCurrency("INR");
        priceMacbook.setAmount(200000);
        priceMacbook.setDiscount(0);

        Price priceWatch = new Price();
        priceWatch.setCurrency("INR");
        priceWatch.setAmount(40000);
        priceWatch.setDiscount(0);

        priceIphone = priceRepository.save(priceIphone);
        priceMacbook = priceRepository.save(priceMacbook);
        priceWatch = priceRepository.save(priceWatch);

        Product iphone = new Product();
        iphone.setTitle("Iphone 15 Pro");
        iphone.setDescription("Best iphone ever.");
        iphone.setImage("https://www.apple.com/in/iphone-15-pro/");
        iphone.setPrice(priceIphone);
        iphone.setCategory(electronics);
        iphone = productRepository.save(iphone);

        Product macbook = new Product();
        macbook.setTitle("Macbook Pro 16");
        macbook.setDescription("Best macbook ever.");
        macbook.setImage("https://www.apple.com/in/macbook-pro/");
        macbook.setPrice(priceMacbook);
        macbook.setCategory(electronics);
        macbook = productRepository.save(macbook);

        Product watch = new Product();
        watch.setTitle("Watch Series 10");
        watch.setDescription("Best watch ever.");
        watch.setImage("https://www.apple.com/in/apple-watch/");
        watch.setPrice(priceWatch);
        watch.setCategory(electronics);
        watch = productRepository.save(watch);

        Order order = new Order();
        order.setProducts(List.of(iphone, macbook, watch));
        order = orderRepository.save(order);
    }

}
