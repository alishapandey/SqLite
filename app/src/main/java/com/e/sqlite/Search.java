package com.e.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.MyHelper;
import model.WordClass;

public class Search extends AppCompatActivity {

    EditText etSearch;
    Button btnSearch;
    ListView vList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etSearch=findViewById(R.id.etsearch);
        btnSearch=findViewById(R.id.btnsearch);
        vList=findViewById(R.id.vlist);

  btnSearch.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          LoadWord();
      }
  });
    }
    public void LoadWord(){
        final MyHelper myHelper= new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        List<WordClass> wordClasses=new ArrayList<>();
        wordClasses = myHelper.GetWordByName(etSearch.getText().toString(),sqLiteDatabase);
        HashMap<String,Search>hashMap = new HashMap<>();
        for (int i =0);i < wordClasses.size();i++) {
    hashMap.put(wordClasses.get(i).getWord(),wordClasses.get(i).getMeaning());
        }
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(String)(hashMap.keySet()));
vList.setAdapter(stringArrayAdapter);

    }

}
