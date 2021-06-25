package com.example.welearn.Activity.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.welearn.R;
import com.example.welearn.Response.Api.ResponseType.ListSoalHuruf;
import com.example.welearn.Response.Ranking.RankingHuruf;

import java.util.List;

public class RankHurufAdabter extends RecyclerView.Adapter<RankHurufAdabter.ViewHolder> {

    private List<RankingHuruf> mData;
    private LayoutInflater mInflater;
    private RankHurufAdabter.ItemClickListener mClickListener;
    int id;

    // data is passed into the constructor
    public RankHurufAdabter(Context context, List<RankingHuruf> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public RankHurufAdabter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.ranking_huruf, parent, false);
        return new RankHurufAdabter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RankingHuruf nomor = mData.get(position);
        holder.nomor.setText(String.valueOf(position+1));
        holder.user.setText(mData.get(position).getName());
        holder.total.setText(mData.get(position).getTotal());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
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
        RankingHuruf getItem(int nomor) {
            return mData.get(nomor);
        }

    }

    // allows clicks events to be caught
    public void setClickListener(RankHurufAdabter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
