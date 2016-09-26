package sample.bottombarwithviewpager.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.OnClick;
import sample.bottombarwithviewpager.R;

public class NavigationFragment extends Fragment implements View.OnClickListener {

    DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    //private NavigationDrawerAdapter adapter;
    private View containerView;
    private static String[] titles = null;
    private Spinner drawerSpinner;
    Fragment fragment=null;


    private Handler mHandler = new Handler();

    boolean spinnerState=true;
    @Bind(R.id.lay_dashboard)
    LinearLayout layHome;
    @Bind(R.id.lay_bottombar)
    LinearLayout layBottombar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sliding_fragment, container, false);
        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        layBottombar = (LinearLayout)view.findViewById(R.id.lay_bottombar);
        layHome = (LinearLayout)view.findViewById(R.id.lay_dashboard);
        layBottombar.setOnClickListener(this);
        layHome.setOnClickListener(this);
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }


    @OnClick(R.id.lay_bottombar)
    public void showBottombar(){

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP) {
            FragmentSample geofenceFragment = new FragmentSample();
            FragmentTransaction fmGeo = getFragmentManager().beginTransaction();
            fmGeo.addToBackStack(null);
            fmGeo.replace(R.id.container_body, geofenceFragment).commit();
        }
        mDrawerLayout.closeDrawers();
    }

   /* @OnClick(R.id.lay_bottombar)
    public void showDashboard(){

    }*/
    @Override
    public void onClick(View v) {

        Fragment fragment = new Fragment();

        switch (v.getId()) {

            case R.id.lay_dashboard:
                fragment = new HomeFragment();
                break;
            case R.id.lay_bottombar:
                fragment = new BottombarFragment();
                break;
           default:
               break;
        }
        getFragmentManager().beginTransaction().replace(R.id.container_body,fragment).commit();
        mDrawerLayout.closeDrawers();
    }



}
