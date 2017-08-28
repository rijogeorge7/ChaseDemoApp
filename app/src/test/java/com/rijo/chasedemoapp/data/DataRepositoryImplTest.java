package com.rijo.chasedemoapp.data;

import com.rijo.chasedemoapp.data.domain.SearchResult;
import com.rijo.chasedemoapp.mock.Mocked;
import com.rijo.chasedemoapp.ui.searchScreen.SearchActivityPresenter;
import com.rijo.chasedemoapp.util.Utilities;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by rijogeorge on 8/27/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DataRepositoryImplTest.class, Utilities.class})
public class DataRepositoryImplTest {



    private DataRepositoryImpl dataRepositoryImpl;

    @Before
    public void setUp() throws Exception {
        dataRepositoryImpl=new DataRepositoryImpl();

    }

    @Test
    public void getSearchResults() throws Exception {
        PowerMockito.mockStatic(Utilities.class);
        //given
        SearchResult searchResult=new SearchResult();
        when(Utilities.downloadProductsFromUrl(any(String.class))).thenReturn(Mocked.searchResult);
        when(Utilities.getClassFromJSONString(Mocked.searchResult,SearchResult.class)).thenReturn(searchResult);
        //when
        SearchResult searchResultActual=dataRepositoryImpl.getSearchResults(anyString());
        //then
        assertEquals(searchResult,searchResultActual);
    }

}