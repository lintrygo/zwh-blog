package com.my.blog.website.freeBill;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ShareFreeBillInfo {

    //private Integer actNum;

    private BigDecimal reducedPrice;

    private BigDecimal productInstalmentAmount;

    private BigDecimal billInstalmentAmount;

    private BigDecimal totalBillAmount;

}


