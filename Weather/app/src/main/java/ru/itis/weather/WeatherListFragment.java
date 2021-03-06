package ru.itis.weather;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import ru.itis.weather.weather_api.entities.one_day.City;
import ru.itis.weather.weather_api.entities.one_day.MyWeather;
import ru.itis.weather.weather_api.providers.NotLoadedException;
import ru.itis.weather.weather_api.providers.CityProvider;
import ru.itis.weather.weather_api.providers.WeatherProvider;


/**
 * Created by Elvira on 11.11.2016.
 */
public class WeatherListFragment extends Fragment implements AsyncTaskInterface {
    private WeatherListAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private WeatherUpdater updater;

    public static WeatherListFragment newInstance() {

        Bundle args = new Bundle();

        WeatherListFragment fragment = new WeatherListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weathr_list_fragment, container, false);

        fillToolbar(view);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.sr_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateInformation();
            }
        });

        mAdapter = new WeatherListAdapter(getActivity(), getFragmentManager());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);



        updateInformation();

        return view;
    }



    private void onAddClicked() {
        Intent intent = new Intent(getActivity(), CityAddActivity.class);
        startActivity(intent);
    }


    private void fillToolbar(View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.main_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_add :
                        onAddClicked();
                        break;
                }
                return true;
            }
        });
    }

    public void updateInformation(){
        updater = new WeatherUpdater(this);
        List<City> cityList = CityProvider.getInstance().getCitiesList(getActivity());
        updater.execute(cityList);
    }

    public void notifyDataSetChanged(){
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTaskStarted() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onTaskFinished(MyWeather weather) {
        mSwipeRefreshLayout.setRefreshing(false);
        try {
            WeatherProvider.getInstance().saveOneDayWeather(getActivity(), weather);
            notifyDataSetChanged();
        } catch (NotLoadedException e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        if(updater != null){
            if(updater.cancel(true));
        }
        super.onDetach();
    }
}