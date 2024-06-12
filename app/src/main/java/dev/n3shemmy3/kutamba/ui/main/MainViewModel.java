package dev.n3shemmy3.kutamba.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import dev.n3shemmy3.kutamba.data.backend.Api;
import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.data.model.Reciever;
import dev.n3shemmy3.kutamba.data.model.Scraper;
import dev.n3shemmy3.kutamba.ui.util.Prefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends AndroidViewModel {
    private Retrofit retrofit;
    private Api apiService;

    private MutableLiveData<ArrayList<MediaItem>> anime = new MutableLiveData<>();
    private MutableLiveData<ArrayList<MediaItem>> movies = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
        onCreate();
    }


    public void onCreate() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Prefs.getString(
                        "repository",
                        "https://api-consumet-org-zeta.vercel.app/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(Api.class);
    }

    public void getLatestMedia(Scraper scraper) {
        ArrayList<MediaItem> results = new ArrayList<>();
        Call<Reciever> call = apiService.fetchMedia(
                scraper.getMedia(),
                scraper.getProvider(),
                scraper.getQuery(),
                scraper.getPage()
        );
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<Reciever> call, @NonNull Response<Reciever> response) {
                if (response.isSuccessful() && response.body() != null)
                    results.addAll(response.body().getResults());
            }

            @Override
            public void onFailure(@NonNull Call<Reciever> call, @NonNull Throwable throwable) {

            }
        });
        Scraper.MediaType value = Scraper.MediaType.values()[scraper.getType().ordinal()];
        switch (value) {
            case Anime -> anime.postValue(results);
            case Movies -> movies.postValue(results);
        }
    }
}
