package com.example.forminput;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DataInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker datePicker = (DatePicker) findViewById(R.id.dobInput);
        datePicker.init(2000, 0, 13, null);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(view -> {
            displayNextAlert();
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void displayNextAlert() {
        EditText nameInput = (EditText) findViewById(R.id.nameInput);
        EditText emailInput = (EditText) findViewById(R.id.emailInput);
        DatePicker datePicker = (DatePicker) findViewById(R.id.dobInput);
        String strName = nameInput.getText().toString();
        String strEmail = emailInput.getText().toString();
        String strDOB = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + (datePicker.getYear());

        new AlertDialog.Builder(this)
                .setTitle("Details Entered")
                .setMessage(String.format("Details entered are:\n%s\n%s\n%s", strName, strDOB, strEmail))
                .setNeutralButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do nothing for now.
                    }
                }).show();
    }
}