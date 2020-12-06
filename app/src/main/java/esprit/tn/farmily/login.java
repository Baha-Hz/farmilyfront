package esprit.tn.farmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.lang.Override;
import java.lang.Exception;
import com.google.android.material.textfield.TextInputLayout;
import esprit.tn.farmily.Retrofit.RetrofitInterface;
import esprit.tn.farmily.Retrofit.User;
import io.reactivex.Observable;
import  io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class login extends AppCompatActivity {


    TextInputLayout username,password;
    CompositeDisposable composite= new CompositeDisposable();
    RetrofitInterface retrofitInterface;

    @Override
    protected void onStop() {
        composite.clear();
        super.onStop();
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Retrofit user = User.getInstance();
        retrofitInterface = user.create(RetrofitInterface.class);

        username= (TextInputLayout)findViewById(R.id.textInputLayoutUsername);
        password= (TextInputLayout)findViewById(R.id.textInputLayoutPassword);


        Button gotoFeed = (Button)findViewById(R.id.toLoginButton);
        gotoFeed.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                loginUser(username.getEditText().getText().toString(), password.getEditText().getText().toString());
                Intent gotoFeedIntent = new Intent(getApplicationContext(), feed.class);
                startActivity(gotoFeedIntent);
                overridePendingTransition(0,0);
                gotoFeedIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });

    }
    private void loginUser(String username, String password){

       if (TextUtils.isEmpty(username)){
            Toast.makeText(this , "username cannot be empty",Toast.LENGTH_SHORT).show();}
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this , "password cannot be empty",Toast.LENGTH_SHORT).show();}
        composite.add(retrofitInterface.loginUser(username,password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("###############################################################################################");
            }
        }));
    }
}