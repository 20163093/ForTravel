package com.kmu.fortravel;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class Expense extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

        for(int count = 0; count < 3; count++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams((new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT)));

            EditText dateET = (EditText)findViewById(R.id.date);
            EditText objectEt = (EditText)findViewById(R.id.object);
            EditText expenseET = (EditText)findViewById(R.id.expense);
            EditText sumET = (EditText)findViewById(R.id.sum);

        }

    }

}
