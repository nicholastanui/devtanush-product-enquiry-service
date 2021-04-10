package com.devtanush.microservices.productenquiryservice.devtanushproductenquiryservice.controller;

import com.devtanush.microservices.productenquiryservice.devtanushproductenquiryservice.beans.ProductEnquiryBean;
import com.devtanush.microservices.productenquiryservice.devtanushproductenquiryservice.client.ProductStockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class ProductEnquiryController {

    @Autowired
    ProductStockClient client;

    @GetMapping("/product-enquiry/name/{name}/availability/{availability}/unit/{unit}")
    public ProductEnquiryBean getEnquiruOfProduct(@PathVariable String name,
                                                  @PathVariable String availability,
                                                  @PathVariable int unit
                                                  ) {
        ProductEnquiryBean productEnquiryBean = client.checkProductStock(name, availability);
        double totalPrice = productEnquiryBean.getProductPrice().doubleValue()*unit;
        double discounts = productEnquiryBean.getDiscountOffer();
        double discountPrice = totalPrice*discounts/100;

        return new ProductEnquiryBean(
                productEnquiryBean.getId(),
                name,
                productEnquiryBean.getProductPrice(),
                availability,
                productEnquiryBean.getDiscountOffer(),
                unit,
                discountPrice,
                productEnquiryBean.getPort()
                );

    }
}
