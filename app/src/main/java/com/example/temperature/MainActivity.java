package com.example.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText fahBox;
    private EditText celBox;
    private RadioButton ftocRadio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fahBox = findViewById(R.id.fahBox);
        celBox = findViewById(R.id.celBox);
        ftocRadio = findViewById(R.id.ftocRadio);
    }
    public void convert(View v){
        if (ftocRadio.isChecked()) {

            String input = fahBox.getText().toString();
            if (input.length()>0) {
                double fahValue = Double.parseDouble(input);
                double celValue = (fahValue - 32) * 5.0 / 9.0;
                celBox.setText(String.format("%.f", celValue));
            }else{
                Toast.makeText(this, "No fahrenheit value entered", Toast.LENGTH_SHORT).show();
            }
        }else{
            String input = celBox.getText().toString();
            if (input.length()>0) {
                double celValue = Double.parseDouble(input);
                double fahValue = 32 + (celValue * 9.0 / 5.0);
                fahBox.setText(String.format("%.f", fahValue));
            }else{
            Toast.makeText(this, "No fahrenheit value entered", Toast.LENGTH_SHORT).show();
        }
        }
    }
}
