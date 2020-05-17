package com.example.healthmonitoringsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Карточка пациента";
    ArrayList<Patient> patientList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText user = findViewById(R.id.editUser);
        final EditText age = findViewById(R.id.editAge);

        Button buttonSave = findViewById(R.id.btnSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userPatient = user.getText().toString();
                String agePatient = age.getText().toString();

                if (userPatient.isEmpty() || agePatient.isEmpty()) {
// выводим сообщение "Введены не все данные"
                    Toast.makeText(MainActivity.this, getString(R.string.notEnoughData), Toast.LENGTH_LONG).show();
                    return;
                }
                int ageOfPatient;
                try {
                    ageOfPatient = Integer.parseInt(agePatient);
                } catch (Exception ex) {
// выводим сообщение "Неверный формат" и сообщение в лог "Введены не корректные данные"
                    Toast.makeText(MainActivity.this, getString(R.string.incorrectFormat), Toast.LENGTH_LONG).show();
                    Log.i(TAG, "Введены не корректные данные");
                    return;
                }
                Patient card = new Patient(userPatient, ageOfPatient);
                patientList.add(card);
// выводим сообщение "Сохранена карточка пациента: XXXXXXX"
                Toast.makeText(MainActivity.this, getString(R.string.cardSaved) + " " + userPatient, Toast.LENGTH_LONG).show();
            }
        });
        Button btnIndicator = findViewById(R.id.btnIndicator);
        btnIndicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IndicatorActivity.class);
                startActivity(intent);
            }
        });
        Button btnPressure = findViewById(R.id.btnPressure);
        btnPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });
    }
}