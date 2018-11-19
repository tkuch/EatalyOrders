package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_confirm);

        getSupportActionBar().setTitle("Reservation Confirmation");

        Resources res = getResources();

        Bundle extras = getIntent().getExtras();
        assert extras != null;

        //datePicker
        TextView date = findViewById(R.id.resDateConfirm);
        String temp = res.getString(R.string.datetext);
        date.setText(temp);
    }

    public void finish(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}