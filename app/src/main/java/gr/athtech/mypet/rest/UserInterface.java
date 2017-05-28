package gr.athtech.mypet.rest;

import gr.athtech.mypet.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by xrist on 27/5/2017.
 */
public interface UserInterface {

    @GET("/user/{username}/{password}")
    Call<User> getUser(@Path("username") String username, @Query("password") String password);
}
