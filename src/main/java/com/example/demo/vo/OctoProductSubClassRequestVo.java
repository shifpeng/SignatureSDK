package com.example.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Project: octopus
 * @Description:
 * @Author: Steven
 * @Date: 2020/4/14 7:50 下午
 **/
@Data
public class OctoProductSubClassRequestVo {
    @NotNull(message = "classId不能为空")
    private Integer classId;
}
