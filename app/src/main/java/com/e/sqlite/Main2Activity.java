package com.e.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.MyHelper;
import model.WordClass;

public class Main2Activity extends AppCompatActivity {
    private ListView lvwords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvwords = findViewById(R.id.lvwords);
        LoadWord();


    }
    private void LoadWord() {
        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        List<WordClass> wordList = new ArrayList<>();
        wordList = myHelper.GetAllWords(sqLiteDatabase);

        HashMap<String,String> hashMap = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {
            hashMap.put(wordList.get(i).getWord(),wordList.get(i).getMeaning());
        }
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<> (
           this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(hashMap.keySet())

        );
        lvwords.setAdapter(stringArrayAdapter);
    }
}
