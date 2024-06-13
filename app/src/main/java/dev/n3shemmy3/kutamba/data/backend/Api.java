package dev.n3shemmy3.kutamba.data.backend;


import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.data.model.Receiver;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("/{media}/{provider}/{query}")
    Call<Receiver> fetchMedia(
            @Path("media") String media,
            @Path("provider") String provider,
            @Path("query") String query,
            @Query("page") int page
    );

    @GET("/{media}/{provider}/info/{id}")
    Call<MediaItem> fetchAnime(
            @Path("media") String media,
            @Path("provider") String provider,
            @Path("id") String id
    );

    @GET("/{media}/{provider}/info")
    Call<MediaItem> fetchMovie(
            @Path("media") String media,
            @Path("provider") String provider,
            @Query("id") String id
    );
}
