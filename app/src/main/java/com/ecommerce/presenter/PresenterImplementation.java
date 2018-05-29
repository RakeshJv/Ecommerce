package com.ecommerce.presenter;


import com.ecommerce.network.GetAsynckTask;
import com.ecommerce.network.NetworkApi;
import com.ecommerce.network.PostAsyncTask;

public class PresenterImplementation implements CompliantListPresenter {

    //private CompliantListView CompliantListView;
   String api;
   boolean isLoadingComplaint;
    String requestype;
   /* public PresenterImplementation(CompliantListView CompliantListView , String api, boolean isLoadingComplaint , String requestype)
    {
        this.CompliantListView = CompliantListView;
        this.api =api;
        this.isLoadingComplaint =isLoadingComplaint;
        this.requestype =requestype;
    }
    public PresenterImplementation(CompliantListView CompliantListView , String api , String requestype)
    {
        this.CompliantListView = CompliantListView;
        this.api =api;
        this.requestype =requestype;
    }*/
    @Override
    public void onLoad(String data)
    {
        if (data == null)
        {
            //CompliantListView.onError("Please Enter data");
        }
        if(requestype.equalsIgnoreCase(NetworkApi.POST))
        {
            //new PostAsyncTask(data, this, api).execute("ajain@merilent.com","69","drm");
            new PostAsyncTask(data, this, api).execute();

        }
        else{
            new GetAsynckTask(data, this,api).execute();

        }

    }

    @Override
    public void onProcessStart() {

        //CompliantListView.onShowProgress();
        if(isLoadingComplaint)
        {

        }
        else{
            //CompliantListView.onShowProgress();
        }
    }

    @Override
    public void onLoadSuccess(Object obj) {
       // CompliantListView.onSuccess(obj);
       ///CompliantListView.onHideProgress();
    }

    @Override
    public void onLoadError(Object obj) {
       // CompliantListView.onHideProgress();
        if(isLoadingComplaint)
        {

        }
        else{

            //CompliantListView.onHideProgress();
        }
        //CompliantListView.onError(obj);

    }
}