package com.ecommerce.adapter;

/**
 * Created by Lincoln on 15/01/16.
 */
public class Menu {
    private String itemName, genre;
    private  int  price;

    int quntity ;

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }

    int totalAmount;
    int grandTotal;


    public static Menu getMenu() {
        return menu;
    }

    public static void setMenu(Menu menu) {
        Menu.menu = menu;
    }

    static  Menu menu;


    public Menu() {
    }

    public Menu(String itemName, String genre, int price) {
        this.itemName = itemName;
        this.genre = genre;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
