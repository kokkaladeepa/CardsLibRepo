package com.example.dreamworld.cardslibpoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;

import java.util.Calendar;

public class AddProductToRentPricing extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    ImageButton buttonDate;
    TextView dateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_to_rent_pricing);
        buttonDate = (ImageButton)findViewById(R.id.imageButtonCalender);
        dateTextView= (TextView) findViewById(R.id.textViewCalender);
        // Show a datepicker when the dateButton is clicked
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = com.borax12.materialdaterangepicker.date.DatePickerDialog.newInstance(
                        AddProductToRentPricing.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                //  dpd.setAutoHighlight(mAutoHighlight);
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth,int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        String date = "Tada!! My Product will be Available From "+dayOfMonth+"/"+(++monthOfYear)+"/"+year+" To "+dayOfMonthEnd+"/"+(++monthOfYearEnd)+"/"+yearEnd;
         dateTextView.setText(date);
        Toast.makeText(AddProductToRentPricing.this, "Selected Item: " + date, Toast.LENGTH_LONG).show();
    }
}
