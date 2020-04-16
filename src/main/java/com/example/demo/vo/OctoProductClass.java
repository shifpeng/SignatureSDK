package com.example.demo.vo;

import lombok.Data;

/**
 * @Project: octopus
 * @Description:
 * @Author: Steven
 * @Date: 2020/1/16 5:10 下午
 **/
@Data
public class OctoProductClass {
    /**
     * 商品大类ID octo_product_category
     */
    private Integer classId;

    //产品名称
    private String productName;

}
