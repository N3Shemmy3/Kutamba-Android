package dev.n3shemmy3.kutamba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import dev.n3shemmy3.kutamba.model.Anime;
import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.viewholder.AnimeViewHolder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeViewHolder>{
    
    private Context context;
    private ArrayList<Anime> animes;
    
    public AnimeAdapter(Context context, ArrayList<Anime> animes) {
        this.context = context;
        this.animes = animes;
    }
    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnimeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime_card,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Anime anime = animes.get(position);
        //Glide.with(context).load(anime.getUrl()).into(holder.itemImg);
        holder.itemTitle.setText(anime.getTitle());
    }

    @Override
    public int getItemCount() {
        return animes.size() > 0? animes.size() : 0;
    }

    public void getAll(ArrayList<Anime> animes) {
        this.animes=animes;
    }

}
