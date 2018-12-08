

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

public class EditFarmActivity extends AppCompatActivity {
  int updateId;
    FarmController farmController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_farm);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Çifliği Düzenle");

        Intent intent = getIntent();
        updateId = intent.getIntExtra("id", -1);


        farmController = new FarmController(this);
        FarmModel objectFarm = farmController.readSingleRecord(updateId);


        Button updateButton = findViewById(R.id.updateFarmButton);
        EditText farmNameEditText = findViewById(R.id.farmNameUpdateEditText);
        EditText alanEditText = findViewById(R.id.alanUpdateEditText);
        EditText locationEditText = findViewById(R.id.locationUpdateEditText);

        farmNameEditText.setText(objectFarm.farmName);
        alanEditText.setText(Integer.toString(objectFarm.alan));
        locationEditText.setText(objectFarm.location);


        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final  EditText farmNameEditText = findViewById(R.id.farmNameUpdateEditText);
                final  EditText alanEditText = findViewById(R.id.alanUpdateEditText);
                final  EditText locationEditText = findViewById(R.id.locationUpdateEditText);

                FarmModel farmModel = new FarmModel();
                farmModel.farmName = farmNameEditText.getText().toString();
                farmModel.alan = Integer.parseInt(alanEditText.getText().toString());
                farmModel.location = locationEditText.getText().toString();
                farmModel.id = updateId;



                boolean updateSuccessful = farmController.update(farmModel);

                if(updateSuccessful){
                    Toast.makeText(view.getContext(), "Başarıyla güncellendi.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), FarmActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(view.getContext(), "Başarısız", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }




}
