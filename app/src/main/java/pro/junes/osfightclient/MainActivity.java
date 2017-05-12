package pro.junes.osfightclient;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by milson on 30.03.17.
 */

public class MainActivity  extends ActionBarActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnActPlay = (ImageButton) findViewById(R.id.buttonPlay);
        btnActPlay.setOnClickListener(this);

        Button btnActStatistic = (Button) findViewById(R.id.buttonStatistic);
        btnActStatistic.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPlay:
                Intent intent1 = new Intent(this, RegistrationActivity.class);
                startActivity(intent1);
                break;
            case R.id.buttonStatistic:
                Intent intent2 = new Intent(this, StatisticActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
