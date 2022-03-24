package com.example.linearlayoutandgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btnAddName);
        EditText etName = findViewById(R.id.etName);
        ListView lvName = findViewById(R.id.lvListName);
        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,data);
        lvName.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName != null){
                    data.add(etName.getText().toString());
                    adapter.notifyDataSetChanged();
                    etName.setText("");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please add name you want to input the list!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}