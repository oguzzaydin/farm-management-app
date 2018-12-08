package e.oguz.farmmanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SendMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_me);
        setTitle("Bize Ulaşın");
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
