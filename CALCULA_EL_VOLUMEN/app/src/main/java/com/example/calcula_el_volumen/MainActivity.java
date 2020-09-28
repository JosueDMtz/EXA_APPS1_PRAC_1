package com.example.calcula_el_volumen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtRad, txtAn;
    EditText editTxt;
    Button btnCalcular;
    SeekBar seekBar;

    int min = 0, max = 360, current = 180;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtAn = findViewById(R.id.txtAn);
        seekBar = findViewById(R.id.seekBar);
        btnCalcular = findViewById(R.id.btnCalcular);
        editTxt = findViewById(R.id.editTxt);

        seekBar.setMax(max - min);
        seekBar.setProgress(current - min);
        txtAn.setText("Ángulo: " + current);
        cerrarTeclado();

        editTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalcularVolumen();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                current = progress + min;
                txtAn.setText("Ángulo: " + current);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void CalcularVolumen(){
        int radio, angulo;
        double volumen;
        radio = Integer.parseInt(editTxt.getText().toString());
        angulo = Integer.parseInt(String.valueOf(seekBar.getProgress()));
        volumen = (0.66)*((angulo)*(radio)*(3));
        Toast.makeText(getApplicationContext(), "Volumen: " + volumen, Toast.LENGTH_LONG).show();
    }
    private void cerrarTeclado(){
        View v = this.getCurrentFocus();
        if(v != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0 );
        }
    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}