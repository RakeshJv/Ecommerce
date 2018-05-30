package com.ecommerce.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecommerce.R;
import com.ecommerce.adapter.Menu;
import com.ecommerce.adapter.MenuAdapter;
import com.ecommerce.adapter.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StoreListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StoreListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoreListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public StoreListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    MenuAdapter mAdapter;
    private List<Menu> menuList = new ArrayList<>();
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
                //showAlert(position);
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
        Menu movie = new Menu("Chicken Cury", "Non veg", 150);
        menuList.add(movie);

        movie = new Menu("Chicken Masala", "Non veg", 155);
        menuList.add(movie);
        movie = new Menu("Butter Chicken", "Non veg", 175);
        menuList.add(movie);
        movie = new Menu("Chicken Fried Rice", "Non veg", 110);
        menuList.add(movie);

       /* movie = new Menu("The Martian", "Science Fiction & Fantasy", "2015");
        menuList.add(movie);

        movie = new Menu("Mission: Impossible Rogue Nation", "Action", "2015");
        menuList.add(movie);

        movie = new Menu("Up", "Animation", "2009");
        menuList.add(movie);

        movie = new Menu("Star Trek", "Science Fiction", "2009");
        menuList.add(movie);

        movie = new Menu("The LEGO Menu", "Animation", "2014");
        menuList.add(movie);

        movie = new Menu("Iron Man", "Action & Adventure", "2008");
        menuList.add(movie);

        movie = new Menu("Aliens", "Science Fiction", "1986");
        menuList.add(movie);

        movie = new Menu("Chicken Run", "Animation", "2000");
        menuList.add(movie);

        movie = new Menu("Back to the Future", "Science Fiction", "1985");
        menuList.add(movie);

        movie = new Menu("Raiders of the Lost Ark", "Action & Adventure", "1981");
        menuList.add(movie);

        movie = new Menu("Goldfinger", "Action & Adventure", "1965");
        menuList.add(movie);

        movie = new Menu("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        menuList.add(movie);*/

        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }

}
