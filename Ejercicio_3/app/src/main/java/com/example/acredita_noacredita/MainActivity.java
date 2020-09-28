package com.example.acredita_noacredita;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtName, txtControl;
    TextView txtPuntos, txtCalif, txtResultado;
    SeekBar skBarPuntos, skBarCalif;
    ImageView img1, img2, img3;

    String puntos = "Puntos para acreditar: ";
    String calif = "Calificación: ";
    String A = "ACREDITADO!!";
    String F = "NO ACREDITADO!!";

    int cero = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtName = findViewById(R.id.txtName);
        txtControl = findViewById(R.id.txtControl);
        txtPuntos = findViewById(R.id.txtPuntos);
        txtCalif = findViewById(R.id.txtCalif);
        txtResultado = findViewById(R.id.txtResultado);
        skBarPuntos = findViewById(R.id.skBarPuntos);
        skBarCalif = findViewById(R.id.skBarCalif);
        skBarPuntos.setMax(100);
        skBarCalif.setMax(100);
        txtPuntos.setText(puntos + 0);
        txtCalif.setText(calif + 0);
        txtResultado.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        skBarPuntos.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtPuntos.setText(puntos + skBarPuntos.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skBarCalif.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtCalif.setText(calif + skBarCalif.getProgress());
                if(IsApproved(skBarPuntos.getProgress(), skBarCalif.getProgress())){
                    txtResultado.setVisibility(View.VISIBLE);
                    txtResultado.setText(A);
                }
                else{
                    txtResultado.setVisibility(View.VISIBLE);
                    txtResultado.setText(F);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private Boolean IsApproved(int minCalif, int calif){
         return calif >= minCalif;
    }
}