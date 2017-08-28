package com.rijo.chasedemoapp.ui.searchScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rijo.chasedemoapp.R;
import com.rijo.chasedemoapp.data.DataRepositoryImpl;
import com.rijo.chasedemoapp.data.domain.SearchResult;
import com.rijo.chasedemoapp.ui.searchResultScreen.SearchResultActivity;

public class SearchActivity extends AppCompatActivity implements SearchActivityContract.View{

    public static final String SEARCH_RESULT_KEY="com.rijo.chasedemoapp.ui.searchScreen.searchResultKey";
    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataRepositoryImpl repositoryImpl=new DataRepositoryImpl();
        final SearchActivityPresenter presenter=new SearchActivityPresenter(this,repositoryImpl);
        searchEditText=(EditText)findViewById(R.id.searchEditText);
        final Button resetButton=(Button)findViewById(R.id.resetButton);
        final Button searchButton=(Button)findViewById(R.id.searchButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.resetSearch();
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchString=searchEditText.getText().toString();
                presenter.getSearchResults(searchString);
            }
        });
    }

    public void resetSearchView() {
        searchEditText.setText("");
    }

    @Override
    public void setSearchResult(SearchResult searchResult) {
        Intent intent=new Intent(this, SearchResultActivity.class);
        intent.putExtra(SEARCH_RESULT_KEY,searchResult);
        startActivity(intent);
    }

    @Override
    public void setNoResultView() {

    }
}
