package com.my.blog.website.freeBill;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FreeBillStepDetail {

    private BigDecimal stepReducePrice;

    private Integer stepState;

}
