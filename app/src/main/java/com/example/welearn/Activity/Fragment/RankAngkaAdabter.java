package com.example.welearn.Activity.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.welearn.Activity.SkorAngkaActivity;
import com.example.welearn.R;
import com.example.welearn.Response.Ranking.RankingAngka;

import java.util.ArrayList;
import java.util.List;

public class RankAngkaAdabter extends RecyclerView.Adapter<RankAngkaAdabter.ViewHolder> {
    private List<RankingAngka> mAngka;
    private LayoutInflater mInflater;
    private RankAngkaAdabter.ItemClickListener mClickListener;
    int id;

    // data is passed into the constructor
    public RankAngkaAdabter(Context context, List<RankingAngka> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mAngka = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public RankAngkaAdabter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.ranking_angka, parent, false);
        return new RankAngkaAdabter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankAngkaAdabter.ViewHolder holder, int position) {
        RankingAngka nomor = mAngka.get(position);
        holder.nomor.setText(String.valueOf(position+1));
        holder.user.setText(mAngka.get(position).getName());
        holder.total.setText(mAngka.get(position).getTotal());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mAngka.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomor, user, total;

        ViewHolder(View itemView) {
            super(itemView);
            nomor = itemView.findViewById(R.id.nomor);
            user = itemView.findViewById(R.id.user);
            total = itemView.findViewById(R.id.total);
        }

        // convenience method for getting data at click position
        RankingAngka getItem(int nomor) {
            return mAngka.get(nomor);
        }

    }

    // allows clicks events to be caught
    public void setClickListener(RankAngkaAdabter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
