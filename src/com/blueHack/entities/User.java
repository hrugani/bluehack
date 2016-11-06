/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueHack.entities;

import java.util.HashMap;
import ca.weblite.codename1.json.JSONObject;


/**
 *
 * @author hrugani
 */
public class User {

    private String id;
    private String name;
    private String type; // "N" Normal, "E" Enterprise
    
    public User() {
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    
    public String toJSON() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id", getId());
        map.put("name", getName());
        map.put("type", getType());
        return new JSONObject(map).toString();
    }

    @Override
    public String toString() {
        return toJSON();
    }    
    
}
