package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class PickupOrder extends AppCompatActivity {
    Spinner spinnerH, spinnerM;
    EditText editName, editPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_order);

        getSupportActionBar().setTitle("Pickup Order");

        editName = findViewById(R.id.nameDEditText);
        editPhone = findViewById(R.id.pnDEditText);

        spinnerH = findViewById(R.id.hourPickup);
        ArrayAdapter<CharSequence> adapterH = ArrayAdapter.createFromResource(this, R.array.hour, android.R.layout.simple_spinner_item);
        adapterH.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerH.setAdapter(adapterH);

        spinnerM = findViewById(R.id.minutesPickup);
        ArrayAdapter<CharSequence> adapterM = ArrayAdapter.createFromResource(this, R.array.minutes, android.R.layout.simple_spinner_item);
        adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerM.setAdapter(adapterM);

    }

    public void menuButton(View view){
        finish();
    }

    public void continueButton(View view){
        int pnLength = editPhone.getText().toString().length();
        if((pnLength < 10) || (pnLength > 10)){
            Toast.makeText(this, "Invalid phone number.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(editName.getText().toString().length() < 1){
            Toast.makeText(this, "Invalid name.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, OrderSummary.class);
        intent.putExtra("name_pickup", editName.getText().toString());
        intent.putExtra("phone_number_pickup", editPhone.getText().toString());
        intent.putExtra("hour_pickup", spinnerH.getSelectedItem().toString());
        intent.putExtra("minutes_pickup", spinnerM.getSelectedItem().toString());

        spinnerH.setSelection(0);
        spinnerM.setSelection(0);

        startActivity(intent);
    }
}