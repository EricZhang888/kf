package com.ddkfang.util.wxpay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import com.ddkfang.constant.WxPayConstant;
import com.ddkfang.util.verify.MD5;

public class WxPayUtil
{

	public static String createTimestamp()
	{
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	public static String createOnceStr()
	{
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String res = "";
		for (int i = 0; i < 16; i++)
		{
			Random rd = new Random();
			res += chars.charAt(rd.nextInt(chars.length() - 1));
		}
		return res;
	}

	public static String getSign(Map<String, Object> map)
	{
		ArrayList<String> list = new ArrayList<String>();
		for (Map.Entry<String, Object> entry : map.entrySet())
		{
			if (entry.getValue() != "")
			{
				list.add(entry.getKey() + "=" + entry.getValue() + "&");
			}
		}
		int size = list.size();
		String[] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++)
		{
			sb.append(arrayToSort[i]);
		}
		String result = sb.toString();
		result += "key=" + WxPayConstant.appkey;
		//Util.log("Sign Before MD5:" + result);
		result = MD5.MD5Encode(result).toUpperCase();
		//Util.log("Sign Result:" + result);
		return result;
	}

	public static String mapToXml(Map<String, Object> arr)
	{
		String xml = "<xml>";
		Iterator<Entry<String, Object>> iter = arr.entrySet().iterator();
		while (iter.hasNext())
		{
			Entry<String, Object> entry = iter.next();
			String key = entry.getKey();
			String val = entry.getValue().toString();
			xml += "<" + key + ">" + val + "</" + key + ">";
		}
		xml += "</xml>";
		return xml;
	}
}
