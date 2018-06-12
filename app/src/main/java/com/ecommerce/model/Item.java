package com.ecommerce.model;

public class Item extends  Element{

    public void setItemName(String itemName) {
        this.elementName = itemName;
    }

    public void setManuFactredBy(String manuFactredBy) {
        this.manufacterdBy = manuFactredBy;
    }

    public String getItemName() {
        return this.elementName;
    }


    public String getManuFactredBy() {
        return this.manufacterdBy;
    }



}
