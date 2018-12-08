package e.oguz.farmmanagementapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import e.oguz.farmmanagementapp.R;

public class Cock extends Fragment {

    String CHICKEN[] = {"Denizli Horoz","Mardinli Horoz","Mardinli Horoz","Hataylı Horoz","Mor Horoz","Lacivert Horoz"};
    String EGG[] = {"Kümes 1","Kümes 1","Kümes 5","Kümes 1","Kümes 2","Kümes 1"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cock_fragment, container, false);
        super.onCreate(savedInstanceState);
        ListView listView = view.findViewById(R.id.cockListView);

        Cock.CustomAdapter customAdapter = new Cock.CustomAdapter();

        listView.setAdapter(customAdapter);

        return view;
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