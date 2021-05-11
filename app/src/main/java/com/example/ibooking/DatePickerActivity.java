package com.example.ibooking;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.ibooking.Common.Common;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class DatePickerActivity extends AppCompatActivity {
    private Button checkinbtn,checkoutbtn, confirmbtn;
    private TextView tvcheckin, tvcheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_datepicker);
        confirmbtn = findViewById(R.id.confirmbtn);
        checkinbtn= findViewById(R.id.checkinbtn);
        checkoutbtn= findViewById(R.id.checkoutbtn);
        tvcheckin = findViewById(R.id.tvcheckin);
        tvcheckout = findViewById(R.id.tvcheckout);

        MaterialDatePicker.Builder checkInBuilder = MaterialDatePicker.Builder.datePicker();
        checkInBuilder.setTitleText("Check in: Select a date");

        MaterialDatePicker materialDatePickerIn = checkInBuilder.build();
        checkinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePickerIn.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        materialDatePickerIn.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                tvcheckin.setText("Check In " + materialDatePickerIn.getHeaderText());
                Common.currentCheckin = materialDatePickerIn.getHeaderText(); }
        }
        );

        MaterialDatePicker.Builder checkOutBuilder = MaterialDatePicker.Builder.datePicker();
        checkOutBuilder.setTitleText("Check out: Select a date");

        MaterialDatePicker materialDatePickerOut = checkOutBuilder.build();
        checkoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePickerOut.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        materialDatePickerOut.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                tvcheckout.setText("Check Out " + materialDatePickerOut.getHeaderText());
                Common.currentCheckout = materialDatePickerOut.getHeaderText();
            }
        }
        );

        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DatePickerActivity.this , ConfirmActivity.class));
            }
        });
    }
}