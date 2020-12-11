package com.example.demo.bean;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/*成品出库需求单*/

@Builder//注：必须加上全部构造方法才不会报错
@Accessors(chain = true)//setter返回的this而不是void
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOutDemand  {
    

    private Long demandId;//出库需求单id
    private Long outOrderId;//出库订单id
    private Integer sortNo;//排序号
    private Long productInfoId;//成品信息id
    private String productNumber;//成品编号
    private String productName;//成品名称
    private String packingSpecification;//包装规格
    private String approvalNumber;//批准文号 
    private String demandCount;//需求总量
    private Integer actualNumber;//实发件数
    private String actualCount;//实发量
    private String storageUnit;//基本计量单位
    private Integer isTiter;//是否需要效价换算(0--否，1--是)
    private String batchNumber;// 批号
    private Long storageId;//成品批次id
    private List<Long> storageIds;//批次id集合
}
