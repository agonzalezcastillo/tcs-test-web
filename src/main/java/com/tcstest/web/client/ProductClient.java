package com.tcstest.web.client;

import com.tcstest.web.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("product")
public interface ProductClient {

    @RequestMapping(value="/product/",  produces = {"application/json"}, method = RequestMethod.GET)
    ResponseEntity<List<Product>> getProducts() throws Exception;

    @RequestMapping(value="/product/",  produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Integer> createProduct(@RequestBody Product product) throws Exception;

    @RequestMapping(value="/product/{id}",  produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable(name="id") Integer productId) throws Exception;

    @RequestMapping(value="/product/",  produces = {"application/json"}, method = RequestMethod.PUT)
    public ResponseEntity<Integer> updateProduct(@RequestBody Product product) throws Exception;
}
