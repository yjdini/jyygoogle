package com.jyy.google.service;

import com.ini.common.utils.HttpUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GoogleMapService {

    public List queryPlaces(String input, String language) {
        String urlTemp = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=%s&language=%s&key=AIzaSyCODLiMExmqjED0knARqsa1GlSnXG0JXZE";
        String url = String.format(urlTemp, input, language);
        Map<Object, Object> resp = HttpUtil.doGet(url);
        if (resp != null && "OK".equals(resp.get("status"))) {
            return (List) resp.get("results");
        } else {
            return new ArrayList();
        }
    }

    // origin格式为lat,lon
    public int getDistance(String origin, String destination) {
        return 0;
    }

    public static void main(String[] args) {
    }

}
