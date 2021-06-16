package com.inditex.rest.unit;

import com.inditex.rest.modelo.ItemPrice;
import com.inditex.rest.modelo.ItemPriceRepository;
import com.inditex.rest.services.ItemPriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemPriceServiceImplTest {


    private static final Long PRODUCT_ID = 35455L;
    private static final Long BRAND_ID = 1L;

    @Autowired
    private ItemPriceService service;


    @Test
    public void getItemPriceByCurrentDateProductIdBrandId() {
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 00, 00, 00);

        ItemPrice itemPrice = service.getItemPriceByCurrentDateProductIdBrandId(date, PRODUCT_ID, BRAND_ID);

        assertEquals(1L, itemPrice.getBrandId().longValue());
        assertEquals(35455L, itemPrice.getProductId().longValue());
    }

    @Test
    void findAll_shouldReturnAllItemPrices(){
        List<ItemPrice> itemPrices = service.findAll();
        assertNotNull(itemPrices);
        assertTrue(itemPrices.size()>0);
    }
}