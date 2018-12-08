package e.oguz.farmmanagementapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import e.oguz.farmmanagementapp.Controller.FarmController;
import e.oguz.farmmanagementapp.Models.FarmModel;


public class FarmActivity extends AppCompatActivity {
    TextView locationTextView;
     int deleteItemId;
    private TextView mTextMessage;
    ListView listView;
    Intent intent;
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_farm) {
            Intent intent = new Intent(getApplicationContext(), AddFarmActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        listView = findViewById(R.id.FarmListView);

        CustomAdapter customAdapter = new CustomAdapter(this);

        registerForContextMenu(listView);


        listView.setAdapter(customAdapter);


        getSupportActionBar().setHomeButtonEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView.showContextMenuForChild(view);
                TextView locationTextView = view.findViewById(R.id.locationTextView);
                deleteItemId = Integer.parseInt(locationTextView.getTag().toString());

            }
        });


    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.farm_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                Context context = getApplicationContext();
                boolean deleteSuccessful = new FarmController(context).delete(deleteItemId);
                if (deleteSuccessful){
                    Toast.makeText(context, "Çiftlik başarıyla silindi.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Başarısız.", Toast.LENGTH_SHORT).show();
                }
                CustomAdapter customAdapter = new CustomAdapter(this);
                registerForContextMenu(listView);
                listView.setAdapter(customAdapter);
                return true;
            case R.id.edit:
                 intent = new Intent(getApplicationContext(), EditFarmActivity.class);
                 intent.putExtra("id", deleteItemId);
                startActivity(intent);
                return true;
            case R.id.details:
                 intent = new Intent(getApplicationContext(), DetailFarmActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public int countRecords() {
        int recordCount = new FarmController(this).count();
        return recordCount;
    }

    class CustomAdapter extends BaseAdapter {
       FarmModel[] farms;
        public CustomAdapter(Context context) {

           List<FarmModel> farmsList = new FarmController(context).read();
            farms = new FarmModel[farmsList.size()];
            farmsList.toArray(farms);
        }
        @Override
        public int getCount() {
            return countRecords();
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
            convertView = getLayoutInflater().inflate(R.layout.farmlistlayout, null);

            TextView farmNameText = convertView.findViewById(R.id.textView2_name);
            TextView alanTextView = convertView.findViewById(R.id.alanTextView);
            locationTextView = convertView.findViewById(R.id.locationTextView);



                    farmNameText.setText(farms[position].farmName);
                    alanTextView.setText(Integer.toString(farms[position].alan));
                    locationTextView.setText(farms[position].location);
                    locationTextView.setTag(Integer.toString(farms[position].id));

            return convertView;
        }
    }



}
