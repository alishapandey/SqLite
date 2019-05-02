package com.e.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helper.MyHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnadd;
    private EditText etword, etmeaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnadd = findViewById(R.id.btnadd);
        etmeaning = findViewById(R.id.etmeaning);
        etword = findViewById(R.id.etword);


        final MyHelper myhelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase =myhelper.getWritableDatabase();

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = myhelper.InsertData(etword.getText().toString(),etmeaning.getText().toString(),sqLiteDatabase);
                if (id > 0){
                    Toast.makeText(MainActivity.this, "Sucessful" + id, Toast.LENGTH_SHORT).show();
                } else
                {
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
