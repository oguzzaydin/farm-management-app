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

public class BeeHiveActivity extends AppCompatActivity {

    private TextView mTextMessage;
    static ArrayList<String> beehive = new ArrayList<>();
    static ArrayAdapter arrayAdapter;
    ListView listView;


    String CHICKEN[] = {"SArı Kovan","Mavi Kovan","Kara Kovan","Mor Kovan","Turuncu Kovan","Lacivert Kovan"};
    String EGG[] = {"25kg bal kapasitesi","25kg bal kapasitesi","45kg bal kapasitesi","25kg bal kapasitesi","85kg bal kapasitesi","55kg bal kapasitesi"};

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bee_hive);
        getSupportActionBar().setHomeButtonEnabled(true);

        mTextMessage =  findViewById(R.id.message);
        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        listView = findViewById(R.id.beehiveListView);
        BeeHiveActivity.CustomAdapter customAdapter = new BeeHiveActivity.CustomAdapter();

        listView.setAdapter(customAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.beehive_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_beehive) {
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
