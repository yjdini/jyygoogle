package com.jyy.google.controller;

import com.ini.common.utils.MapUtil;
import com.ini.common.utils.RespJsonUtil;
import com.jyy.google.service.GoogleMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class AddressController {
    @Autowired
    private GoogleMapService googleMapService;

    @PostMapping(path = "/api/address/query")
    public Map queryAddress(@RequestBody Map<String, Object> body) {
        String input = (String) body.get("input");
        String language = (String) body.getOrDefault("language", "zh");

        List resultList = googleMapService.queryPlaces(input, language);
        return RespJsonUtil.success(MapUtil.getWithKeyValues("results", resultList));
    }
}
