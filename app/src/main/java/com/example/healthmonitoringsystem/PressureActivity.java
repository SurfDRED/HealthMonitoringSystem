package com.example.healthmonitoringsystem;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class PressureActivity extends AppCompatActivity {
    private static final String TAG = "Индивидуальные показатели";
    ArrayList<Pressure> pressureList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        final EditText patientUpperPressure = findViewById(R.id.editUpperPressure);
        final EditText patientLowerPressure = findViewById(R.id.editLowerPressure);
        final EditText patientPulse = findViewById(R.id.editPuls);
        final CheckBox patientTachycardia = findViewById(R.id.chkTachycardia);
        final TextView textDataTime = findViewById(R.id.textDataTime);
        SimpleDateFormat dateActual = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        SimpleDateFormat timeActual = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String date = dateActual.format(Calendar.getInstance().getTime());
        String time = timeActual.format(Calendar.getInstance().getTime());
        textDataTime.setText("Дата: " + date + " Время: " + time);

        Button buttonSavePressure = findViewById(R.id.btnSavePressure);
        buttonSavePressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upperPressure = patientUpperPressure.getText().toString();
                String lowerPressure = patientLowerPressure.getText().toString();
                String pulse = patientPulse.getText().toString();
                boolean tachycardia = patientTachycardia.isChecked();
                String dataTime = textDataTime.getText().toString();

                if (upperPressure.isEmpty() || lowerPressure.isEmpty() || pulse.isEmpty()) {
// выводим сообщение "Введены не все данные"
                    Toast.makeText(PressureActivity.this, getString(R.string.notEnoughData), Toast.LENGTH_LONG).show();
                    return;
                }
                int upperOfPressure;
                int lowerOfPressure;
                int pulseOf;
                try {
                    upperOfPressure = Integer.parseInt(upperPressure);
                    lowerOfPressure = Integer.parseInt(lowerPressure);
                    pulseOf = Integer.parseInt(pulse);
                } catch (Exception ex) {
// выводим сообщение "Неверный формат" и сообщение в лог "Введены не корректные данные"
                    Toast.makeText(PressureActivity.this, getString(R.string.incorrectFormat), Toast.LENGTH_LONG).show();
                    Log.i(TAG, "Введены не корректные данные");
                    return;
                }
                Pressure pressure = new Pressure(upperOfPressure, lowerOfPressure, pulseOf, dataTime, tachycardia);
                pressureList.add(pressure);
// выводим сообщение "Данные пациента сохранены"
                Toast.makeText(PressureActivity.this, getString(R.string.Saved), Toast.LENGTH_LONG).show();
            }
        });
    }
}