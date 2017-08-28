package com.rijo.chasedemoapp.ui.searchResultScreen.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rijo.chasedemoapp.R;
import com.rijo.chasedemoapp.data.domain.SearchResult;
import com.rijo.chasedemoapp.ui.detailsScreen.ResultDetailsActivity;

/**
 * Created by rijogeorge on 8/27/17.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder>{
    private SearchResult searchResult;
    Context context;
    activityCallback callback;

    public SearchResultAdapter(SearchResult searchResult,Context context,activityCallback callback) {
        this.searchResult = searchResult;
        this.context=context;
        this.callback=callback;
    }

    @Override
    public SearchResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.search_reslut_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SearchResultAdapter.ViewHolder holder, int position) {
        holder.artistNameText.setText(searchResult.getResults().get(position).getArtistName());
        holder.trackNmaeText.setText(searchResult.getResults().get(position).getTrackName());
        Glide.with(context)
                .load(searchResult.getResults().get(position).getArtworkUrl100())
                .into(holder.artWorkImageView);
        holder.trackPrice.setText(searchResult.getResults().get(position).getCurrency()+String.valueOf(searchResult.getResults().get(position).getTrackPrice()));
        holder.trackRentPrice.setText(searchResult.getResults().get(position).getCurrency()+String.valueOf(searchResult.getResults().get(position).getTrackRentalPrice()));
        holder.descriptionTextView.setText(searchResult.getResults().get(position).getShortDescription());
    }

    @Override
    public int getItemCount() {
        return searchResult.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView artistNameText,trackNmaeText,trackPrice,trackRentPrice,descriptionTextView;
        ImageView artWorkImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            artistNameText=(TextView)itemView.findViewById(R.id.artistNameText);
            trackNmaeText=(TextView) itemView.findViewById(R.id.trackNmaeText);
            artWorkImageView=(ImageView) itemView.findViewById(R.id.artWorkImageView);
            trackPrice=(TextView) itemView.findViewById(R.id.trackPrice);
            trackRentPrice=(TextView) itemView.findViewById(R.id.trackRentPrice);
            descriptionTextView=(TextView) itemView.findViewById(R.id.descriptionTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    callback.onTrackSelected(pos);
                }
            });
        }
    }

    public interface activityCallback{
        void onTrackSelected(int position);
    }
}
