package com.inditex.rest.unit;


import com.inditex.rest.modelo.ItemPrice;
import com.inditex.rest.modelo.ItemPriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemPriceRepositoryTest {

    @Autowired
    ItemPriceRepository repository;

    @Test
    void shouldReturnAllItemPrices(){
        List<ItemPrice> itemPrices = repository.findAll();
        assertNotNull(itemPrices);
        assertTrue(itemPrices.size()>0);
    }

}

