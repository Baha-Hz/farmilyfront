package esprit.tn.farmily;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import esprit.tn.farmily.Profile.EditProfile;
import esprit.tn.farmily.Profile.fields_fragment;
import esprit.tn.farmily.Profile.info_fragment;
import esprit.tn.farmily.Profile.photos_fragment;

import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.messages.messages;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);


        Button edit = (Button) findViewById(R.id.EDITMenu);
        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent home = new Intent(getApplicationContext(), EditProfile.class);
                startActivity(home);
                overridePendingTransition(0, 0);
                home.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });

        Button home = (Button) findViewById(R.id.home_profile);
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent home = new Intent(getApplicationContext(), feed.class);
                startActivity(home);
                overridePendingTransition(0, 0);
                home.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });
        Button message = (Button) findViewById(R.id.message_profile);
        message.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent message= new Intent(getApplicationContext(), messages.class);
                startActivity(message);
                overridePendingTransition(0, 0);
                message.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });
        Button notif = (Button) findViewById(R.id.notif_profile);
        notif.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent notif= new Intent(getApplicationContext(), notification.class);
                startActivity(notif);
                overridePendingTransition(0, 0);
                notif.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.profil_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new fields_fragment()).commit();
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_filed:
                            selectedFragment = new fields_fragment();
                            break;
                        case R.id.nav_photos:
                            selectedFragment = new photos_fragment();
                            break;
                        case R.id.nav_info:
                            selectedFragment = new info_fragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;

                }


            };







}