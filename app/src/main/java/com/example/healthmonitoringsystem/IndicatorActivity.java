package com.example.healthmonitoringsystem;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class IndicatorActivity extends AppCompatActivity {
    private static final String TAG = "Жизненные показатели";
    ArrayList<Indicators> IndicatorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator);
        final EditText Weight = findViewById(R.id.editWeight);
        final EditText Steps = findViewById(R.id.editSteps);

        Button buttonSaveIndicator = findViewById(R.id.btnSaveIndicator);
        buttonSaveIndicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String WeightPatient = Weight.getText().toString();
                String StepsPatient = Steps.getText().toString();
                if ((WeightPatient.length() == 0) || (StepsPatient.length() == 0)) {
// выводим сообщение "Введены не все данные"
                    Toast.makeText(IndicatorActivity.this, getString(R.string.notEnoughData), Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    Integer.parseInt(WeightPatient);
                    Integer.parseInt(StepsPatient);
                } catch (Exception ex) {
// выводим сообщение "Неверный формат" и сообщение в лог "Введены не корректные данные"
                    Toast.makeText(IndicatorActivity.this, getString(R.string.incorrectFormat), Toast.LENGTH_LONG).show();
                    Log.i(TAG, "Введены не корректные данные");
                    return;
                }
                Indicators indicators = new Indicators(Integer.parseInt(WeightPatient), Integer.parseInt(StepsPatient));
                IndicatorList.add(indicators);
// выводим сообщение "Данные пациента сохранены"
                Toast.makeText(IndicatorActivity.this, getString(R.string.Saved), Toast.LENGTH_LONG).show();
            }
        });
    }
}