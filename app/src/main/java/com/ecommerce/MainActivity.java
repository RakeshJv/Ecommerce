package com.ecommerce;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends BaseActivity {
    private AutoCompleteTextView autoComplete;
    ArrayList<HashMap<String,String>> retailerList;
    ArrayList<HashMap<String,String>> autoCompleteList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retailerList = new ArrayList<HashMap<String, String>>();

        HashMap<String,String> row1 = new HashMap<String, String>();
        row1.put("area","Mahim");
        row1.put("zip", "400017");
        retailerList.add(row1);

        HashMap<String,String> row2 = new HashMap<String, String>();
        row2.put("area","Dadar");
        row2.put("zip", "400014");
        retailerList.add(row2);

        HashMap<String,String> row3 = new HashMap<String, String>();
        row3.put("area","Matunga");
        row3.put("zip", "400019");
        retailerList.add(row3);

        HashMap<String,String> row4 = new HashMap<String, String>();
        row4.put("area","Bandra");
        row4.put("zip", "334");
        retailerList.add(row4);

        HashMap<String,String> row5 = new HashMap<String, String>();
        row5.put("area","Khar");
        row5.put("zip", "235");
        retailerList.add(row5);

        HashMap<String,String> row6 = new HashMap<String, String>();
        row6.put("area","SantaCruze");
        row6.put("zip", "333");
        retailerList.add(row6);

        HashMap<String,String> row7 = new HashMap<String, String>();
        row7.put("area","Elphinstone");
        row7.put("zip", "521");
        retailerList.add(row7);

        HashMap<String,String> row8 = new HashMap<String, String>();
        row8.put("area","Lower Parel");
        row8.put("zip","527");
        retailerList.add(row8);

        autoComplete = (AutoCompleteTextView) findViewById(R.id.editText);
        autoComplete.setAdapter(new AutoCompleteAdapter(this,android.R.layout.simple_list_item_1, retailerList));
        autoComplete.setThreshold(1);
        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Object item = parent.getItemAtPosition(position);
                HashMap<String, String> data = autoCompleteList.get(position);
                data.keySet();
                showStoreList();


            }
        });
    }
    private class AutoCompleteAdapter extends ArrayAdapter<String> implements Filterable {
        public AutoCompleteAdapter(Context context, int textViewResourceId, ArrayList<HashMap<String,String>> data) {
            super(context, textViewResourceId);
        }

        @Override
        public int getCount() {
            return autoCompleteList.size();
        }

        @Override
        public String getItem(int position) {
            return autoCompleteList.get(position).get("area");
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(final CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint != null) {
                        autoCompleteList = new ArrayList<HashMap<String, String>>();

                        final String prefixString = constraint.toString().toLowerCase();

                        for (int i = 0; i < retailerList.size(); i++)
                        {

                           /* if (retailerList.get(i).get("area").startsWith(constraint.toString())
                                    ||retailerList.get(i).get("zip").startsWith(constraint.toString()))
                            {
                                autoCompleteList.add(retailerList.get(i));
                            }*/

                            if (retailerList.get(i).get("area").toLowerCase().contains(prefixString)
                                    ||retailerList.get(i).get("zip").toLowerCase().contains(prefixString))
                            {

                                autoCompleteList.add(retailerList.get(i));

                            }


                        }
                        // Now assign the values and count to the FilterResults
                        // object
                        filterResults.values = autoCompleteList;
                        filterResults.count = autoCompleteList.size();
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    if (results != null && results.count > 0)
                    {
                        notifyDataSetChanged();
                    } else {
                        notifyDataSetInvalidated();
                    }
                }
            };
            return filter;
        }
    }

    private void  showStoreList(){

        Intent intent = new Intent(this,StoreListActivity.class);
        startActivity(intent);



    }
}
