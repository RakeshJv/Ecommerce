package com.ecommerce.network;

/**
 * Created by rvaishya on 10/16/2017.
 */

public class NetworkApi{
/*

   // public static String INSERT_ACTIVITY_DETAIL="https://cxp.merilent.com:446/save_app_complaint";
    public static String INSERT_ACTIVITY_DETAIL ="http://192.168.1.123:7777/insertActivityDetail";
    public static String   GET_ALL_COMPLAINT_LIST ="http://192.168.1.123:7777/get_app_complaint_train";
    public static String   GET_STATUS ="http://192.168.1.123:7777/getStatus";
    //public static String   GET_ISSUE_DETAILS ="http://192.168.1.123:7777/getIssueDetails";
    public static String   GET_ISSUE_DETAILS =" http://192.168.1.123:7777/getrailuser";


    public static String   LOG_IN ="http://192.168.1.123:7777/verifyUser";
    public static String POST="POST";
    public static String GET="GET";

*/

/* public static String BASE_URL = "http://192.168.1.123:7777/";
 // public static String INSERT_ACTIVITY_DETAIL="https://cxp.merilent.com:446/save_app_complaint";
 public static String INSERT_ACTIVITY_DETAIL =BASE_URL+"insertActivityDetail";
 public static String   GET_ALL_COMPLAINT_LIST =BASE_URL+"get_app_complaint_train";
 public static String   GET_STATUS =BASE_URL+"getStatus";
 //public static String   GET_ISSUE_DETAILS ="http://192.168.1.123:7777/getIssueDetails";
 public static String   GET_ISSUE_DETAILS =BASE_URL+"getrailuser";

 public static String FORGET_PASSWORD=BASE_URL+"api/send_email_user_password";
 public static String  LOG_IN =BASE_URL+"verifyUser";
 public static String POST="POST";
 public static String GET="GET";
 public static String SIGN_UP=BASE_URL+"api/send_email_user";
 public static String READ_COMPLAINT=BASE_URL+"api/ticket/mark_read_complaint";*/

 public static String BASE_URL = "https://cxpbmc.merilent.com:450/";
 // public static String INSERT_ACTIVITY_DETAIL="https://cxp.merilent.com:446/save_app_complaint";
 public static String INSERT_ACTIVITY_DETAIL =BASE_URL+"api/ticket/insert_activity_details";
 public static String   GET_ALL_COMPLAINT_LIST =BASE_URL+"api/ticket/get_app_complaint_drm";
 public static String   GET_STATUS =BASE_URL+"api/ticket/get_status";
 //public static String   GET_ISSUE_DETAILS ="http://192.168.1.123:7777/getIssueDetails";
 public static String   GET_ISSUE_DETAILS =BASE_URL+"getrailuser";
 public static String  LOG_IN =BASE_URL+"verifyUser";
 public static String POST="POST";
 public static String GET="GET";
 public static String SIGN_UP=BASE_URL+"api/send_email_user";
 public static String READ_COMPLAINT=BASE_URL+"api/ticket/mark_read_complaint";

}
