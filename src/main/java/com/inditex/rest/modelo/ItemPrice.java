package com.inditex.rest.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "ITEM_PRICE")
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class ItemPrice implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "PRICE_LIST")
        private Long priceList;

//        @ManyToOne
        @Column(name="BRAND_ID")
        private Long brandId;

        @Column(name = "START_DATE")
        private LocalDateTime startDate;

        @Column(name = "END_DATE")
        private LocalDateTime endDate;

        @Column(name = "PRODUCT_ID")
        private Long productId;

        @Column(name = "PRIORITY")
        private Long priority;

        @Column(name = "PRICE")
        private Double price;

        @Column(name = "CURR")
        private String currency;
}
