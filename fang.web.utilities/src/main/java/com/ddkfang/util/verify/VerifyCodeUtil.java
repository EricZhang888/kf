package com.ddkfang.util.verify;

import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class VerifyCodeUtil {

	final static String url = "http://gw.api.taobao.com/router/rest";
	final static String appkey = "23466483";
	final static String secret = "3f5f55f698111f5ce29740410ea41f68";
	
	
	public static boolean sendVerifyCode(String mobile, String code, String bizType) throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend(mobile);
		req.setSmsType("normal");
		req.setSmsFreeSignName("1号房");
		req.setSmsParamString("{\"code\":\" " + code +  " \",\"product\":\"1号房\"}");
		req.setRecNum(mobile);
		req.setSmsTemplateCode(bizType);
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		
		System.out.println(rsp.getBody());
		//发送成功
		JSONObject object = JSONObject.parseObject(rsp.getBody());
		if(object.containsKey("error_response")) {
			return false;
		}
		return true;
	}
	
//	public static boolean checkVerifyCode(String code) {
//		if (!code.equals("123456")) {
//			return false;
//		}
//		return true;
//	}
	public static String createSmsCode(){
		return createSmsCode(true, 6);
	}
	
	public static String getSmsTemp(int type) {
		if (type == 1) {
			return SmsTypeEnum.login.getTempName();
		} else if(type == 2) {
			return SmsTypeEnum.changePwd.getTempName();
		} else {
			return SmsTypeEnum.login.getTempName();
		}
	}
	
	public static String createSmsCode(boolean numberFlag, int length){
		String retStr = "";
		String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);
			return retStr;
		}
	
	public static void main(String[] args) throws ApiException {
		System.out.println(createSmsCode(true, 6));
		//System.out.println(sendVerifyCode("13761170304", "135466", SmsTypeEnum.changePwd.getTempName()));
	}
}
