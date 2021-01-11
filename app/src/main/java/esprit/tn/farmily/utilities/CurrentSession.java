package esprit.tn.farmily.utilities;



import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import esprit.tn.farmily.LoginrRegister.User;
import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.models.Post;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CurrentSession {

    public static User CurrentUser = new User();
    public static Post CurrentPost = new Post();
    public static String Token;





}
