package com.leeonscoding.inventory.product;

import com.leeonscoding.inventory.api.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/{type}")
    public ResponseEntity<HttpStatus> addProduct(@RequestBody AddProductInput addProductInput) throws ApiException {
        long productId = productService.addProduct(addProductInput);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOutput> getOne(@NotNull @PathVariable long id) throws ApiException {
        Product product = productService.getOne(id);

        return new ResponseEntity<>(new ProductOutput(product), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOutput> editProduct(@NotNull @PathVariable long id,
                                                     @RequestBody AddProductInput addProductInput) throws ApiException {
        productService.editProduct(addProductInput, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@NotNull @PathVariable long id) throws ApiException {
        deleteProduct(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<ProductsOutput> list(ContactListRequestParam contactListRequestParam) throws ApiException {
        List<Product> products = productService.list(contactListRequestParam);

        return new ResponseEntity<>(new ProductsOutput(products), HttpStatus.OK);
    }
}
