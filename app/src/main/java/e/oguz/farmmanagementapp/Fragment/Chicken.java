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

import e.oguz.farmmanagementapp.FarmActivity;
import e.oguz.farmmanagementapp.R;

public class Chicken extends Fragment {

    String CHICKEN[] = {"Sarı Tavuk","Mavi Tavuk","Kara Tavuk","Mor Tavuk","Turuncu Tavuk","Lacivert Tavuk"};
    String EGG[] = {"Kümse 1","Kümse 1","Kümse 1","Kümse 1","Kümse 1","Kümse 1"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chicken_fragment, container, false);
        super.onCreate(savedInstanceState);

        ListView listView = view.findViewById(R.id.chickenListView);

        Chicken.CustomAdapter customAdapter = new Chicken.CustomAdapter();

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

