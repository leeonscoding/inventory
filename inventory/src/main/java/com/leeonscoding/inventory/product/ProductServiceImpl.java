package com.leeonscoding.inventory.product;

import com.leeonscoding.inventory.api.AddProductInput;
import com.leeonscoding.inventory.api.ApiException;
import com.leeonscoding.inventory.api.ContactListRequestParam;
import com.leeonscoding.inventory.contact.Contact;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public long addProduct(AddProductInput addProductInput) throws ApiException {
        if(addProductInput == null) throw new ApiException("Bad parameters");

        Product product = Product
                .builder()
                .name(addProductInput.name())
                .description(addProductInput.description() == null ? "" : addProductInput.description())
                .purchasePrice(addProductInput.purchasePrice())
                .sellPrice(addProductInput.sellPrice())
                .stock(addProductInput.stock())
                .build();

        return productRepository.save(product).getId();
    }

    @Override
    public void editProduct(AddProductInput addProductInput, long id) throws ApiException {
        Product product = getOne(id);

        if(product != null) {
            addProduct(addProductInput);
        } else {
            throw new ApiException("Bad parameters");
        }
    }

    @Override
    public void deleteProduct(long id) throws ApiException {
        Product product = getOne(id);

        if(product != null) {
            productRepository.delete(product);
        } else {
            throw new ApiException("Bad parameters");
        }
    }

    @Override
    public Product getOne(long id) throws ApiException {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()) {
            throw new ApiException("Can't find item");
        }
        return productOptional.get();
    }

    @Override
    public List<Product> list(ContactListRequestParam param) throws ApiException {
        int offset = param.offset();
        int limit = param.limit();
        String sort = param.sort();
        String order = param.order();
        String token = param.searchToken();

        Sort sortObj = Sort.sort(Product.class).by(sort).descending();
        Pageable page = PageRequest.of(offset, limit, sortObj);

        List<Product> products;

        if(!token.isEmpty()) {
            products = productRepository.findByNameStartsWithIgnoreCase(token, page);
        } else {
            products = productRepository.findAll(page).stream().toList();
        }
        return products;
    }
}
