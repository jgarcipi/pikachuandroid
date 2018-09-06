package com.jj.pikachu.Views.saveGame;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jj.pikachu.R;
import com.jj.pikachu.entities.Game;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by imac2 on 5/09/18.
 */

public class SaveGameAdapter extends RecyclerView.Adapter<SaveGameAdapter.OfficeViewHolder> {

    private final Context context;
    private final LayoutInflater layoutInflater;

    private List<Game> gamesList;

    @Inject
    public SaveGameAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.gamesList = Collections.emptyList();
    }

    public void setGamesList(@NonNull List<Game> gamesList) {
        this.gamesList = gamesList;

        this.notifyDataSetChanged();
    }


    @NonNull
    @Override
    public OfficeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_game_item, parent, false);
        return new OfficeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfficeViewHolder holder, int position) {

        final Game game = this.gamesList.get(position);
        holder.carTitle.setText(game.getName());
        holder.carDescription.setText(game.getDescription());

    }

    @Override
    public int getItemCount() {
        return gamesList != null ? gamesList.size() : 0;
    }


    public class OfficeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.car_title)
        TextView carTitle;

        @BindView(R.id.car_description)
        TextView carDescription;

        private RecyclerView.LayoutManager layoutManager;


        public OfficeViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
