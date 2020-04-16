package com.example.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Project: octopus
 * @Description:
 * @Author: Steven
 * @Date: 2020/1/16 2:41 下午
 **/
@Data
public class QueryOperatorRegionalRequestVo {
    @NotBlank(message = "手机号不能为空")
    private String phone;

    /**
     * 充值面值
     */
    private String faceValue;
}
