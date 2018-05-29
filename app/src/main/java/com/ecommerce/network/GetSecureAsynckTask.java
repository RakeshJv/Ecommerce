package com.ecommerce.network;

import android.os.AsyncTask;

import com.ecommerce.presenter.CompliantListPresenter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by rvaishya on 11/9/2017.
 */

public class GetSecureAsynckTask extends AsyncTask<Object, Object, Object> {

    private String email;
    private String password;
    private CompliantListPresenter compliantListPresenter;
    String api;

    public GetSecureAsynckTask(String data, CompliantListPresenter compliantListPresenter , String api)
    {
        this.compliantListPresenter = compliantListPresenter;
        this.api =api;
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
    }

    @Override
    protected Object doInBackground(Object... params) {

        String line = "";
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(api);
            HttpsURLConnection connect = (HttpsURLConnection) url.openConnection();
            connect.setRequestMethod("GET");
            connect.setRequestProperty("Content-Type", "application/json");
            connect.setDoInput(true);
            connect.setDoOutput(false);
            connect.connect();
            InputStream in = new BufferedInputStream(connect.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (MalformedURLException e)
        {
            compliantListPresenter.onLoadError(e);
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
            compliantListPresenter.onLoadError(e);
        }
        return result.toString();
    }
}
