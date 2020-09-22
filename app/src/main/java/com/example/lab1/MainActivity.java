package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.sql.SQLOutput;
import java.util.zip.CheckedOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText addition;
    EditText multiply;
    TextView textView;
    TextView textView2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        addition = (EditText) findViewById(R.id.addition);
        multiply = (EditText) findViewById(R.id.multiply);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        btn = (Button) findViewById(R.id.button);

        String addText = addition.getText().toString();
        String mulText = multiply.getText().toString();

        if (addText.matches("") || mulText.matches("")) {
            Toast.makeText(getApplicationContext(), "Empty input", Toast.LENGTH_SHORT).show();
            textView.setText("First number: Error");
            textView2.setText("Second number: Error");
            return;
        }
        if (addText.matches("0") || mulText.matches("0")) {
            Toast.makeText(getApplicationContext(), "You can't input 0", Toast.LENGTH_SHORT).show();
            textView.setText("First number: Error");
            textView2.setText("Second number: Error");
            return;
        }
        int addNum = Integer.parseInt(addText);
        int mulNum = Integer.parseInt(mulText);

        // y^2 - y*sum + mul = 0

        double D = Math.pow(addNum, 2) - 4 * mulNum;
        double y1 = (addNum + Math.sqrt(D))/2;
        double y2 = (addNum - Math.sqrt(D))/2;
        double x1 = addNum - y1;
        double x2 = addNum - y2;
        if (y1 > 0 && y2 > 0 && x1 > 0 && x2 > 0
                && y1 % 1 == 0 && y2 % 1 == 0
                && x1 % 1 == 0 && x2 % 1 == 0) {
            int X1 = (int) x1;
            int X2 = (int) x2;
            int Y1 = (int) y1;
            int Y2 = (int) y2;
            textView.setText("First number: " + Integer.toString(X1) + " or " + Integer.toString(X2));
            textView2.setText("Second number: " + Integer.toString(Y1) + " or " + Integer.toString(Y2));
        } else {
            Toast.makeText(getApplicationContext(), "Incorrect input (Some number is not natural)", Toast.LENGTH_SHORT).show();
            textView.setText("First number: Error");
            textView2.setText("Second number: Error");
            return;
        }
    }
}