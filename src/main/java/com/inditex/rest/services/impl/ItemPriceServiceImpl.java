package com.inditex.rest.services.impl;

import com.inditex.rest.modelo.ItemPrice;
import com.inditex.rest.exceptions.NoItemPriceFoundException;
import com.inditex.rest.modelo.ItemPriceRepository;
import com.inditex.rest.services.ItemPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class ItemPriceServiceImpl implements ItemPriceService {

    @Autowired
    private ItemPriceRepository repository;

    @Override
    public ItemPrice getItemPriceByCurrentDateProductIdBrandId(final LocalDateTime currentDate, final Long productId,final Long brandId) throws NoItemPriceFoundException  {
        if(log.isDebugEnabled()){log.debug(String.format("Service  getItemPriceByCurrentDateProductIdBrandId called with params: currentDate %s productId: %d brandId: %d", currentDate, productId, brandId));}

        return repository.findFirstByStartDateAndBrandIdAndProductIdOrderByPriorityDesc(currentDate,brandId,productId).orElseThrow(()->new NoItemPriceFoundException(currentDate,productId, brandId));
    }

    @Override
    public List<ItemPrice> findAll() {
        return repository.findAll();
    }


}
