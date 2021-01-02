package esprit.tn.farmily.Networking;

import java.util.List;

import esprit.tn.farmily.LoginrRegister.User;
import esprit.tn.farmily.models.Comment;
import esprit.tn.farmily.models.Engineer;
import esprit.tn.farmily.models.Hire;
import esprit.tn.farmily.models.Post;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIinterfacee {
    @POST("api/user/login")
    Call<User> loginUser(@Body User user);

    @POST("api/user/register")
    Call<User> registerUser(@Body User user);

    @POST("api/profile/updateuser")
    Call<User> editProfile(@Body User user);

    @GET("api/post/allposts")
    Call<List<Post>> getallPosts();

    @POST("api/post/addpost")
    Call<Post> addpost (@Body Post post);

    @POST("api/post/addcomment")
    Call<Comment> addcomment (@Body Comment comment);

    @GET("api/post/allpostcomments/{postid}")
    Call<List<Comment>> getallPostcomment(@Path("postid") String postid);

    @GET("api/job//showallengineers/{role}")
    Call<List<Engineer>> showeng (@Path("role") String role);

    @GET("api/job/alldetails/{username}")
    Call<Engineer> detail (@Path("username") String role);

    @POST("api/job/hireengineer")
    Call<Hire> Hire (@Body Hire hire);

    @GET("/api/job//hiredemployees/{employer}")
    Call<List<Hire>> Pending (@Path("employer") String role);

    @Multipart
    @POST("api/profile/uploadpic")
    Call<String> uploadpic(@Part MultipartBody.Part file);



}
