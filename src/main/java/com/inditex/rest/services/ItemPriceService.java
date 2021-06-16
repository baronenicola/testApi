package com.inditex.rest.services;

import com.inditex.rest.exceptions.NoItemPriceFoundException;
import com.inditex.rest.modelo.ItemPrice;

import java.time.LocalDateTime;
import java.util.List;

public interface ItemPriceService {

    ItemPrice getItemPriceByCurrentDateProductIdBrandId(LocalDateTime currentDate, Long productId, Long brandId) throws NoItemPriceFoundException;

    List<ItemPrice> findAll();

}
