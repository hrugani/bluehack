/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueHack.entities;

/**
 *
 * @author hrugani
 */
public class Parking {
    
    private String id;
    private String name;
    private String address;
    private String geolocation;
    private Double priceDay;
    private Double priceHour;
    private Double priceMonth;
    private int parkingSpaces;

    public Parking() {
        
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the geolocation
     */
    public String getGeolocation() {
        return geolocation;
    }

    /**
     * @param geolocation the geolocation to set
     */
    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    /**
     * @return the priceDay
     */
    public Double getPriceDay() {
        return priceDay;
    }

    /**
     * @param priceDay the priceDay to set
     */
    public void setPriceDay(Double priceDay) {
        this.priceDay = priceDay;
    }

    /**
     * @return the priceHour
     */
    public Double getPriceHour() {
        return priceHour;
    }

    /**
     * @param priceHour the priceHour to set
     */
    public void setPriceHour(Double priceHour) {
        this.priceHour = priceHour;
    }

    /**
     * @return the priceMonth
     */
    public Double getPriceMonth() {
        return priceMonth;
    }

    /**
     * @param priceMonth the priceMonth to set
     */
    public void setPriceMonth(Double priceMonth) {
        this.priceMonth = priceMonth;
    }

    /**
     * @return the parkingSpaces
     */
    public int getParkingSpaces() {
        return parkingSpaces;
    }

    /**
     * @param parkingSpaces the parkingSpaces to set
     */
    public void setParkingSpaces(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }
        
}
