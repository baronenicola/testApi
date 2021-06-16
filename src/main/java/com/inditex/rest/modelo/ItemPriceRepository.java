package com.inditex.rest.modelo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ItemPriceRepository extends JpaRepository<ItemPrice, Long> {

    Optional<ItemPrice> findFirstByStartDateAndBrandIdAndProductIdOrderByPriorityDesc(LocalDateTime currentDateStart, Long brandId, Long productId);
}


