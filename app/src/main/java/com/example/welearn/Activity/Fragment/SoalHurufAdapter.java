package com.example.welearn.Activity.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.welearn.R;
import com.example.welearn.Response.Api.ResponseType.ListSoalHuruf;

import java.util.List;

public class SoalHurufAdapter extends RecyclerView.Adapter<SoalHurufAdapter.ViewHolder>{


    private List<ListSoalHuruf> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    int id;

    // data is passed into the constructor
    public SoalHurufAdapter(Context context, List<ListSoalHuruf> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.round_soal, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//
        ListSoalHuruf question = mData.get(position);
//        id = mData.get(getItem(int idSoal))
        holder.question.setText("Soal "+String.valueOf(position+1));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView question;

        ViewHolder(View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.question);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    ListSoalHuruf getItem(int idSoal) {
        return mData.get(idSoal);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }




}
