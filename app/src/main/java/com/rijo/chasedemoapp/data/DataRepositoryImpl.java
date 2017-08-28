package com.rijo.chasedemoapp.data;

import com.rijo.chasedemoapp.data.domain.SearchResult;
import com.rijo.chasedemoapp.data.domain.Song;
import com.rijo.chasedemoapp.util.Utilities;

/**
 * Created by rijogeorge on 8/26/17.
 */

public class DataRepositoryImpl implements DataRepository {
    @Override
    public SearchResult getSearchResults(String searchString) {
        //boolean downloaded=Utilities.downLoadJsonFile(Constants.SEARCH_API+searchString);
        String jsonStr=Utilities.downloadProductsFromUrl(Constants.SEARCH_API+searchString);
        if(jsonStr!=null){
            SearchResult searchResult=Utilities.getClassFromJSONString(jsonStr,SearchResult.class);
            return searchResult;
        }
        else {
            return null;
        }
    }

    @Override
    public Song getSongDetails(String artistNmae, String songTitle) {
        String jsonStr=Utilities.downloadProductsFromUrl(Constants.DETAILS_API+"&artist="+artistNmae+"&song="+songTitle);
        if(jsonStr==null) {
            return null;
        }
        else {
            jsonStr=jsonStr.substring(6, jsonStr.length());
            Song song=Utilities.getClassFromJSONString(jsonStr,Song.class);
            return song;
        }
    }
}
