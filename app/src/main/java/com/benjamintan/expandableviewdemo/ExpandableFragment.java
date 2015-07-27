package com.benjamintan.expandableviewdemo;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpandableFragment extends Fragment {


    public ExpandableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_expandable, container, false);

        final ListView listView1 = (ListView) root.findViewById(R.id.listView1);
        final ListView listView2 = (ListView) root.findViewById(R.id.listView2);

        Button button = (Button) root.findViewById((R.id.switch_view_btn));

        SmallListAdapter sAdapter = new SmallListAdapter(getActivity());
        listView1.setAdapter(sAdapter);

        BigListAdapter bAdapter = new BigListAdapter(getActivity());
        listView2.setAdapter(bAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listView1.isShown()) {
                    listView1.setVisibility(View.INVISIBLE);
                    listView2.setVisibility(View.VISIBLE);

                    root.setMinimumHeight(1000);

                } else {
                    listView1.setVisibility(View.VISIBLE);
                    listView2.setVisibility(View.INVISIBLE);

                    root.setMinimumHeight(200);
                }
            }
        });

        return root;
    }
}
