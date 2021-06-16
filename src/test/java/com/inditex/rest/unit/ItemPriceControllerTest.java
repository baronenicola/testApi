package com.inditex.rest.unit;

import com.inditex.rest.controller.ItemPriceController;
import com.inditex.rest.dto.ItemPriceDTO;
import com.inditex.rest.exceptions.NoItemPriceFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemPriceControllerTest {


	@Autowired
	private ItemPriceController controller;
	private static final Long PRODUCT_ID = 35455L;
	private static final Long BRAND_ID = 1L;


	@Test(expected = NoItemPriceFoundException.class)
	public void whenPriceDoesNotExist_Should_Throw_NoItemPriceFoundException() {
	 controller.getPriceInfos("2020-06-14 10:00:00", PRODUCT_ID, BRAND_ID);
	}

	@Test
	public void shouldReturnPriceWhenExist() {
		ResponseEntity<ItemPriceDTO> responseEntity = controller.getPriceInfos("2020-06-14 15:00:00", PRODUCT_ID, BRAND_ID);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(1L, responseEntity.getBody().getBrandId().longValue());
	}

	//----------------- More tests should be implemented -----------------------------------

}
