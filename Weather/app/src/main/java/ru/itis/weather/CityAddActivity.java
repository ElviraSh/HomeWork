package ru.itis.weather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.itis.weather.weather_api.entities.one_day.City;
import ru.itis.weather.weather_api.entities.one_day.MyWeather;
import ru.itis.weather.weather_api.providers.NotLoadedException;
import ru.itis.weather.weather_api.providers.CityProvider;

public class CityAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_add);
        Add add = (Add) getSupportFragmentManager().findFragmentByTag(Add.class.getName());
        if(add == null){
            add = Add.newInstance();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_city_add, add, Add.class.getName())
                .commit();
    }
}
class CityAddListAdapter extends RecyclerView.Adapter<CityAddListViewHolder> {
    private MyWeather weather;

    public void setInformation(MyWeather weather){
        this.weather = weather;
    }

    @Override
    public CityAddListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_add_list_item, parent, false);
        return new CityAddListViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(CityAddListViewHolder holder, int position) {
        try {
            holder.bind(weather.getList().get(position).getCity());
        } catch (NotLoadedException e) {
            e.printStackTrace();
        } catch (NullPointerException e){}
    }

    @Override
    public int getItemCount() {
        try {
            return weather.getList().size();
        } catch (NotLoadedException e) {
            return 0;
        } catch (NullPointerException e){
            return 0;
        }
    }

}
class CityAddListViewHolder extends RecyclerView.ViewHolder{
    private TextView tvCityText;
    private Button btnAdd;
    private Context context;
    public CityAddListViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        tvCityText = (TextView) itemView.findViewById(R.id.tv_city_name);
        btnAdd = (Button) itemView.findViewById(R.id.btn_add);
    }

    public void bind(final City city){
        tvCityText.setText(city.getName() + ", " + city.getCountry());
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<City> cityList = CityProvider.getInstance().getCitiesList(context);
                if(cityList.contains(city)){
                    Toast.makeText(context, "City already exist", Toast.LENGTH_LONG).show();
                } else {
                    if(city.getId() == 0){
                        Toast.makeText(context, "Can't add this city, cause server problem", Toast.LENGTH_LONG).show();
                    } else {
                        cityList.add(city);
                        CityProvider.getInstance().writeCitiesList(context, cityList);
                        Toast.makeText(context, "City added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, WeatherListActivity.class);
                        context.startActivity(intent);
                    }
                }
            }
        });
    }
}
