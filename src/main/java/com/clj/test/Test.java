package com.clj.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import com.clj.model.Position;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	
	public static void main(String[] args) throws Exception {
		String add = getAdd("113.25", "23.1167");
		JSONObject jsonObject = JSONObject.fromObject(add);
		JSONArray jsonArray = JSONArray.fromObject(jsonObject.getString("addrList"));
		JSONObject j_2 = JSONObject.fromObject(jsonArray.get(0));
		String allAdd = j_2.getString("admName");
		String addr = j_2.getString("addr");
		System.out.println(allAdd);
		System.out.println(addr);
		String arr[] = allAdd.split(",");
		System.out.println("省："+arr[0]+"\n市："+arr[1]+"\n区："+arr[2]);
	}
	
	public static Position getAddressByIP1(String strIP) throws IOException {
	    URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + strIP);
	    URLConnection conn = url.openConnection();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	    String line = null;
	    StringBuilder result = new StringBuilder();
	    while ((line = reader.readLine()) != null) {
	        result.append(line);
	    }
	    reader.close();
	    String res = result.toString();
	    Gson gson = new Gson();
	    HashMap<String, Object> kv = gson.fromJson(res, HashMap.class);
	    LinkedTreeMap map = (LinkedTreeMap) kv.get("data");
	    Position position = new Position();

	    if ((map != null) && (!map.isEmpty())) {
	    	position.setCountry((String) map.get("country"));
	    	position.setProvince((String) map.get("region"));
	    	position.setCity((String) map.get("city"));
	    }
	    return position;
	}
	public static String getAdd(String log, String lat ){
		//lat 小  log  大
		//参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)
		String urlString = "http://gc.ditu.aliyun.com/regeocoding?l="+lat+","+log+"&type=010";
		String res = "";   
        try {   
            URL url = new URL(urlString);  
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();  
            conn.setDoOutput(true);  
            conn.setRequestMethod("POST");  
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));  
            String line;  
           while ((line = in.readLine()) != null) {  
               res += line+"\n";  
         }  
            in.close();  
        } catch (Exception e) {  
            System.out.println("error in wapaction,and e is " + e.getMessage());  
        } 
        System.out.println(res);
        return res;  
	}

}
