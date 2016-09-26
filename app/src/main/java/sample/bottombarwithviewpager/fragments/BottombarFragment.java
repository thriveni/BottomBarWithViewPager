package sample.bottombarwithviewpager.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabClickListener;

import sample.bottombarwithviewpager.R;
import sample.bottombarwithviewpager.adapter.PagerAdapterBottomBar;

public class BottombarFragment extends Fragment {

    private PagerAdapterBottomBar adapter;
    BottomBar mBottomBar;
    ViewPager viewPager;
    String chartType;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       /* Bundle bundle = getArguments();
        chartType = bundle.getString("chartType");
        Log.i("MileageChartFragment arguments",""+chartType);*/
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bottombar,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        includeBottombar(view ,savedInstanceState);
      //  Utils.defaultTabpostion(chartType,mBottomBar);
    }
    private void includeBottombar(View view, Bundle savedInstanceState) {

        mBottomBar = BottomBar.attachShy((CoordinatorLayout)view.findViewById(R.id.myCoordinator),
                view.findViewById(R.id.lay_vw_mileage), savedInstanceState);
        viewPager =(ViewPager)view.findViewById(R.id.vwpager);
        mBottomBar.setItems(R.menu.bottombar_menu);
        mBottomBar.setHorizontalScrollBarEnabled(true);
        adapter = new PagerAdapterBottomBar(getFragmentManager(), 3);
        viewPager.setAdapter(adapter);
        //viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                mBottomBar.selectTabAtPosition(position, true);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

                Log.e("TAB count", "positon of bootmbar"+mBottomBar.getCurrentTabPosition());
            }
        });

        mBottomBar.setOnTabClickListener(new OnTabClickListener() {
            @Override
            public void onTabSelected(int position) {

                viewPager.setCurrentItem(mBottomBar.getCurrentTabPosition());
            }

            @Override
            public void onTabReSelected(int position) {
                viewPager.setCurrentItem(mBottomBar.getCurrentTabPosition());
            }
        });

        mBottomBar.mapColorForTab(0, "#800000");
        mBottomBar.mapColorForTab(1, 0xFF5D4037);
        mBottomBar.mapColorForTab(2, "#00008B");
        mBottomBar.mapColorForTab(3, "#008000");
        mBottomBar.mapColorForTab(4, "#DC143C");
    }


}
