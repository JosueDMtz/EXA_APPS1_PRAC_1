package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    Button btnReset;
    Button frame[];
    TextView txtResultado, txtTurno;

    String X = "X";
    String O = "O";
    String guion = "-";
    String gana = "GANA ";
    String empate = "Empate!";
    String t = "Turno: ";
    String turno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        frame = new Button[10];
        btnReset = findViewById(R.id.btnReset);
        frame[0] = findViewById(R.id.f0);
        frame[1] = findViewById(R.id.f1);
        frame[2] = findViewById(R.id.f2);
        frame[3] = findViewById(R.id.f3);
        frame[4] = findViewById(R.id.f4);
        frame[5] = findViewById(R.id.f5);
        frame[6] = findViewById(R.id.f6);
        frame[7] = findViewById(R.id.f7);
        frame[8] = findViewById(R.id.f8);
        txtResultado = findViewById(R.id.txtResultado);
        txtTurno = findViewById(R.id.txtTurno);
        for (int i = 0; i < 8 ; i++) {
            frame[i].setText("-");
        }
        turno = X;
        txtTurno.setText(t + turno);
        btnReset.setEnabled(false);
        txtResultado.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        frame[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set(frame[0]);
                LookForWinner();
            }
        });

        frame[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set(frame[1]);
                LookForWinner();
            }
        });

        frame[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set(frame[2]);
                LookForWinner();
            }
        });

        frame[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set(frame[3]);
                LookForWinner();
            }
        });

        frame[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set(frame[4]);
                LookForWinner();
            }
        });

        frame[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set(frame[5]);
                LookForWinner();
            }
        });

        frame[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set(frame[6]);
                LookForWinner();
            }
        });

        frame[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set(frame[7]);
                LookForWinner();
            }
        });

        frame[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set(frame[8]);
                LookForWinner();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reset();
            }
        });
    }

    private void Reset(){
        for (int i = 0; i < 9; i++) {
            frame[i].setText(guion);
            frame[i].setEnabled(true);
        }
        btnReset.setEnabled(false);
        turno = X;
        txtTurno.setText(t + turno);
        txtResultado.setVisibility(View.INVISIBLE);
    }

    private void Set(Button frame){
        frame.setText(turno);
        frame.setEnabled(false);
    }

    private void LookForWinner(){
        if(!WinnerExist()){
            if(IsFull()){
                txtResultado.setText(empate);
                txtResultado.setVisibility(View.VISIBLE);
                EnabledReset();
            }
            else{
                Switch();
            }
        }
        else{
            EnabledReset();
        }
    }

    private void EnabledReset(){
        for (int i = 0; i < 9; i++) {
            frame[i].setEnabled(false);
        }
        btnReset.setEnabled(true);
    }

    private void Switch(){
        if(turno.equals(X)){
            turno = O;
        }
        else if(turno.equals(O)){
            turno = X;
        }
        txtTurno.setText(t + turno);
    }

    private Boolean IsFull(){
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if(frame[i].getText() == "-"){
                counter++;
            }
        }
        return counter == 0;
    }

    private Boolean WinnerExist(){
        // Maneras de ganar
        // 0, 1, 2 -
        Boolean existWinner = true;
        if(IsSame(frame[0].getText().toString(), frame[1].getText().toString(), frame[2].getText().toString())){
            String winner = frame[0].getText().toString();
            ShowResult(winner);
            return existWinner;
        }
        // 3, 4, 5 -
        else if(IsSame(frame[3].getText().toString(), frame[4].getText().toString(), frame[5].getText().toString())){
            String winner = frame[3].getText().toString();
            ShowResult(winner);
            return existWinner;
        }
        // 6, 7, 8 -
        else if(IsSame(frame[6].getText().toString(), frame[7].getText().toString(), frame[8].getText().toString())) {
            String winner = frame[6].getText().toString();
            ShowResult(winner);
            return existWinner;
        }
        // 0, 3, 6 |
        else if(IsSame(frame[0].getText().toString(), frame[3].getText().toString(), frame[6].getText().toString())){
            String winner = frame[0].getText().toString();
            ShowResult(winner);
            return existWinner;
        }
        // 1, 4, 7 |
        else if(IsSame(frame[1].getText().toString(), frame[4].getText().toString(), frame[7].getText().toString())){
            String winner = frame[1].getText().toString();
            ShowResult(winner);
            return existWinner;
        }
        // 2, 5, 8 |
        else if(IsSame(frame[2].getText().toString(), frame[5].getText().toString(), frame[8].getText().toString())){
            String winner = frame[2].getText().toString();
            ShowResult(winner);
            return existWinner;
        }
        // 0, 4, 8 \
        else if(IsSame(frame[0].getText().toString(), frame[4].getText().toString(), frame[8].getText().toString())){
            String winner = frame[0].getText().toString();
            ShowResult(winner);
            return existWinner;
        }
        // 2, 4, 6 /
        else if(IsSame(frame[2].getText().toString(), frame[4].getText().toString(), frame[6].getText().toString())){
            String winner = frame[2].getText().toString();
            ShowResult(winner);
            return existWinner;
        }
        else{
            return !existWinner;
        }
    }

    private void ShowResult(String winner){
        txtResultado.setText(gana + winner);
        txtResultado.setVisibility(View.VISIBLE);
    }

    private Boolean IsSame( String f1, String f2, String f3){
        return (f1.equals(f2) && f2.equals(f3) && !f3.equals("-"));
    }
}