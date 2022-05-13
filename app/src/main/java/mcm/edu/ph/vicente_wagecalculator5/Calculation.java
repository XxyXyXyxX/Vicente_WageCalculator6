package mcm.edu.ph.vicente_wagecalculator5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculation extends AppCompatActivity implements View.OnClickListener {


        TextView textName;
        TextView textType;
        TextView textHours;
        TextView textRWage;
        TextView textTWage;
        TextView textOTWage;
        TextView textOTHours;
        String eType;
        String eName;
        Double eHours;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wagecalculation);


        textName = findViewById(R.id.employeeName);
        textType = findViewById(R.id.employeetype);
        textHours = findViewById(R.id.hrResult);
        textTWage = findViewById(R.id.twrResult);
        textRWage =findViewById(R.id.trwResult);
        textOTWage = findViewById(R.id.otResult);
        textOTHours = findViewById(R.id.txtovertimeHours);


         Button btnback = findViewById(R.id.btnBack);
         btnback.setOnClickListener(this);

        Intent i = getIntent();

         eType = i.getStringExtra("type");
         eName = i.getStringExtra("empName");
         eHours = i.getDoubleExtra("hours",0);


        textName.setText("Employee Name: " + eName);
        textType.setText("Employee Type: " + eType);
        textHours.setText(String.valueOf(eHours));
        calcWage(eType, eHours, textTWage, textRWage, textOTWage, textOTHours);



    }
    public void calcWage(String employeeType, Double employeeHours, TextView txtTotalWage, TextView txtRegularWage, TextView txtOTWage,TextView textOTHours) {
        double totalWage = 0.0;
        double totalOTWage = 0.0;

        switch (employeeType) {
            case "Regular":
                if (employeeHours > 8.0) {
                    textOTHours.setText(String.valueOf(eHours -8));
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 115) + 800;
                    totalOTWage = employeeHours * 115;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱800");
                    txtOTWage.setText("₱" + totalOTWage);
                } else {
                    totalWage = employeeHours * 100;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
            case "Part-Time":
                if (employeeHours > 8.0) {
                    textOTHours.setText(String.valueOf(eHours -8));
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 90) + 600;
                    totalOTWage = employeeHours * 90;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱600");
                    txtOTWage.setText("₱" + totalOTWage);
                } else {
                    totalWage = employeeHours * 75;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
            case "Probationary":
                if (employeeHours > 8.0) {
                    textOTHours.setText(String.valueOf(eHours -8));
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 100) + 720;
                    totalOTWage = employeeHours * 100;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱720");
                    txtOTWage.setText("₱" + totalOTWage);
                } else {
                    totalWage = employeeHours * 90;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
        }
    }







    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnBack) { //Send user back to Main Activity
            startActivity(new Intent(Calculation.this, MainActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}







