package esprit.tn.farmily.Networking;

import java.util.List;

import esprit.tn.farmily.LoginrRegister.User;
import esprit.tn.farmily.models.Comment;
import esprit.tn.farmily.models.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIinterfacee {
    @POST("api/user/login")
    Call<User> loginUser(@Body User user);

    @POST("api/user/register")
    Call<User> registerUser(@Body User user);

    @POST("api/profile/uploadimage")
    Call<User> editProfile(@Body User user);

    @GET("api/post/allposts")
    Call<List<Post>> getallPosts();

    @POST("api/post/addpost")
    Call<Post> addpost (@Body Post post);

    @GET("api/post/allpostcomments")
    Call<List<Comment>> getallPostcomment();



}
