package e.oguz.farmmanagementapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

import e.oguz.farmmanagementapp.Fragment.Cock;

public class BarnsActivity extends AppCompatActivity {

    private TextView mTextMessage;
    ListView listView;

    String CHICKEN[] = {"Ahır","Mavi Ahır","Kara Ahır","Mor Ahır","Turuncu Ahır","Lacivert Ahır"};
    String EGG[] = {"Büyükbaş","Küçükbaş","Küçükbaş","Küçükbaş","Büyükbaş","Küçükbaş"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barns);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        listView = findViewById(R.id.barnsListView);

        BarnsActivity.CustomAdapter customAdapter = new BarnsActivity.CustomAdapter();

        listView.setAdapter(customAdapter);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;

            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.barns, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_coop) {
            Intent intent = new Intent(getApplicationContext(), AddCoopActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return CHICKEN.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.chicken_list, null);
            TextView chickenText = convertView.findViewById(R.id.textView2_name);
            TextView eggText = convertView.findViewById(R.id.alanTextView);
            ImageView image = convertView.findViewById(R.id.imageView2);

            image.setImageResource(R.drawable.ic_action_name);
            chickenText.setText(CHICKEN[position]);
            eggText.setText(EGG[position]);


            return convertView;
        }


    }


}
