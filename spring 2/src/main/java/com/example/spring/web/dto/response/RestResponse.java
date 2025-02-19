package com.example.spring.web.dto.response;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class RestResponse {
    public static Map<String,Object> response(HttpStatus status,Object data,String type) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("status",status);
        map.put("results",data);
        map.put("type",type);
        return map;
    }

    public static Map<String,Object> responsePaginate(HttpStatus status, String type , Object pages, Integer currentPage,
                                                      Integer totalPages, Integer totalItems, Boolean first, Boolean last) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("status",status);
        map.put("type",type);
        map.put("pages",pages);
        map.put("currentPage",currentPage);
        map.put("totalPages",totalPages);
        map.put("totalItems",totalItems);
        map.put("first",first);
        map.put("last",last);
        return map;
    }

}
