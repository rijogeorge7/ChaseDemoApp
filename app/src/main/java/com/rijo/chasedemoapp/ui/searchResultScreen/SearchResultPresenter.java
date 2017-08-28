package com.rijo.chasedemoapp.ui.searchResultScreen;

import com.rijo.chasedemoapp.data.DataRepository;

/**
 * Created by rijogeorge on 8/27/17.
 */

public class SearchResultPresenter implements SearchResultContract.UserActionsListener{
    SearchResultContract.View view;
    DataRepository repository;

    public SearchResultPresenter(SearchResultContract.View view, DataRepository repository) {
        this.view = view;
        this.repository = repository;
    }
}
