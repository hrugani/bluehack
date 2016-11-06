/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueHack;

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
    
    
    
    
    public ArrayList<Parking> getParkingList(String geoLocation) {

        ConnectionRequest r = new ConnectionRequest();
        
        r.setPost(false);
        r.setUrl("/parkings");
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
    
}
