package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText txtNum1, txtNum2, txtNum3, txtNum4, txtNum5, txtNum;
    RadioButton rBArit, rBAlge;
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNum = findViewById(R.id.txtNum);
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        txtNum3 = findViewById(R.id.txtNum3);
        txtNum4 = findViewById(R.id.txtNum4);
        txtNum5 = findViewById(R.id.txtNum5);
        rBArit = findViewById(R.id.rBArit);
        rBAlge = findViewById(R.id.rBAlge);
        btnCheck = findViewById(R.id.btnCheck);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    }

    private int Random(){
        Random r = new Random();
        return r.nextInt();
    }
}