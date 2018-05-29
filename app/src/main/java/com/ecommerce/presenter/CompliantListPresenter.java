package com.ecommerce.presenter;

/**
 * Created by rvaishya on 11/9/2017.
 */

public interface CompliantListPresenter {


    void onLoad(String data);

    void onProcessStart();

    void onLoadSuccess(Object obj);

    void onLoadError(Object obj);
}
