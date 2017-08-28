package com.rijo.chasedemoapp.ui.detailsScreen;

import com.rijo.chasedemoapp.data.domain.Song;

/**
 * Created by rijogeorge on 8/28/17.
 */

public interface ResultDetailsContract {
    interface View {
       void setSongDetails(Song song);
        void setNoSongView();
    }

    interface UserActionsListener{
      void getSongDetails(String artistNmae,String songTitle);
    }
}
