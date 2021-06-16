package com.inditex.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ItemPriceDTO implements Serializable {


	@JsonProperty("product-id")
	private Long productId;

	@JsonProperty("brand-id")
	private Long brandId;

	@JsonProperty("price-list")
	private Integer priceList;


	@JsonProperty("start-date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Madrid")
	private LocalDateTime startDate;

	@JsonProperty("end-date")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Europe/Madrid")
	private LocalDateTime endDate;

	@JsonProperty("price")
	private Double price;

}
