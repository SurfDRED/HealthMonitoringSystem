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
    ArrayList<Pressure> PressureList = new ArrayList<>();

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
                String UpperPressure = patientUpperPressure.getText().toString();
                String LowerPressure = patientLowerPressure.getText().toString();
                String Pulse = patientPulse.getText().toString();
                boolean Tachycardia = patientTachycardia.isChecked();
                String DataTime = textDataTime.getText().toString();

                if ((UpperPressure.length() == 0) || (LowerPressure.length() == 0) || (Pulse.length() == 0)) {
// выводим сообщение "Введены не все данные"
                    Toast.makeText(PressureActivity.this, getString(R.string.notEnoughData), Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    Integer.parseInt(UpperPressure);
                    Integer.parseInt(LowerPressure);
                    Integer.parseInt(Pulse);
                } catch (Exception ex) {
// выводим сообщение "Неверный формат" и сообщение в лог "Введены не корректные данные"
                    Toast.makeText(PressureActivity.this, getString(R.string.incorrectFormat), Toast.LENGTH_LONG).show();
                    Log.i(TAG, "Введены не корректные данные");
                    return;
                }
                Pressure pressure = new Pressure(Integer.parseInt(UpperPressure), Integer.parseInt(LowerPressure), Integer.parseInt(Pulse),DataTime, Tachycardia);
                PressureList.add(pressure);
// выводим сообщение "Данные пациента сохранены"
                Toast.makeText(PressureActivity.this, getString(R.string.Saved), Toast.LENGTH_LONG).show();
            }
        });
    }
}
