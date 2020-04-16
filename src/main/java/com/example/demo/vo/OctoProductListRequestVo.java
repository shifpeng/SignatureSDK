package com.example.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Project: octopus
 * @Description:
 * @Author: Steven
 * @Date: 2020/4/14 10:17 下午
 **/
@Data
public class OctoProductListRequestVo{
    @NotNull(message = "")
    private Integer subClassId;
}
