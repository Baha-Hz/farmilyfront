package esprit.tn.farmily.Retrofit;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import  io.reactivex.Observable;

public interface RetrofitInterface {
    @POST("register")
    @FormUrlEncoded
    Observable<String> registerUser(@Field("fullname")String fullname,
                                    @Field("username")String username,
                                    @Field("email")String email,
                                    @Field("password")String password);


    @POST("login")
    @FormUrlEncoded
    Observable<String> loginUser(@Field("username")String username,
                                    @Field("password")String password);
}
