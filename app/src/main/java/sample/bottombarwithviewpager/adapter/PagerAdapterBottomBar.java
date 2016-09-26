package sample.bottombarwithviewpager.adapter;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.util.Log;

import sample.bottombarwithviewpager.fragments.FragmentSample;

public class PagerAdapterBottomBar extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapterBottomBar(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentSample tab1 = new FragmentSample();
                Log.i("position", "" + position);
                return tab1;
            case 1:
                FragmentSample tab2 = new FragmentSample();
                Log.i("position", "" + position);
                return tab2;
            case 2:
                FragmentSample tab3 = new FragmentSample();
                Log.i("position", "" + position);
                return tab3;
            case 3:
                FragmentSample tab4 = new FragmentSample();
                Log.i("position", "" + position);
                return tab4;
            case 4:
                FragmentSample tab5 = new FragmentSample();
                Log.i("position", "" + position);
                return tab5;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        Log.d("Number", "Number : " + mNumOfTabs);
        return mNumOfTabs;
    }


}
