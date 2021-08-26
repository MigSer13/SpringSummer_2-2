package ru.geekbrains.summer.market.ws.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.ws.entities.ProductEntity;
import ru.geekbrains.summer.market.ws.repositories.ProductRepository;
import ru.geekbrains.summer.market.ws.soap.products.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getById(Long id){
        return productRepository.findById(id).map(functionEntityToSoap).get();
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
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
