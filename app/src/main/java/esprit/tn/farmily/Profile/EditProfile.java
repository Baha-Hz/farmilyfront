package esprit.tn.farmily.Profile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import esprit.tn.farmily.LoginrRegister.User;
import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.utilities.CurrentSession;
import esprit.tn.farmily.utilities.RealPathUtils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static esprit.tn.farmily.utilities.CurrentSession.CurrentUser;

public class EditProfile extends AppCompatActivity {


    private static final int READ_STORAGE_PERMISSION_REQUEST_CODE = 1;
    EditText full_name,password,email,phone;
    ImageView profileimage;
    TextView errorText;
    Button edit,getimage;
    String imageurl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_profile);
        edit = (Button) findViewById(R.id.button2);
        getimage = (Button) findViewById(R.id.getimage);




        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent home = new Intent(getApplicationContext(), profile.class);
                startActivity(home);
                overridePendingTransition(0, 0);
                home.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });

        getimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPermissionForReadExtertalStorage() == false) {
                    try {
                        requestPermissionForReadExtertalStorage();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                // PICK_IMAGE = 1
                startActivityForResult(Intent.createChooser(gallery, "Select Image"), 1);
            }
        });

        Button update = (Button) findViewById(R.id.confirm);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser(imageurl);

            }
        });

    }

    private void updateUser(String imageurl) {
        full_name = findViewById(R.id.fullnameiput);
        password = findViewById(R.id.passwordinput);
        email = findViewById(R.id.Emailinput);
        phone = findViewById(R.id.phoneinput);
        profileimage= findViewById(R.id.profileimage);

        Log.d("pathsizeby", imageurl);

        File image = new File(imageurl);
        RequestBody reqbody = RequestBody.create(MediaType.parse("multipart/form-data"),image);
        MultipartBody.Part part = MultipartBody.Part.createFormData("profilepicture", image.getName() , reqbody);

        Call<String> uploadCall = APIclient.apIinterface().uploadpic(part);
        uploadCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    User user = new User();
                    user.setUsername(CurrentUser.getUsername());
                    user.setFullname(full_name.getText().toString());
                    user.setEmail(email.getText().toString());
                    user.setPassword(password.getText().toString());
                    try{
                        user.setPhone((Integer.parseInt(phone.getText().toString())));
                    } catch(NumberFormatException ex){ // handle your exception
                        ex.printStackTrace();
                    }
                    user.setProfileimage(response.body());

                    // doing the call
                    Call<User> edit = APIclient.apIinterface().editProfile(user);
                    edit.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.isSuccessful()) {
                                Log.d("edit", String.valueOf(response.body().getUsername()));
                                Toast.makeText(EditProfile.this, "Successfully Changed!", Toast.LENGTH_LONG).show();
                                Intent goProfile = new Intent(EditProfile.this, profile.class);
                                startActivity(goProfile);
                                CurrentUser = response.body();
                            } else {
                                Log.d("edit", "unsucc response");
                                errorText.setVisibility(View.VISIBLE);
                                try {
                                    errorText.setText(response.errorBody().string());
                                } catch (IOException e) {
                                    Log.d("edit", "failed to string errorBody()");
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Log.d("editNet", t.toString());
                        }
                    });

                }else {
                    Log.d("uploadImageNet", "unsuc");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("uploadImageNet", t.toString());
            }
        });






    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK){
            Uri uri = data.getData();
            String path = null;
            if (Build.VERSION.SDK_INT < 11)
                path = RealPathUtils.getRealPathFromURI_BelowAPI11(getApplicationContext(), uri);

                // SDK >= 11 && SDK < 19
            else if (Build.VERSION.SDK_INT < 19)
                path = RealPathUtils.getRealPathFromURI_API11to18(getApplicationContext(), uri);

                // SDK > 19 (Android 4.4)
            else
                path = RealPathUtils.getRealPathFromURI_API19(getApplicationContext(), uri);
            Log.d("FILEPATHBRO", "File Path: " + path);
            // Get the file instance
            imageurl=path;
        }

    }

    public boolean checkPermissionForReadExtertalStorage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int result = getApplicationContext().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED;
        }
        return false;
    }

    public void requestPermissionForReadExtertalStorage() throws Exception {
        try {
            ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    READ_STORAGE_PERMISSION_REQUEST_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
