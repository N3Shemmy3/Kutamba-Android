package dev.n3shemmy3.kutamba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
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

public class AnimeAdapter extends RecyclerView.Adapter<AnimeViewHolder> {

    private Context context;
    private ArrayList<Anime> animes;
    private OnAnimeItemClickListener onAnimeItemClickListener;

    public AnimeAdapter(Context context, ArrayList<Anime> animes, OnAnimeItemClickListener onAnimeItemClickListener) {
        this.context = context;
        this.animes = animes;
        this.onAnimeItemClickListener = onAnimeItemClickListener;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime_card, parent, false);
        return new AnimeViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Anime anime = animes.get(position);

        // Glide.with(context).load(anime.getUrl()).into(holder.itemImg);
        holder.itemTitle.setText(anime.getTitle());

        // Set an onClickListener for the item view
        holder.itemView.setOnClickListener(view -> {
            if (onAnimeItemClickListener != null) {
                onAnimeItemClickListener.onItemClick(anime);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public void setAll(ArrayList<Anime> animes) {
        this.animes = animes;
        notifyDataSetChanged(); // Notify adapter about data change
    }

    // Interface for item click listener
    public interface OnAnimeItemClickListener {
        void onItemClick(Anime anime);
    }
}
