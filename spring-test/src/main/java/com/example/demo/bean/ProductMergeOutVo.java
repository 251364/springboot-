package com.example.demo.bean;

import lombok.Data;

import java.util.List;

/**
 : 合并出库vo
 
 */
@Data

public class ProductMergeOutVo {

    private List<Long> outOrderIds;// 出库订单id
 
    private Long productInfoId;//成品信息id

    private List<ProductOutDemand>  productOutDemands;//需求单
 
    private List<ProductOutStorage>  productOutStorages;//批次信息
  
    private List<ProductOutPackage>  productOutPackages;//包装信息
}
