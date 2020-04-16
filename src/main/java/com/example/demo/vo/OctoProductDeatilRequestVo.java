package com.example.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Project: octopus
 * @Description:
 * @Author: Steven
 * @Date: 2020/4/15 10:28 上午
 **/
@Data
public class OctoProductDeatilRequestVo {
    @NotNull(message = "productId不能为空")
    private Integer productId;
}
