package esprit.tn.farmily.Networking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import esprit.tn.farmily.LoginrRegister.User;
import esprit.tn.farmily.models.Comment;
import esprit.tn.farmily.models.Downvote;
import esprit.tn.farmily.models.Engineer;
import esprit.tn.farmily.models.Filedsmodel;
import esprit.tn.farmily.models.Hire;
import esprit.tn.farmily.models.Notification;
import esprit.tn.farmily.models.Location;
import esprit.tn.farmily.models.Post;
import esprit.tn.farmily.models.Upvote;
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

    @POST("api/field/addfield")
    Call<Filedsmodel> addFiled (@Body Filedsmodel filedsmodel);



    @POST("api/field/generateaddress/{Addresstxt}")
    Call<Location> loacate (@Path("Addresstxt") String Addresstxt);


    @POST("api/user/removeaccount/{username}")
    Call<User> remove (@Path("username") String username);

    @POST("api/field/deletefield/{id}")
    Call<Filedsmodel> delete (@Path("id") String id);

    @GET("api/field/showuserfields/{creator}")
    Call<ArrayList<Filedsmodel>> getuserFields (@Path("creator") String creator);


    @GET("api/post/allpostcomments/{postid}")
    Call<List<Comment>> getallPostcomment(@Path("postid") String postid);

    @GET("api/job//showallengineers/{role}")
    Call<List<Engineer>> showeng (@Path("role") String role);

    @GET("api/job/alldetails/{username}")
    Call<Engineer> detail (@Path("username") String role);

    @POST("api/job/hireengineer")
    Call<Hire> Hire (@Body Hire hire);

    @GET("api/job/hiredemployees/{employer}")
    Call<List<Hire>> Pending (@Path("employer") String role);

    @GET("api/job/Pendingjobs/{employee}")
    Call<List<Hire>> EngPending (@Path("employee") String role);

    @POST("api/job/StateEngineer/{id}")
    Call<Hire> acceptJob (@Path("id") String role);

    @Multipart
    @POST("api/profile/uploadpic")
    Call<String> uploadpic(@Part MultipartBody.Part file);

    @GET("api/post/countcomments/{postid}")
    Call<String> getnumberofposts(@Path("postid") String postid);

    @GET("api/post/allupvotes/{postid}")
    Call<String> getnumberofupvotes(@Path("postid") String postid);

    @GET("api/post/alldownvotes/{postid}")
    Call<String> getnumberofdownvotes(@Path("postid") String postid);

    @POST("api/post/addupvote/{postid}/{userupvote}")
    Call<Upvote> addupvote (@Path("postid") String postid, @Path("userupvote") String userupvote);

    @POST("api/post/adddownvote/{postid}/{userdownvote}")
    Call<Downvote> adddownvote (@Path("postid") String postid,@Path("userdownvote") String userdownvote);

    @POST("api/notification/addnotification")
    Call<Notification> addnotification (@Body Notification notification);

    @GET("api/notification//getallnotifications/{username}")
    Call<List<Notification>> mynotifications(@Path("username")String username);



}
