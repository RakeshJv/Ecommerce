package com.ecommerce.model;

/**
 * Created by Rvaishya on 5/1/2018.
 */

public class Merchant {

    int merchantId;
    String merchantName;
    String addressLine1;
    String addressLine2;
    int mobileNumber;
    String landLineNumber;
    String nearLandmark;

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLandLineNumber() {
        return landLineNumber;
    }

    public void setLandLineNumber(String landLineNumber) {
        this.landLineNumber = landLineNumber;
    }

    public String getNearLandmark() {
        return nearLandmark;
    }

    public void setNearLandmark(String nearLandmark) {
        this.nearLandmark = nearLandmark;
    }

}
