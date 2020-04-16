package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.utils.EntityUtils;
import com.example.demo.utils.HttpUtils;
import com.example.demo.utils.RSACoderUtil;
import com.example.demo.vo.ApiRequestVo;
import com.example.demo.vo.OctoProductDeatilRequestVo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

/**
 * 回调接口 机构调用贷超 demo
 */
@Controller
@RequestMapping("/test")
public class LoanMarketAction extends HttpServlet {

    //请求method
    private static final String QUERY_OPERATOR_REGIONAL = "QUERY_OPERATOR_REGIONAL";

    private static final String QUERY_PRODUCT_CATEGORY = "QUERY_PRODUCT_CATEGORY";

    private static final String QUERY_PRODUCT_CLASS = "QUERY_PRODUCT_CLASS";

    private static final String QUERY_PRODUCT_SUB_CLASS = "QUERY_PRODUCT_SUB_CLASS";

    private static final String QUERY_PRODUCT_LIST = "QUERY_PRODUCT_LIST";
    private static final String QUERY_PRODUCT_DETAIL = "QUERY_PRODUCT_DETAIL";
    //贷超提供给机构的appid
    private static final String AppID = "yJJaEoCD";
    //机构的私钥
    private static final String priKey = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAhlKcAlO6A1NoVjuZL9qVJ/kS8Orz\n" +
            "wyUco78F8zAXb334jJnA+lAp9hB+Kidnr5tWYuyVOBwwN0IpVn+cNO1uqQIDAQABAkAlp5rcfCQ1\n" +
            "MniZU/PJmnkdz5EjwHm9RvYUYUSFvAGV20xzS/zlE1yoLZO83IHmV9zW3/XMn53DsOQgXMKRU1cR\n" +
            "AiEA4rDRYF8eLHfwf4W9PDwcFfooKoqyUppPGl1bEBDLsosCIQCXsIZTjIhqBN2rOclUfVaE7XdE\n" +
            "bwYstqm2DiSsfsoOGwIgRftgJ+g1YHUGgde/u8CyyvYXQErhEi8hDHqVijglKlECIGxpbmeSHgDf\n" +
            "v2nb4AdxmP9iFIalbt1QI5UJIK7j4xcXAiAU7zwqzg3T6KvynnSfdOVcp5tyYvgqFS7nm+1FeC7A\n" +
            "8Q==\n";

    private static final String URL = "http://localhost:10114/api/v1";

    @RequestMapping(value = "/dopost", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public void doPost() {
        //归属地
//        QueryOperatorRegionalRequestVo queryOperatorRegionalRequestVo = new QueryOperatorRegionalRequestVo();
//        queryOperatorRegionalRequestVo.setPhone("18649237364");
//        queryOperatorRegionalRequestVo.setFaceValue("");

//        //商品大类
//        OctoProductCategoryRequestVo octoProductCategoryRequestVo = new OctoProductCategoryRequestVo();
////二级分类
//
//
//        OctoProductClassRequestVo octoProductClassRequestVo = new OctoProductClassRequestVo();
//        octoProductClassRequestVo.setCategoryId(1);

        //三级分类
//        OctoProductSubClassRequestVo octoProductSubClassRequestVo = new OctoProductSubClassRequestVo();
//        octoProductSubClassRequestVo.setClassId(1);

//列表
//        OctoProductListRequestVo octoProductListRequestVo = new OctoProductListRequestVo();
//        octoProductListRequestVo.setSubClassId(1);
//详情
        OctoProductDeatilRequestVo octoProductDeatilRequestVo = new OctoProductDeatilRequestVo();
        octoProductDeatilRequestVo.setProductId(5);


        ApiRequestVo apiRequestVo = new ApiRequestVo();
        apiRequestVo.setMethod(QUERY_PRODUCT_DETAIL);
        apiRequestVo.setSign("");
        apiRequestVo.setSignType(1);
        apiRequestVo.setBizParams(JSON.toJSONString(octoProductDeatilRequestVo));
        apiRequestVo.setAppId(AppID);
        apiRequestVo.setTimestamp(String.valueOf(System.currentTimeMillis()));

        Map<String, String> map = EntityUtils.entityToMap(apiRequestVo);
        String sign = null;
        try {
            sign = RSACoderUtil.getSign(map, priKey);
            apiRequestVo.setSign(sign);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            String response = HttpUtils.doPostByJson(URL, headers, apiRequestVo);
            System.out.printf(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        LoanMarketAction loanMarketAction = new LoanMarketAction();
        loanMarketAction.doPost();
    }
}
