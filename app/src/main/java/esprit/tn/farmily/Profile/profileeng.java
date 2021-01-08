package esprit.tn.farmily.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import esprit.tn.farmily.LoginrRegister.login;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.messages.messages;
import esprit.tn.farmily.notification.notification;
import esprit.tn.farmily.utilities.CurrentSession;

public class profileeng extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textView;

    TextView phone,username,fullname,role,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileeng);
        phone = findViewById(R.id.phonephone);
        role = findViewById(R.id.rolerole);
        username = findViewById(R.id.Useruser);
        fullname = findViewById(R.id.fullnamefullname);
        email = findViewById(R.id.emailemail);

        phone.setText(CurrentSession.CurrentUser.getPhone().toString());
        role.setText(CurrentSession.CurrentUser.getRole());
        username.setText(CurrentSession.CurrentUser.getUsername());
        fullname.setText(CurrentSession.CurrentUser.getFullname());
        email.setText(CurrentSession.CurrentUser.getEmail());

        drawerLayout=findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);
        TextView txtProfileName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.headeruser);
        txtProfileName.setText(CurrentSession.CurrentUser.getUsername());
        TextView txtRole = (TextView) navigationView.getHeaderView(0).findViewById(R.id.HeaderRole);
        txtRole.setText(CurrentSession.CurrentUser.getRole());

        navigationView=findViewById(R.id.nav_view2);
        textView=findViewById(R.id.textView);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new
                ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener( this);







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







    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
        switch (menuitem.getItemId()) {
                case R.id.nav_Editprofile:
                Intent intent = new Intent(profileeng.this, EditProfile.class);
                startActivity(intent);
                break;
            case R.id.nav_fileds:
                Intent fileds = new Intent(profileeng.this, showfileds.class);
                startActivity(fileds);
                break;
            case R.id.nav_Logout:
                Intent houni = new Intent(profileeng.this, login.class);
                startActivity(houni);
                break;
            case R.id.nav_hire_request:
                Intent show = new Intent(profileeng.this , HIre_req.class);
                startActivity(show);




        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}