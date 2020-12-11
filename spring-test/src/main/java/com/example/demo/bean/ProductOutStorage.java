package com.example.demo.bean;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/*
  成品出库批次信息
 
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ProductOutStorage  {
    

    private Long outStorageId;//出库批次id
    private Long outOrderId;//出库订单id
    private Long storageId;//成品批次id
    private String productNumber;//成品编号
    private String productName;//成品名称
    private String batchNumber;//批号
    private String warehouseName;//仓库名称
    private String storageCount;//库存量
    private String storageUnit;//基本计量单位
    private String suggestCount;//建议发放量
    private Integer actualNumber;//实发件数
    private String actualCount;//实发量
    private String convertCount;//换算值
    private Date manufactureDate;//生产日期
    private Date validityDate;//有效期
    private Integer remark;//备注(0--非推荐批次，1--推荐批次)
	/*
	 * public ProductOutStorage setInfo(FinishedProductStorage storage) {
	 * SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	 * ProductOutStorage outStorage = this; this.storageId = storage.getStorageId();
	 * this.productNumber = storage.getFinishedProductCode(); this.productName =
	 * storage.getProductName(); this.batchNumber = storage.getBatchNumber();
	 * this.warehouseName = storage.getWarehouseName(); this.storageCount =
	 * storage.getGrossFirst(); this.storageUnit = storage.getStorageUnitStr(); try
	 * { this.manufactureDate = format.parse(storage.getManufactureDate()); } catch
	 * (ParseException e) { e.printStackTrace(); } this.validityDate =
	 * storage.getRetestDate(); return outStorage; }
	 */
	/*
	 * @Override public boolean equals(Object o) { if(this == o) { return true; } if
	 * (o == null || getClass() != o.getClass()) { return false; } ProductOutStorage
	 * productOutStorage = (ProductOutStorage) o; return Objects.equals(storageId,
	 * productOutStorage.storageId) && Objects.equals(batchNumber,
	 * productOutStorage.batchNumber) && Objects.equals(outOrderId,
	 * productOutStorage.outOrderId); }
	 */
}
