package com.expertus.expertusprojet.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expertus.expertusprojet.bean.Product;

public interface ProductService {

//    @RequestMapping("/companies")
//    Resources<Product> findAll();

    @RequestMapping(value = "/companies", method = RequestMethod.POST)
    Product add(@RequestBody Product company);

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.PUT)
    Product update(@PathVariable("id") Long id, @RequestBody Product company);

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id);
}
