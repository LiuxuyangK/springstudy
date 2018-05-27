package com.study.lxy.java8.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Apple {
    private Long id;
    private String color;
    private Integer weight;
    private BigDecimal price;
}
