package com.ecommerce.model;

/**
 * Created by Rvaishya on 5/1/2018.
 */

public class Merchant extends Person{

private     int merchantId;
   private  String nearLandmark;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

private     Address address;

    public Contact getContact()
    {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    Contact contact;


    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return this.name;
    }

    public void setMerchantName(String merchantName) {
        this.name = merchantName;
    }


    public String getNearLandmark() {
        return nearLandmark;
    }

    public void setNearLandmark(String nearLandmark) {
        this.nearLandmark = nearLandmark;
    }



}
