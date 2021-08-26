package ru.geekbrains.summer.market.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.summer.market.ws.entities.ProductEntity;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findById(Long id);
}
