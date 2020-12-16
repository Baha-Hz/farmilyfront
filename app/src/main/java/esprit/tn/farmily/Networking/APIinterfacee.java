package esprit.tn.farmily.Networking;

import esprit.tn.farmily.LoginrRegister.User;
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


}
