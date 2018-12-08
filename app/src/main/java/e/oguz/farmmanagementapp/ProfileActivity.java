package e.oguz.farmmanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText nameEditText = findViewById(R.id.nameSurnameEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        EditText confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);

        nameEditText.setText("Oğuzhan Aydın");
        emailEditText.setText("oguzhanaydin56@gmail.com");
        passwordEditText.setText("123456");
        confirmPasswordEditText.setText("123456");
    }
}
