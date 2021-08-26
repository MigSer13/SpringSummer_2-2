package ru.geekbrains.summer.market.ws.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.ws.entities.ProductEntity;
import ru.geekbrains.summer.market.ws.repositories.ProductRepositorySoap;
import ru.geekbrains.summer.market.ws.soap.products.Product;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceSoap {
    private final ProductRepositorySoap productRepositorySoap;

    public Product getById(Long id){
        return productRepositorySoap.findById(id).map(functionEntityToSoap).get();
    }

    public List<Product> getAllProducts(){
        return productRepositorySoap.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public static final Function<ProductEntity, Product> functionEntityToSoap = productEntity -> {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setTitle(productEntity.getTitle());
        product.setPrice(productEntity.getPrice().intValue());
        product.setCategoryTitle(productEntity.getCategory().getTitle());
        return product;
    };

}
