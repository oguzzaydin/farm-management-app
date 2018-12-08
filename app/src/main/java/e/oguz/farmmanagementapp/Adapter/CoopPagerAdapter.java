package e.oguz.farmmanagementapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import e.oguz.farmmanagementapp.Fragment.Chicken;
import e.oguz.farmmanagementapp.Fragment.Cock;
import e.oguz.farmmanagementapp.Fragment.Coop;
import e.oguz.farmmanagementapp.Fragment.Duck;

public class CoopPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public CoopPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Coop tab4 = new Coop();
                return tab4;
            case 1:
                Chicken tab1 = new Chicken();
                return tab1;
            case 2:
                Cock tab2 = new Cock();
                return tab2;
            case 3:
                Duck tab3 = new Duck();
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
