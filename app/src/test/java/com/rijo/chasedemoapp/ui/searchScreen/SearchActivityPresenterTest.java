package com.rijo.chasedemoapp.ui.searchScreen;

import com.rijo.chasedemoapp.data.DataRepository;
import com.rijo.chasedemoapp.data.domain.SearchResult;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by rijogeorge on 8/26/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SearchActivityPresenter.class)
public class SearchActivityPresenterTest {
    @Mock
    SearchActivityContract.View viewMock;
    @Mock
    DataRepository repositoryMock;

    SearchActivityPresenter presenter;
    @Before
    public void setUp() throws Exception {

        presenter=new SearchActivityPresenter(viewMock,repositoryMock);
    }

    @Test
    public void resetSearch() throws Exception {
        //when
        presenter.resetSearch();
        //then
        Mockito.verify(viewMock).resetSearchView();
    }

    @Test
    public void getSearchResults() throws Exception {
        //given
        SearchResult sResult=new SearchResult();
        when(repositoryMock.getSearchResults(anyString())).thenReturn(sResult);
        //when
        presenter.getSearchResults(anyString());
        //then
        Mockito.verify(viewMock).setSearchResult(sResult);
    }

}