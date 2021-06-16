package com.inditex.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoItemPriceFoundException extends RuntimeException{

    public NoItemPriceFoundException(LocalDateTime applicationDate, Long productId, Long brandId) {
        super(String.format("No Data found : %s productId: %d brandId: %d", applicationDate, productId, brandId));
    }

}
