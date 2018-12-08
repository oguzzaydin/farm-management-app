package e.oguz.farmmanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailFarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_farm);

        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Çiftlik Detaylar");
    }
}
