package com.inditex.rest.dto.converter;

import com.inditex.rest.modelo.ItemPrice;
import com.inditex.rest.dto.ItemPriceDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemPriceDTOConverter {


    private final ModelMapper modelMapper;


    public ItemPriceDTO converter(ItemPrice itemPrice) {
        return modelMapper.map(itemPrice, ItemPriceDTO.class);
    }

}
