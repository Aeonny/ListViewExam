package com.project.listviewexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private MinumanAdapter adapter;
    private ArrayList<Minuman> minumans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MinumanAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(MainActivity.this, minumans.get(i).getName(), Toast.LENGTH_SHORT).show();
        }
    });
    }

    private void addItem(){
        minumans = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){
            Minuman minuman = new Minuman();
            minuman.setPhoto(dataPhoto.getResourceId(i, -1));
            minuman.setName(dataName[i]);
            minuman.setDescription(dataDescription[i]);
            minumans.add(minuman);
        }
        adapter.setMinumans(minumans);
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
}