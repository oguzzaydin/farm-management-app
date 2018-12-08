package e.oguz.farmmanagementapp.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashSet;

import e.oguz.farmmanagementapp.R;

public class Sheep  extends Fragment {
    private TextView mTextMessage;
    String CHICKEN[] = {"Sarı İnek","Mavi İnek","Kara İnek","Mor İnek","Turuncu İnek","Lacivert İnek"};
    String EGG[] = {"550 kg","550 kg","215 kg","874kg","214kg","556kg"};
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sheep, container, false);
        listView = view.findViewById(R.id.animalListView);
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("e.oguz.farmmanagementapp", Context.MODE_PRIVATE);
        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("notes", null);


        Sheep.CustomAdapter customAdapter = new Sheep.CustomAdapter();

        listView.setAdapter(customAdapter);
        return view;
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_navigation_coop);
                    return true;

            }
            return false;
        }
    };
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
