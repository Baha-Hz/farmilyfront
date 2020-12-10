package esprit.tn.farmily;

import esprit.tn.farmily.entity.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    String API_ROUTE_Register = "register";

    @Headers({

            "Content-type: application/json"

    })
    @POST(API_ROUTE_Register)
    Call<User> sendUser(@Body User user);

    String API_ROUTE_Login = "login";
    @Headers({

            "Content-type: application/json"

    })
    @GET(API_ROUTE_Login)
    Call<User> LoginUser(@Query("username")String username,@Query("password")String password);

}
