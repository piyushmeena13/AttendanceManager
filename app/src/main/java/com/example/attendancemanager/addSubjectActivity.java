package com.example.attendancemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addSubjectActivity extends AppCompatActivity {

    private EditText subName,classAttended,totalClasses;
    private Button addSubjectBtn;
    MyHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        init();
        addData();
    }

    private void addData() {
        addSubjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(classAttended.getText().toString()) <= Integer.valueOf(totalClasses.getText().toString())){
                    boolean isInserted =helper.insertData(subName.getText().toString(),classAttended.getText().toString(),totalClasses.getText().toString());
                    if(isInserted == true){
                        Toast.makeText(addSubjectActivity.this, "Subject Added", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(addSubjectActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(addSubjectActivity.this, "Subject could not be added", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(addSubjectActivity.this, "Wrong Details Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        subName =findViewById(R.id.editText);
        classAttended =findViewById(R.id.editText2);
        totalClasses =findViewById(R.id.editText3);
        addSubjectBtn =findViewById(R.id.addSubjectBtn);

        helper=new MyHelper(this);
    }
}
