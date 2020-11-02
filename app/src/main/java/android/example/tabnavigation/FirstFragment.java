package android.example.tabnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FirstFragment extends Fragment {


    private ArrayList<ItemData> itemValues;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private FloatingActionButton addButton;

    public FirstFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first, container,false);
        recyclerView=view.findViewById(R.id.recyclerView);
        addButton=view.findViewById(R.id.add_button);

        itemValues=new ArrayList<>();
        for (int i=1;i<=10;i++){
            ItemData item=new ItemData();
            item.itemTitle="Title Data - "+i;
            item.itemSubTitle="Subtitle Data - "+i;
            itemValues.add(item);
        }
        itemAdapter=new ItemAdapter(getActivity(),itemValues);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false);
        GridLayoutManager layoutManager2=new GridLayoutManager(getActivity(),
                2);
        recyclerView.setLayoutManager(layoutManager2);
        recyclerView.setAdapter(itemAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });

        return view;
    }

    private void addData(){
        ItemData item=new ItemData();
        item.itemTitle="Title Data - Baru";
        item.itemSubTitle="Subtitle Data - Baru";
        itemValues.add(item);
        itemAdapter.notifyDataSetChanged();
    }


}