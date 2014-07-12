package br.com.testeproject.util;

import java.util.Map;

import com.google.gson.Gson;

public class JSONUtil {

    public static String mapToJSON( Map<String, Object> map ){
        Gson gson = new Gson();	
        String json = null;
        if( map != null ){
                json = gson.toJson( map );
        }		
        return json;
    }

    public static Object jsonToObject(String json, Class<?> clazz){
        return new Gson().fromJson(json, clazz);
    }
	
}
