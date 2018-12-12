package com.kmu.fortravel;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;

public class Prepare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare);

        final EditText editText = (EditText) findViewById(R.id.editText);
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        imageButton.setOnClickListener(new View.OnClickListener()   {
            @Override
            public void onClick (View v) {
                checkBox.setText(editText.getText());

            }
        });
    }






}
