package com.inditex.rest.controller;

import com.inditex.rest.dto.ItemPriceDTO;
import com.inditex.rest.dto.converter.ItemPriceDTOConverter;
import com.inditex.rest.exceptions.NoItemPriceFoundException;
import com.inditex.rest.modelo.ItemPrice;
import com.inditex.rest.services.ItemPriceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ItemPriceController {
    private final ItemPriceService service;
    private final ItemPriceDTOConverter converter;

    /**
     * Get all prices
     * @return 404 if not exist price, 200 if exist 1 or more
     */
    @ApiOperation(value="Get all prices")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK"),
            @ApiResponse(code=404, message="DAta Not Found"),
            @ApiResponse(code=500, message="Internal Server Error")
    })
    @GetMapping("/prices")
    public ResponseEntity<?> getAll(){

        List<ItemPrice> result =service.findAll();
        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            List<ItemPriceDTO> dtoList=result.stream().map(converter::converter).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    /**
     *
     * @param currentDate
     * @param productId
     * @param brandId
     * @return
     * @throws NoItemPriceFoundException
     */
    @ApiOperation(value="Get price by date apply, product id and brand id")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK"),
            @ApiResponse(code=404, message="DAta Not Found"),
            @ApiResponse(code=500, message="Internal Server Error")
    })
    @GetMapping("/price")
    @ResponseBody
    public ResponseEntity getPriceInfos(@ApiParam(value="Date price apply", required=true, type = "String",example = "2020-06-14 00:00:00") @RequestParam(required = true,value = "currentDate") final String currentDate,
                                        @ApiParam(value="Product id", required=true, type = "Long",example = "35455")@RequestParam(required = true,value = "productId") final Long productId,
                                        @ApiParam(value="Brand id", required=true, type = "Long",example = "1")@RequestParam(required = true,value = "brandId") final Long brandId) throws NoItemPriceFoundException{
        if(log.isDebugEnabled()){log.debug(String.format("Request received with params: currentDate: %s productId: %d brandId: %d", currentDate, productId, brandId));}
        ItemPrice  item=service.getItemPriceByCurrentDateProductIdBrandId(LocalDateTime.parse(currentDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), productId, brandId);

        return new ResponseEntity(converter.converter(item), HttpStatus.OK);
    }


}
