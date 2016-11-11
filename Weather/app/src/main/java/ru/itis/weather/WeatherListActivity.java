package ru.itis.weather;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import ru.itis.weather.weather_api.entities.one_day.City;
import ru.itis.weather.weather_api.entities.one_day.MyWeather;
import ru.itis.weather.weather_api.providers.NotLoadedException;
import ru.itis.weather.weather_api.providers.WeatherProvider;

public class WeatherListActivity extends AppCompatActivity {
    private WeatherListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = (WeatherListFragment) getSupportFragmentManager().findFragmentByTag(WeatherListFragment.class.getName());
        if(listFragment == null){
            listFragment = WeatherListFragment.newInstance();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity, listFragment, WeatherListFragment.class.getName())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.weather_list_menu, menu);
        return true;
    }

}
class WeatherListAdapter extends RecyclerView.Adapter<WeatherListViewHolder> {
    private Context context;
    private MyWeather weather;


    public WeatherListAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
    }

    @Override
    public WeatherListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);
        return new WeatherListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherListViewHolder holder, final int position) {
        final City city;
        try {
            city = weather.getList().get(position).getCity();
            holder.bind(weather.getList().get(position));
        } catch (NotLoadedException e) {
            Toast.makeText(context, "Can`t load weather information", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        weather = WeatherProvider.getInstance().getOneDayWeather(context);
        try {
            return weather.getList().size();
        } catch (NotLoadedException e) {
            return 0;
        }
    }
}
class WeatherListViewHolder extends RecyclerView.ViewHolder {
    private TextView tvCityName;
    private TextView tvCountry;
    private TextView tvTemperature;


    public WeatherListViewHolder(View itemView) {
        super(itemView);
        tvCityName = (TextView) itemView.findViewById(R.id.tv_city_name);
        tvCountry = (TextView) itemView.findViewById(R.id.tv_country);
        tvTemperature = (TextView) itemView.findViewById(R.id.tv_temperature);
    }

    public void bind(ru.itis.weather.weather_api.entities.one_day.List weatherList) {
        tvCityName.setText(weatherList.getName());
        tvCountry.setText(weatherList.getSys().getCountry());
        double temp = weatherList.getMain().getTemp();
        String sTemp = String.valueOf(Math.round(temp));
        if (temp > 0) {
            sTemp = "+" + sTemp;
        }
        tvTemperature.setText(sTemp);
    }
}


