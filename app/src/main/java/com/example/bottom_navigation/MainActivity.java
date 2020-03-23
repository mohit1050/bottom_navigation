package com.example.bottom_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private FavouritesFragment favouritesFragment;
    private NearbyFragment nearbyFragment;
    private RecentFragment recentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout)findViewById(R.id.main_frame);

        recentFragment = new RecentFragment();
        favouritesFragment = new FavouritesFragment();
        nearbyFragment = new NearbyFragment();

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.recent:
                        setFragment(recentFragment);
                        Toast.makeText(MainActivity.this,"recent",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.favourite:
                        setFragment(favouritesFragment);
                        Toast.makeText(MainActivity.this,"favourite",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nearby:
                        setFragment(nearbyFragment);
                        Toast.makeText(MainActivity.this,"nearyb",Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
}
