package com.example.androidassignment;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText firstInput = (EditText) findViewById(R.id.firstInput);
        final EditText indexInput = (EditText) findViewById(R.id.indexInput);
        final TextView output = (TextView) findViewById(R.id.output);
        final Button cta = (Button) findViewById(R.id.cta);


        cta.setOnClickListener(view -> {
            Suffix suff = null;
            String indexInputS = indexInput.getText().toString();
            int indexInputVal;

            try{
                indexInputVal = parseInt(indexInputS);
            } catch(NumberFormatException e) {
                output.setText(R.string.nanerror);
                return;
            }

            try {
                suff = new Suffix(firstInput.getText().toString(),parseInt(indexInput.getText().toString()));
            } catch (IllegalArgumentException e) {
                output.setText(e.getMessage());
                return;
            }


            try {
                output.setText(getString(R.string.output) + " " + suff.suffix());
            } catch (IllegalArgumentException e) {
                output.setText(e.getMessage());
                return;
            }

        });
    }
}