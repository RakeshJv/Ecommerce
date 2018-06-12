package com.ecommerce.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ecommerce.R;
import com.ecommerce.adapter.MenuAdapter;
import com.ecommerce.adapter.RecyclerTouchListener;
import com.ecommerce.model.Address;
import com.ecommerce.model.Contact;
import com.ecommerce.model.Merchant;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StoreListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StoreListFragment#} factory method to
 * create an instance of this fragment.
 */
public class StoreListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public StoreListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    MenuAdapter mAdapter;
    private List<Merchant> menuList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store_list, container, false);
        // recyclerView=(RecyclerView)view.findViewById(R.id.listView);
        recyclerView = (RecyclerView) view.findViewById(R.id.listView);
        mAdapter = new MenuAdapter(menuList);
        recyclerView.setHasFixedSize(true);

        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position)
            {
                Toast.makeText(getActivity(),"Index number-->"+position,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();

        return  view;
    }


        // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Stores");        // Required empty public constructor

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void prepareMovieData() {
        Merchant  merchant= new Merchant();
        merchant.setMerchantId(1);

        merchant.setMerchantName("Shop 1");
        Address address = new Address();
        address.setAddress1("Kamala Nagar Jasmine mill road");
        address.setAddress2("Mahim East");
        merchant.setAddress(address);

        Contact contact = new Contact();
        contact.setLandLine("022-88888888");
        contact.setMobileNumber(1234567890);
        merchant.setContact(contact);
        merchant.setNearLandmark("Church");

        menuList.add(merchant);



        merchant= new Merchant();
        merchant.setMerchantId(2);

        merchant.setMerchantName("Shop 1");
         address = new Address();
        address.setAddress1("Kamala Nagar Jasmine mill road");
        address.setAddress2("Mahim East");
        merchant.setAddress(address);

        contact = new Contact();
        contact.setMobileNumber(1234567890);

        contact.setLandLine("022-88888888");
        merchant.setContact(contact);
        merchant.setNearLandmark("Church");
        menuList.add(merchant);

        menuList.add(merchant);



        menuList.add(merchant);


        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }

}
