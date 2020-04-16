package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiRequestVo {
    /**
     * @description 要请求的API方法名称
     */
    @NotBlank(message = "method不能为空")
    private String method;
    /**
     * @description API请求的签名
     */
    @NotBlank(message = "sign不能为空")
    private String sign;
    /**
     * @description 1:RSA 目前仅支持RSA
     */
    @NotNull(message = "signType不能为空")
    private Integer signType;
    /**
     * @description 请求的业务数据，此处数据格式为Json封装。具体参数说明见详细接口
     */
    @NotBlank(message = "bizParams不能为空")
    private String bizParams;

    @NotBlank(message = "appId不能为空")
    private String appId;

    /**
     * @description 13位时间戳，精确到秒
     */
    @NotBlank(message = "timestamp不能为空")
    private String timestamp;
}
