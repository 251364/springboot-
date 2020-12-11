package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Date;
import java.util.List;

/* 成品出库订单*/

@Builder//注：必须加上全部构造方法才不会报错
@Accessors(chain = true)//setter返回的this而不是void
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOutOrder  {
    
    private Long outOrderId;// 出库订单id
    private String outOrderNo; //订单编号
    private String saleOrderNo;//销售订单编号
    private Long customerId;//客户id
    private String customerNo;//客户编号
    private String customerName; //客户名称
    private Long orderType;// 订单类型
    private String productName;//成品信息
    private Long applyPersonId;//制单人id
    private String applyPerson;//制单人
    private Date applyTime;// 制单时间
    private Date completeTime;//完成时间
    private Integer state;//状态(0--待出库，1--已出库，2--草稿，3--无效，4--新增，5--待审核)
    private Integer originalState;//原状态(0--待出库，1--已出库，2--草稿，3--无效，4--新增，5--待审核)
    private Integer printCount;//导出次数
    private Long receiveDepartmentId;//领料部门id
    private String receiveDepartmentNo;//领料部门编号
    private String receiveDepartmentName;//领料部门名称
    private Long transportSupplier;//运输供应商
    private String remark;//备注
    private Date completeTimeStart;//出库日期（查询用-开始）
    private Date completeTimeEnd;//出库日期（查询用-结束）
    private List<ProductOutDemand>  productOutDemands;//需求单
    private List<ProductOutStorage>  productOutStorages; // 批次信息
    private List<ProductOutPackage>  productOutPackages;//包装信息

}
