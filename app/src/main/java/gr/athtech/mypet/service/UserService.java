package gr.athtech.mypet.service;

import gr.athtech.mypet.model.User;
import gr.athtech.mypet.rest.UserInterface;
import retrofit2.Call;

/**
 * Created by xrist on 10/5/2017.
 */

public class UserService {

    public void getUser(String username, String password) {
        UserInterface userInterface =
                ApiClient.getClient().create(UserInterface.class);

        Call<User> call = userInterface.getUser(username, password);
    }
}
