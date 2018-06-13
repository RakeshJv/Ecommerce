package com.ecommerce.contant;

public interface DataBaseConstant {

     String DATABASE_NAME = "ecommerce.db";
     String LOGIN_DETAILS_TABLE = "login";
     String _ID = "id";
     String NAME = "name";
     String USER_NAME = "user_name";
     String PASSWORD = "password";
     String SERVERT_TOKEN="server_token";

     String CONTACTS_COLUMN_CITY = "place";
     String CONTACTS_COLUMN_PHONE = "phone";

      //db.execSQL(
        //      "create table LOGIN_DETAILS_TABLE "  +


//    String CREATE_LOGIN_TABLE="CREATE TABLE "+ LOGIN_DETAILS_TABLE + " (" + ;

     // Create table SQL query
     public static final String CREATE_LOGIN_TABLE =
             "CREATE TABLE " + LOGIN_DETAILS_TABLE + "("
                     + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                     + USER_NAME + " TEXT,"
                     + PASSWORD + "TEXT,"
                     + SERVERT_TOKEN + "TEXT"
                    + ")";
}

