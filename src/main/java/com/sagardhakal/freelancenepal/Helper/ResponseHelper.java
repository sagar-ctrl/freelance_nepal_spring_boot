package com.sagardhakal.freelancenepal.Helper;


import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseHelper {
    public static ResponseEntity<HashMap<String,Object>>getResponse(Integer statusCode,String message,Object data){
        HashMap<String,Object>response=new HashMap<>();
        response.put("status",statusCode);
        response.put("message",message);
        response.put("data",data);
        return  ResponseEntity.ok(response);
    }
    public static ResponseEntity<HashMap<String,Object>>getResponse(Integer statusCode,String message){
        HashMap<String,Object>response=new HashMap<>();
        response.put("status",statusCode);
        response.put("message",message);
        response.put("data",null);
        return  ResponseEntity.ok(response);
    }

    public static ResponseEntity<HashMap<String,Object>>getResponse(Object data){
        HashMap<String,Object>response=new HashMap<>();
        response.put("status",200);
        response.put("message","Success");
        response.put("data",data);
        return  ResponseEntity.ok(response);
    }
}
