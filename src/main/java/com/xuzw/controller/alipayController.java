package com.xuzw.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.alipay.config.AlipayConfig;
import com.alipay.config.AlipayConfig;
import com.alipay.util.logFile;
import com.xuzw.dao.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
public class alipayController {

    @Autowired
    private TestMapper testMapper;

    @RequestMapping("/index")
    public String test(){
        return "index";
    }

    @RequestMapping("/testMapper")
    public String testMapper(){
        Map<String, Object> map = testMapper.testSelect();
        System.out.println("================"+map);
        return map.toString();
    }

    @RequestMapping("/wappay/pay")
    public String pay(HttpServletRequest request) {
        // 商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("WIDout_trade_no");
        // 订单名称，必填
        String subject = request.getParameter("WIDsubject");
        System.out.println("subject"+subject);
        // 付款金额，必填
        String total_amount=request.getParameter("WIDtotal_amount");
        // 商品描述，可空
        String body = request.getParameter("WIDbody");
        // 超时时间 可空
        String timeout_express="2m";
        // 销售产品码 必填
        String product_code="QUICK_WAP_WAY";
        /**********************/
        // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
        //调用RSA签名方式
        AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
        AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();

        // 封装请求支付信息
        AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
        model.setOutTradeNo(out_trade_no);
        model.setSubject(subject);
        model.setTotalAmount(total_amount);
        model.setBody(body);
        model.setTimeoutExpress(timeout_express);
        model.setProductCode(product_code);
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl(AlipayConfig.notify_url);
        // 设置同步地址
        alipay_request.setReturnUrl(AlipayConfig.return_url);

        // form表单生产
        String form = "";
        try {
            // 调用SDK生成表单
            AlipayTradeWapPayResponse alipayTradeWapPayResponse = client.pageExecute(alipay_request);
            form = alipayTradeWapPayResponse.getBody();
            System.out.println(form);
            /*response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
            response.getWriter().write(form);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();*/
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //logFile.logResult(form);
            return form;
        }
    }

    @RequestMapping("/wappay/return")
    public String returnUrlCall(HttpServletRequest request){
        //https://www.baidu.com/?charset=UTF-8&out_trade_no=20181012103031872&method=alipay.trade.wap.pay.return&total_amount=0.01&sign=cgqwgLlt33xar4E%2FlTItNfYCBtYPYz4Gg1etzrwpRicCc9Wd2tw3GJTFHMvZiNeY8%2BtI03%2BSDCi2tXmeQjUhWgwck7ONVOfM5GhGyIUcQM3kzyyNc94Rj9cY0N0Zm4fyaXDYSj1d4xhyLzwDX63fI4rD2GZKBHf4Iicanqi22fjq1UtgKvKz8DMeLPir%2FwymxdL63Itpe%2FESK1wninGoX8Qzl8U9iALKqBwfnHkVPeuEbWY96TuBufWdG5cdgcn0OTexMh7edA0a7V3BwC6vi7v9LCk%2B72qddhBhfBMv000ynda8ZGMcwsYf%2Bm3r8OvfrKfovbYy77AwJj3LT4fqJg%3D%3D&trade_no=2018101221001004390501327760&auth_app_id=2016092100559272&version=1.0&app_id=2016092100559272&sign_type=RSA2&seller_id=2088102176555765&timestamp=2018-10-12+10%3A30%3A42
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            valueStr = valueStr;
            params.put(name, valueStr);
        }

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号

        String out_trade_no = request.getParameter("out_trade_no");

        //支付宝交易号

        String trade_no = request.getParameter("trade_no");

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
        //计算得出通知验证结果
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean verify_result = false;
        try {
            verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, "RSA2");
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        if(verify_result){//验证成功
            //////////////////////////////////////////////////////////////////////////////////////////
            //请在这里加上商户的业务逻辑程序代码
            //该页面可做页面美工编辑
//            out.clear();
//            out.println("验证成功<br />");
            //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

            //////////////////////////////////////////////////////////////////////////////////////////
        }else{
            //该页面可做页面美工编辑
//            out.clear();
//            out.println("验证失败");
        }

        return "";
    }


}
