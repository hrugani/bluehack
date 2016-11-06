/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueHack;

import ca.weblite.codename1.json.JSONObject;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;


import com.blueHack.entities.Parking;
import com.blueHack.entities.User;
import com.codename1.util.StringUtil;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * Singleton pattern 
 * @author hrugani
 */
public class Util {
    
    // Singleton Util
    
    final static public String GEO_HOME = "-23.5362310,-46.6849740";
    final static public String GEO_WORK = "-23.5710660,-46.6393240";
    final static public String GEO_7COMM = "-23.5452890,-46.6369840";
    final static public String GEO_IBM = "-23.5806370,-46.6501660";
    final public String[] GEO_LIST = new String[]{
        GEO_HOME,
        GEO_WORK,
        GEO_7COMM,
        GEO_IBM,
        GEO_HOME,
        GEO_WORK,
        GEO_7COMM,
        GEO_IBM,
        GEO_7COMM,
        GEO_IBM
    };
    
    
    private static final Util u = new Util();

    private Util() {
    }
   
    /**
     *
     * @return
     */
    public static Util getInstance() {
        return u;
    }
    
    
    private User user;
    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return this.user;
    }
    
    
    
    final String BASE_URL =
      "https://b8a135a2-8d08-47f4-9427-1f1d561f44e4-bluemix.cloudant.com/parking/_design/parking/_geo/newGeoIndex";

    final String BASE_URL_NEW = "https://b8a135a2-8d08-47f4-9427-1f1d561f44e4-bluemix:6fb0614450820a29ad42f03a3fe3c54b2ec3e6a6b8b0dac8a0515dd714fdd879@b8a135a2-8d08-47f4-9427-1f1d561f44e4-bluemix.cloudant.com/parking/_design/parking/_geo/newGeoIndex";
  // ?g=POINT(-71.0537124 42.3681995)&nearest=true&limit=5&radius=100&include_docs=true  
    public ArrayList<Parking> getParkingList(
            String geoLocation,
            String radius) {

        // Cloudant inverts latitude/longitude  order
        List<String> ll = StringUtil.tokenize(geoLocation, ",");
        String longitude = ll.get(1);
        String latitude  = ll.get(0);
        
        //String longitude = geoLocation.split(",")[1];
        //String latitude  = geoLocation.split(",")[0];
        
        ConnectionRequest r = new ConnectionRequest();
        
        r.setPost(false);
  // ?g=POINT(-71.0537124 42.3681995)&nearest=true&limit=5&radius=100&include_docs=true  
        String url = 
         BASE_URL_NEW
            + "?g=POINT("
            + longitude + " " + latitude + ")"
            + "&nearest=true" 
            + "&radius=" + radius
            + "&include_docs=true";        
        r.setUrl(url);
        
        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(r);
        
        ByteArrayInputStream bais = 
            new ByteArrayInputStream(r.getResponseData());
        InputStreamReader reader = new InputStreamReader(bais);
        
        ArrayList<Parking> resp = new ArrayList<>();
        
        JSONParser jp = new JSONParser();
        try {
            Map data = jp.parseJSON(reader);
            ArrayList parkingList = (ArrayList) data.get("rows");
            int n = parkingList.size();
            for (int i = 0; i < n; i++) {
                LinkedHashMap map = (LinkedHashMap) parkingList.get(i);
                LinkedHashMap doc = (LinkedHashMap) map.get("doc");
                String id = (String) doc.get("_id");
                String rev = (String) doc.get("_rev");
                String name = (String) doc.get("name");
                String address = (String) doc.get("address");
                Double parkingSpace = (Double) doc.get("parkingSpace"); 
                LinkedHashMap geolocation = (LinkedHashMap) doc.get("geolocation");
                    ArrayList coordinates = (ArrayList) geolocation.get("coordinates");
                    Double lon = (Double) coordinates.get(0);
                    Double lat = (Double) coordinates.get(1);                        
                LinkedHashMap price = (LinkedHashMap) doc.get("price");
                    Double priceHour = (Double) price.get("hour");
                    Double priceDay = (Double) price.get("day");
                    Double priceMonth = (Double) price.get("month");
                    
                    
                Parking oParking = new Parking();
                oParking.setId(id);
                oParking.setName(name);
                oParking.setAddress(address);
                oParking.setParkingSpaces(new Double(parkingSpace).intValue());
                oParking.setPriceHour(priceHour);
                oParking.setPriceDay(priceDay);
                oParking.setPriceMonth(priceMonth);
                
                resp.add(oParking);
            }
            
        }
        catch (IOException ioex) {
            
        }
                
        return resp;
    }
    
    final String BASE_URL_JSON =
      "http://mytranslationservice.myblumix.net";

    final String BASE_URL_JSON1 =
      "http://mytests.mybluemix.net";
    

    public ArrayList<Parking> getParkingList_json(
            String geoLocation,
            String radius) {

        // Cloudant inverts latitude/longitude  order
        List<String> ll = StringUtil.tokenize(geoLocation, ",");
        String longitude = ll.get(1);
        String latitude  = ll.get(0);
        
        //String longitude = geoLocation.split(",")[1];
        //String latitude  = geoLocation.split(",")[0];
        
        JsonConnectionRequest r = new JsonConnectionRequest();
        
        r.setPost(true);
        r.setUrl(BASE_URL_JSON1 + "/teste");
        r.setContentType("application/json");

        String pUrl = "g=POINT("
            + longitude + "," + latitude + ")"
            + "&nearest=true" 
            + "&radius=" + radius
            + "&include-docs=true";        

        HashMap<String,Object> map = new HashMap<>();
        map.put("url", pUrl);
        //map.put("g", "POINT(" + longitude + "," + latitude + ")");
        //map.put("nearest", "true");
        //map.put("radius", radius);
        //map.put("include-docs", "true");
        String json = new JSONObject(map).toString();
        r.setRequestJsonString(json);
        
        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(r);
        
        ByteArrayInputStream bais = 
            new ByteArrayInputStream(r.getResponseData());
        InputStreamReader reader = new InputStreamReader(bais);
        
        ArrayList<Parking> resp = new ArrayList<>();
        
        JSONParser jp = new JSONParser();
        try {
            Map data = jp.parseJSON(reader);
            Boolean b = true;
            //ArrayList parkings = (ArrayList) data.get("parkings");
            //for (Object parkings :  parkings) {
            //    Parking parking = new Parking();
            //    (LinkedHashMap) measure);
            //    resp.add(ttLastMeasure);
            //}     
        }
        catch (IOException ioex) {
            
        }
                
        return null;
    }

    public ArrayList<Parking> getParkingListTest() {
        ArrayList<Parking> list = new ArrayList<>();
        Parking p;
        
        for (int i = 0; i < 10; i++) {
            p = new Parking();
            p.setId("" + 1);
            p.setAddress("Avenida Paulista, 1220");
            p.setGeolocation(GEO_LIST[i]);
            p.setPriceDay(15.0);
            p.setPriceHour(8.0);
            p.setPriceMonth(500.0);
            p.setName("Parking " + i);
            p.setParkingSpaces(i);
            list.add(p);
        }
                
        return list;
    }
    
        
    class JsonConnectionRequest extends ConnectionRequest {

        private String json;

        public JsonConnectionRequest() {
            super();
        }
        public JsonConnectionRequest(String url) {
            super(url);
        }
        public JsonConnectionRequest(String url, boolean post) {
            super(url,post);
        }

        public void setRequestJsonString(String json) {
            this.json = json;
        }

        @Override
        protected void buildRequestBody(OutputStream os) throws IOException {
            //super.buildRequestBody(os);
            os.write(json.getBytes());
        }


    }

}
