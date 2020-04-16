package com.example.demo.vo;

import lombok.Data;

import java.util.List;

/**
 * @Project: octopus
 * @Description:
 * @Author: Steven
 * @Date: 2020/4/14 4:06 下午
 **/
@Data
public class OctoProductCategoryResponseVo {

    private List<OctoProductCategoryVo> categories;
}
