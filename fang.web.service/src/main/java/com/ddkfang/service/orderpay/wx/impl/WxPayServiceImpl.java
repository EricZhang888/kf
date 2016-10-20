package com.ddkfang.service.orderpay.wx.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.ddkfang.constant.WxPayConstant;
import com.ddkfang.service.orderpay.wx.IWxPayService;
import com.ddkfang.util.verify.MD5;
import com.ddkfang.util.verify.XMLParser;
import com.tencent.wxpay.sdk.HttpUtil;
@Service
public class WxPayServiceImpl implements IWxPayService {

	public String genPayData(String orderId, String openid, int price, String ip) throws Exception {
		
		Map<String, Object> paraMap = new HashMap<String, Object>();  
        paraMap.put("appid", WxPayConstant.appID);  
        paraMap.put("attach", "1号房");  
        paraMap.put("body", "1号房");  
        paraMap.put("mch_id", WxPayConstant.mchId);  
        paraMap.put("nonce_str", createOnceStr());  
        paraMap.put("openid", openid);  
        paraMap.put("out_trade_no", orderId);
        paraMap.put("spbill_create_ip", ip);  
        paraMap.put("total_fee", price);  
        paraMap.put("trade_type", "JSAPI");  
        paraMap.put("notify_url", "http://1hf.bohosi.com/api/order/pay/wxPayBackenNotify");// 此路径是微信服务器调用支付结果通知路径  
        String sign = getSign(paraMap);  
        System.out.println("gen sign:" + sign);
        paraMap.put("sign", sign);
        String xml = arrayToXml(paraMap);  
        System.out.println("send xml:" + xml);
        String xmlStr = HttpUtil.sendPostUrl(WxPayConstant.orderUrl, xml, "UTF-8");
        System.out.println("response xml:" + xmlStr);
        String prepayId = "";
        if (xmlStr.indexOf("SUCCESS") != -1) {  
            Map<String, Object> map = XMLParser.getMapFromXML(xmlStr);  
            prepayId = (String) map.get("prepay_id").toString();  
        }
        
        
        Map<String, Object> payMap = new HashMap<String, Object>();  
        payMap.put("appId", WxPayConstant.appID);  
        payMap.put("timeStamp", createTimestamp());  
        payMap.put("nonceStr", createOnceStr());  
        payMap.put("signType", "MD5");  
        payMap.put("package", "prepay_id=" + prepayId);  
        String paySign = getSign(payMap);  
        payMap.put("pg", prepayId);  
        payMap.put("paySign", paySign);
        
        String payParam = "appId="+WxPayConstant.appID+"&timeStamp="+createTimestamp()+"&nonceStr="+createOnceStr()
        +"&signType=MD5"+"&pg="+prepayId+"&paySign="+paySign;


        return payParam;
	}
	
	public static String arrayToXml(Map<String, Object> arr) {
        String xml = "<xml>";
        Iterator<Entry<String, Object>> iter = arr.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Object> entry = iter.next();
            String key = entry.getKey();
            String val = entry.getValue().toString();
            if (key.equals("total_fee")) {
                xml += "<" + key + ">" + Integer.valueOf(val) + "</" + key + ">";
            } else
                xml += "<" + key + "><![CDATA[" + val + "]]></" + key + ">";
        }
        xml += "</xml>";
        return xml;
    }
	
	public static boolean IsNumeric(String str) {
        if (str.matches("\\d *")) {
            return true;
        } else {
            return false;
        }
    }
	
	private String getSign(Map<String,Object> map){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,Object> entry:map.entrySet()){
            if(entry.getValue()!=""){
                try {
					list.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue().toString(),"UTF-8") + "&");
				} catch (UnsupportedEncodingException e) {
					list.add(entry.getKey() + "=" + entry.getValue() + "&");
				}
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + WxPayConstant.appSecret;
        //Util.log("Sign Before MD5:" + result);
        System.out.println("gen sign string:" + result);
        result = MD5.MD5Encode(result).toUpperCase();
        //Util.log("Sign Result:" + result);
        return result;
    }
	
	private String createOnceStr() {  
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
        String res = "";  
        for (int i = 0; i < 16; i++) {  
            Random rd = new Random();  
            res += chars.charAt(rd.nextInt(chars.length() - 1));  
        }  
        return res;  
	}

	public String genPayToken(String code) throws Exception {
		String url = WxPayConstant.authUrl.replace("code=CODE", "code="+code);
		String token = HttpUtil.sendPostUrl(url, "", "UTF-8");
		return token;
	}
	
	private String createTimestamp() {  
        return Long.toString(System.currentTimeMillis() / 1000);  
    }
	
}
