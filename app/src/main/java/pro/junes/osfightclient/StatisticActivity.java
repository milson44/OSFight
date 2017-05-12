package pro.junes.osfightclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by milson on 30.03.17.
 */

public class StatisticActivity extends AppCompatActivity implements View.OnClickListener  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistic);


        Button btnActAge = (Button) findViewById(R.id.buttonAge);
        btnActAge.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Button btnActAge = (Button) findViewById(R.id.buttonAge);
        Button btnActCity = (Button) findViewById(R.id.buttonCity);
        Button btnActOS = (Button) findViewById(R.id.buttonOS);

        switch (v.getId()) {
            case R.id.buttonAge:
                Intent intent1 = new Intent(this, TableStatisticActivity.class);
                startActivity(intent1);

                break;
            case R.id.buttonCity:
                Intent intent2 = new Intent(this, TableStatisticActivity.class);
                startActivity(intent2);

                break;
            case R.id.buttonOS:
                Intent intent3 = new Intent(this, TableStatisticActivity.class);
                startActivity(intent3);

                break;
        }
    }
}