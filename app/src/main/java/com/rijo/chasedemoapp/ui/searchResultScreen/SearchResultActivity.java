package com.rijo.chasedemoapp.ui.searchResultScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rijo.chasedemoapp.R;
import com.rijo.chasedemoapp.data.domain.SearchResult;
import com.rijo.chasedemoapp.ui.detailsScreen.ResultDetailsActivity;
import com.rijo.chasedemoapp.ui.searchScreen.SearchActivity;
import com.rijo.chasedemoapp.ui.searchResultScreen.adapter.SearchResultAdapter;


public class SearchResultActivity extends AppCompatActivity implements SearchResultContract.View, SearchResultAdapter.activityCallback{

    public static final String ARTIST_KEY="com.rijo.chasedemoapp.ui.searchResultScreen.artistNameKey";
    public static final String SONG_KEY="com.rijo.chasedemoapp.ui.searchResultScreen.songKey";
    SearchResult searchResult=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        searchResult=getIntent().getParcelableExtra(SearchActivity.SEARCH_RESULT_KEY);
        RecyclerView resultRecyclerView = (RecyclerView) findViewById(R.id.searchResultView);
        resultRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        resultRecyclerView.setLayoutManager(mLayoutManager);
        SearchResultAdapter resultAdapter=new SearchResultAdapter(searchResult,this,this);
        resultRecyclerView.setAdapter(resultAdapter);
    }

    @Override
    public void onTrackSelected(int position) {
        Intent intent=new Intent(this, ResultDetailsActivity.class);
        intent.putExtra(ARTIST_KEY,searchResult.getResults().get(position).getArtistName());
        intent.putExtra(SONG_KEY,searchResult.getResults().get(position).getTrackName());
        startActivity(intent);
    }
}
