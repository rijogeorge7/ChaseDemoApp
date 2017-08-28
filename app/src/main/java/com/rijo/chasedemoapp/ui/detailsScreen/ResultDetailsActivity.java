package com.rijo.chasedemoapp.ui.detailsScreen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.rijo.chasedemoapp.R;
import com.rijo.chasedemoapp.data.DataRepositoryImpl;
import com.rijo.chasedemoapp.data.domain.Song;
import com.rijo.chasedemoapp.ui.searchResultScreen.SearchResultActivity;
import com.rijo.chasedemoapp.ui.searchScreen.SearchActivityPresenter;

/**
 * Created by rijogeorge on 8/28/17.
 */

public class ResultDetailsActivity extends Activity implements ResultDetailsContract.View {

    TextView artistName,songName,urlTextView,lyricsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resut_details);
        artistName=(TextView)findViewById(R.id.artistName);
        songName=(TextView)findViewById(R.id.songName);
        urlTextView=(TextView)findViewById(R.id.urlTextView);
        lyricsText=(TextView)findViewById(R.id.lyricsText);
        DataRepositoryImpl repositoryImpl=new DataRepositoryImpl();
        String artistName=getIntent().getExtras().getString(SearchResultActivity.ARTIST_KEY);
        String songName=getIntent().getExtras().getString(SearchResultActivity.SONG_KEY);
        final ResultDetailsPresenter presenter=new ResultDetailsPresenter(this,repositoryImpl);
        presenter.getSongDetails(artistName,songName);
    }

    @Override
    public void setSongDetails(Song song) {
        artistName.setText(song.getArtist());
        songName.setText(song.getLyrics());
        urlTextView.setText(song.getUrl());
        lyricsText.setText(song.getLyrics());
    }

    @Override
    public void setNoSongView() {

    }
}
