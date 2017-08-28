package com.rijo.chasedemoapp.ui.searchScreen;

import com.rijo.chasedemoapp.data.domain.SearchResult;

/**
 * Created by rijogeorge on 8/26/17.
 */

public interface SearchActivityContract {
    interface View {
        void resetSearchView();
        void setSearchResult(SearchResult searchResult);
        void setNoResultView();
    }

    interface UserActionsListener{
        void resetSearch();
        void getSearchResults(String searchString);
    }
}
