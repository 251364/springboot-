package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
  成品包装
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true )
public class ProductOutPackage  {
  

    private Long outPackageId;//出库包装id
    private Long outOrderId;// 出库订单id
    private Long packageId;//成品包装id
    private Long storageId;// 成品批次id
    private String batchNumber;// 批号
    private String positionCode;//库位编号
    private String trayCode;//托盘编号
    private String packageInventorynum;//包装流水号
    private String weightCount;// 重量/数量
    private String storageUnit;//基本计量单位
    private Integer source;//来源
    private String remark;//备注

	/*
	 * public ProductOutPackage setInfo(FinishedProductAssignmentCode
	 * productPackage) { ProductOutPackage outPackage = this; this.packageId =
	 * productPackage.getAssignmentId(); this.batchNumber =
	 * productPackage.getBatchNumber(); this.positionCode =
	 * productPackage.getStackNumber(); this.trayCode =
	 * productPackage.getTrayNumber(); this.packageInventorynum =
	 * productPackage.getJournalNumber(); this.weightCount =
	 * productPackage.getActualWeightNumber(); this.storageUnit =
	 * productPackage.getStorageUnitStr(); this.source = productPackage.getSource();
	 * return outPackage; }
	 */
}
