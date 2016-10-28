package rest;

import models.People;
import models.PeopleResults;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by User on 27/10/2016.
 */
public interface APIPlug
{

    @GET("people/{id}")
    Call<People> getPeople(@Path("id") String id);

}

