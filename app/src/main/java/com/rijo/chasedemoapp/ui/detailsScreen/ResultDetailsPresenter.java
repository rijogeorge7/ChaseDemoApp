package com.rijo.chasedemoapp.ui.detailsScreen;

import com.rijo.chasedemoapp.data.DataRepository;
import com.rijo.chasedemoapp.data.domain.Song;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by rijogeorge on 8/28/17.
 */

public class ResultDetailsPresenter implements ResultDetailsContract.UserActionsListener {
    ResultDetailsContract.View view;
    DataRepository repository;

    public ResultDetailsPresenter(ResultDetailsContract.View view, DataRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getSongDetails(String artistNmae, String songTitle) {
        final String formatedArtistNmae=formatString(artistNmae);
        final String formatedSongTitle=formatString(songTitle);
        Song song=null;
        ExecutorService executor= Executors.newSingleThreadExecutor();
        Future<Song> songFuture=executor.submit(new Callable<Song>() {
            @Override
            public Song call() throws Exception {
                return repository.getSongDetails(formatedArtistNmae, formatedSongTitle);
            }
        });
        try{
            song=songFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if(song!=null)
            view.setSongDetails(song);
        else
            view.setNoSongView();
    }

    private String formatString(String searchString) {
        return searchString.replace(' ', '+');
    }
}
