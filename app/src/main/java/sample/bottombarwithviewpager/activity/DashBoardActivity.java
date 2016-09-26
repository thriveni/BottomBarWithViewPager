package sample.bottombarwithviewpager.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import sample.bottombarwithviewpager.R;
import sample.bottombarwithviewpager.fragments.HomeFragment;
import sample.bottombarwithviewpager.fragments.NavigationFragment;


public class DashBoardActivity extends AppCompatActivity {
    public DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationFragment navigationFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
        setupToolbar();
        mDrawerLayout = (DrawerLayout)findViewById(R.id.nv_drawer);
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.container_body);
        navigationFragment =(NavigationFragment)getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        navigationFragment.setUp(R.id.fragment_navigation_drawer,(DrawerLayout)findViewById(R.id.nv_drawer),toolbar);
        initilizeView();

    }

    private void setupToolbar() {

        toolbar = (Toolbar)findViewById(R.id.toolbar_dashboard);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("toolbar","click");
                Toast.makeText(getApplicationContext(),"toolbar", Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void initilizeView() {

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_body, homeFragment);
        fragmentTransaction.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        initilizeView();
        //onResume();
    }
}
