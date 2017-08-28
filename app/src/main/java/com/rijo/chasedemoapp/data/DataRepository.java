package com.rijo.chasedemoapp.data;

import com.rijo.chasedemoapp.data.domain.SearchResult;
import com.rijo.chasedemoapp.data.domain.Song;

/**
 * Created by rijogeorge on 8/26/17.
 */

public interface DataRepository {
    SearchResult getSearchResults(String searchString);

    Song getSongDetails(String artistNmae, String songTitle);
}
