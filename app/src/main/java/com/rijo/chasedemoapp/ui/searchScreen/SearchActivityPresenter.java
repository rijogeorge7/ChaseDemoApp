package com.rijo.chasedemoapp.ui.searchScreen;

import com.rijo.chasedemoapp.data.DataRepository;
import com.rijo.chasedemoapp.data.domain.SearchResult;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by rijogeorge on 8/26/17.
 */

public class SearchActivityPresenter implements SearchActivityContract.UserActionsListener{
    SearchActivityContract.View view;
    DataRepository repository;

    public SearchActivityPresenter(SearchActivityContract.View view, DataRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void resetSearch() {
        view.resetSearchView();
    }

    @Override
    public void getSearchResults(String searchString) {
        final String formattedSearchString=formatSearchString(searchString);
        SearchResult searchResult=null;
        ExecutorService executor= Executors.newSingleThreadExecutor();
        Future<SearchResult> searchFuture=executor.submit(new Callable<SearchResult>() {
            @Override
            public SearchResult call() throws Exception {
                return repository.getSearchResults(formattedSearchString);
            }
        });
        try{
           searchResult=searchFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if(searchResult!=null)
            view.setSearchResult(searchResult);
        else
            view.setNoResultView();
    }

    private String formatSearchString(String searchString) {
        return searchString.replace(' ', '+');
    }
}
