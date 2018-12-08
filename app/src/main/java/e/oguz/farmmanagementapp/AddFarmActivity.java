package e.oguz.farmmanagementapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import e.oguz.farmmanagementapp.Controller.FarmController;
import e.oguz.farmmanagementapp.Models.FarmModel;

public class AddFarmActivity extends AppCompatActivity {
    EditText farmNameEditText;
    EditText alanEditText;
    EditText locationEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_farm);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Çiflik Ekle");

        farmNameEditText = findViewById(R.id.farmNameEditText);
        alanEditText = findViewById(R.id.alanEditText);
        locationEditText = findViewById(R.id.locationEditText);

        Button saveButton = findViewById(R.id.addFarmButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String farmName = farmNameEditText.getText().toString();
                int alan = Integer.parseInt(alanEditText.getText().toString());
                String location = locationEditText.getText().toString();

                FarmModel farmModel = new FarmModel();
                farmModel.alan = alan;
                farmModel.farmName = farmName;
                farmModel.location = location;

                boolean createSuccessful = new FarmController(v.getContext()).create(farmModel);

                if(createSuccessful){
                    Toast.makeText(v.getContext(), "Çiftlik başarıyla eklendi.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), FarmActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(v.getContext(), "Çiftlik eklenemedi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    }


