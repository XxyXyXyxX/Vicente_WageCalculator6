package mcm.edu.ph.vicente_wagecalculator5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText employeeName, employeeHours;
    RadioGroup employeeType;
    RadioButton btnSelected;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        employeeName = findViewById(R.id.name);
        employeeHours =findViewById(R.id.Hours);

        employeeType = findViewById(R.id.employeeType);

        calculate = findViewById(R.id.button);

        calculate.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            int selectedEmployeeType = employeeType.getCheckedRadioButtonId();

            btnSelected = findViewById(selectedEmployeeType);

            String type = btnSelected.getText().toString();

            String name = employeeName.getText().toString();
            double totalHours = Double.parseDouble((employeeHours.getText().toString()));

            Intent intent = new Intent(this, Calculation.class);

            intent.putExtra("type", type);
            intent.putExtra("empName", name);
            intent.putExtra("hours", totalHours);
            startActivity(intent);
        }
    }}