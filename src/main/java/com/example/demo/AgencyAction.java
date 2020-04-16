package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.demo.utils.RSACoderUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 机构接受贷超的请求并做验签 demo
 * 需要提供公钥给到贷超
 */

@Controller
@RequestMapping("/test1")
public class AgencyAction {
    //公钥
    private static final String pubKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJl7oPHAGoUHxaR2BntyvYB7Ab4Zw1ZX0fkpH1UPKSxRHkBlruwtMSizYM5ASj/APcvY/maMr9Yqz0Sb2rIEd7sCAwEAAQ==";

    /**
     * 机构验签方法
     *
     * @throws \Exception
     */
    @RequestMapping(value = "/verify", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public void verify() {
        String jsonString = "{\"bizParams\":\"{\\\"md5\\\":\\\"95687230235dcc3c79b9f5fcec54059b\\\",\\\"name\\\":\\\"石明栋\\\"}\",\"sign\":\"DjgsDOSjLkx9kBI294LyredcH9q07MxhUAHWJtoI3OT5p9hjzhJQEs0vVMaluN+wNDVblYSz6l0HyrdEeVk54A==\",\"timestamp\":\"1562239083856\"}";


        Map<String, String> signMap = JSON.parseObject(jsonString, new TypeReference<Map<String, String>>() {
        });
        String sign = signMap.get("sign");
        signMap.remove("sign");
        boolean verifyRes = RSACoderUtil.verify(signMap, pubKey, sign);
        System.out.printf(verifyRes ? "通过" : "不通过");
    }

    public static void main(String[] args) {
        AgencyAction agencyAction = new AgencyAction();
        agencyAction.verify();
    }


}
