package esprit.tn.farmily.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;
import esprit.tn.farmily.LoginrRegister.login;
import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.messages.messages;
import esprit.tn.farmily.notification.notification;
import esprit.tn.farmily.utilities.CurrentSession;

public class profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textView;

    TextView phone,username,fullname,role,email;
    CircleImageView userimage,headerimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        phone = findViewById(R.id.phonephone);
        role = findViewById(R.id.rolerole);
        username = findViewById(R.id.Useruser);
        fullname = findViewById(R.id.fullnamefullname);
        email = findViewById(R.id.emailemail);
        userimage = findViewById(R.id.userimage);
        phone.setText(CurrentSession.CurrentUser.getPhone().toString());
        role.setText(CurrentSession.CurrentUser.getRole());
        username.setText(CurrentSession.CurrentUser.getUsername());
        fullname.setText(CurrentSession.CurrentUser.getFullname());
        email.setText(CurrentSession.CurrentUser.getEmail());

        drawerLayout=findViewById(R.id.drawer_layout);
        Glide.with(getApplicationContext())
                .load(APIclient.base_url+CurrentSession.CurrentUser.getProfileimage())
                .into(userimage);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TextView txtProfileName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.headeruser);
        txtProfileName.setText(CurrentSession.CurrentUser.getUsername());
        TextView txtRole = (TextView) navigationView.getHeaderView(0).findViewById(R.id.HeaderRole);
        txtRole.setText(CurrentSession.CurrentUser.getRole());

        navigationView=findViewById(R.id.nav_view);
        textView=findViewById(R.id.textView);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        headerimage=findViewById(R.id.headerimage);
        @SuppressLint("WrongViewCast") CircleImageView headerimage = (CircleImageView) navigationView.getHeaderView(0).findViewById(R.id.headerimage);
        Glide.with(getApplicationContext()).load(APIclient.base_url+CurrentSession.CurrentUser.getProfileimage()).into(headerimage);

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
                Intent intent = new Intent(profile.this, EditProfile.class);
                startActivity(intent);
                break;
            case R.id.nav_fileds:
                Intent fileds = new Intent(profile.this, showfileds.class);
                startActivity(fileds);
                break;
            case R.id.nav_Logout:
                Intent houni = new Intent(profile.this, login.class);
                startActivity(houni);
                break;
            case R.id.nav_hire:
                Intent show = new Intent(profile.this , Hire.class);
                startActivity(show);
            case R.id.nav_engineers:
                Intent open = new Intent(profile.this , Myengineer.class);
                startActivity(open);




        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}