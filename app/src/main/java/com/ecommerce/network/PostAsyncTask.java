package com.ecommerce.network;

import android.os.AsyncTask;
import android.util.Log;

import com.ecommerce.presenter.CompliantListPresenter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rvaishya on 11/9/2017.
 */

public class PostAsyncTask extends AsyncTask<Object, Object, Object> {

    private String email;
    private String password;
    private CompliantListPresenter compliantListPresenter;
    String api;
    String data;

    public PostAsyncTask(String email, String password, CompliantListPresenter compliantListPresenter) {
        this.compliantListPresenter = compliantListPresenter;
    }

    public PostAsyncTask(String data, CompliantListPresenter compliantListPresenter, String api) {
        this.compliantListPresenter = compliantListPresenter;
        this.api = api;
        this.data = data;
    }
    public PostAsyncTask(String data, CompliantListPresenter compliantListPresenter) {
        this.compliantListPresenter = compliantListPresenter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        compliantListPresenter.onProcessStart();
    }
    @Override
    protected void onPostExecute(Object response) {
        super.onPostExecute(response);
        compliantListPresenter.onLoadSuccess(response);
       /* if (response) {
        loginPresenter.onLoginSuccess(email);
        } else {
        loginPresenter.onLoginError("Oops incorrect account details.");
        }*/
    }

    @Override
    protected Object doInBackground(Object... params) {

        String line = "";
        StringBuilder result = new StringBuilder();
        try {

            URL url = new URL(api);
            // HttpsURLConnection connect = (HttpsURLConnection) url.openConnection();
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("POST");
            connect.setRequestProperty("Content-Type", "application/json");
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.connect();
            OutputStreamWriter wr = new OutputStreamWriter(connect.getOutputStream());
            wr.write(data.toString());
            wr.flush();
            InputStream in = new BufferedInputStream(connect.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("result_main", result.toString());
        return result.toString();
    }
}
