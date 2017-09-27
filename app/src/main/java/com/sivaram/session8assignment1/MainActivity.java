package com.sivaram.session8assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    // Declare Button & List View as global object.
    Button btnAscending, btnDescending;
    ListView monthNameListView;
    ArrayList<String> monthNamesArrayList;
    ArrayAdapter<String> monthNamesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Type Cast Layout Views in Java Objects.
        btnAscending = (Button) findViewById(R.id.btnAscending); // Type Cast Ascending Button
        btnDescending = (Button) findViewById(R.id.btnDescending); // Type Cast Descending Button
        monthNameListView = (ListView) findViewById(R.id.monthNamesListView); // Type Cast Month Name List View.

        initializeListViewWithArrayListAndAdapter();

        if (btnAscending != null) {
            btnAscending.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changeListViewSortOrder(view);
                }
            });
        }

        if (btnDescending != null) {
            btnDescending.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changeListViewSortOrder(view);
                }
            });
        }
    }

    // Method to Change Order or List View Depending on Selected Button
    private void changeListViewSortOrder(View view){
        final View buttonView = view;
        // Call Back to sort based on Selected Button Tag
        Collections.sort(monthNamesArrayList, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (buttonView.getTag().equals("1"))
                    return s.compareTo(t1);
                else
                    return t1.compareTo(s);
            }
        });
        monthNamesAdapter.notifyDataSetChanged();
    }

    private void initializeListViewWithArrayListAndAdapter(){
        // Assign Values to Month Name Array List
        monthNamesArrayList = new ArrayList<String>();
        monthNamesArrayList.add("January");
        monthNamesArrayList.add("February");
        monthNamesArrayList.add("March");
        monthNamesArrayList.add("April");
        monthNamesArrayList.add("May");
        monthNamesArrayList.add("June");
        monthNamesArrayList.add("July");
        monthNamesArrayList.add("Auguest");
        monthNamesArrayList.add("September");
        monthNamesArrayList.add("October");
        monthNamesArrayList.add("November");
        monthNamesArrayList.add("December");

        // Assign ArrayList to Array Adapter
        monthNamesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,monthNamesArrayList);
        monthNameListView.setAdapter(monthNamesAdapter);
    }
}
