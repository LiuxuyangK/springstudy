package com.study.lxy.java8.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Data
@Builder
@AllArgsConstructor
public class Apple {
    private Long id;
    private String color;
    private Integer weight;
    private BigDecimal price;
}
