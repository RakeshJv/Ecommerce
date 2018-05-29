package com.ecommerce.presenter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.ecommerce.network.IServerRequestMethod;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by rvaishya on 10/16/2017.
 */

public class ServerOperation {

    Activity activity;
    ServerResponseCallback serverResponce;
    String api;
    String requestMethod;
    boolean isSwipeRefresh;
    /* the constructor will be used for the GET Method*/
    public ServerOperation(Activity activity, ServerResponseCallback serverResponce, String api, String requestMethod, boolean isSwipeRefresh) {
        this.isSwipeRefresh=isSwipeRefresh;
        this.activity = activity;
        this.serverResponce = serverResponce;
        this.api = api;
        this.requestMethod = requestMethod;
        new AsyncFetch().execute();
    }

    /* the constructor will be used for the PUT Method*/
    public ServerOperation(Activity activity, ServerResponseCallback serverResponce, String api, String requestMethod, JSONObject jason ) {
        this.activity = activity;
        this.serverResponce = serverResponce;
        this.api = api;
        this.requestMethod = requestMethod;
        new AsyncFetch().execute(jason);
    }

    class AsyncFetch extends AsyncTask<Object, Object, Object> {
        ProgressDialog pdLoading = new ProgressDialog(activity);
        HttpURLConnection conn;
        HttpsURLConnection connect;
        URL url = null;

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            if(!isSwipeRefresh) {
                pdLoading.setMessage("\tLoading...");
                pdLoading.setCancelable(false);
                pdLoading.show();
            }
        }

        @Override
        protected String doInBackground(Object... params) {

            try {
                StringBuilder result =null;
                url = new URL(api);
                if (requestMethod == IServerRequestMethod.POST)
                {

                    URL url = new URL("https://cxp.merilent.com:446/saveTicket");
                    HttpsURLConnection connect = (HttpsURLConnection) url.openConnection();
                    connect.setRequestMethod("POST");
                    connect.setRequestProperty("Content-Type","application/json");
                    connect.setDoInput(true);
                    connect.setDoOutput(true);
                    connect.connect();
                    OutputStreamWriter out = new OutputStreamWriter(connect.getOutputStream());

                    out.write(params.toString());
                    out.close();
                    InputStream in = new BufferedInputStream(connect.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    result = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                }
                else{
                    url = new URL(api);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(requestMethod);
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    result = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                }


                Log.i("RESULT DATA: ", result.toString());
                return (result.toString());

            }
            catch (MalformedURLException e) {
                e.printStackTrace();
                return e.toString();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return e1.toString();
            }

            finally {
                if(conn !=null){
                    conn.disconnect();
                }
                if(connect!=null){
                    connect.disconnect();
                }
            }

        }

        @Override
        protected void onPostExecute(Object result) {
            if(!isSwipeRefresh) {
                pdLoading.dismiss();
            }
                serverResponce.onResponse(result);
            }

        }
    }

