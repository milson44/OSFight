package pro.junes.osfightclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by milson on 30.03.17.
 */

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        EditText name = (EditText) findViewById(R.id.name_editText);
        EditText age = (EditText) findViewById(R.id.age_editText);
        EditText city = (EditText) findViewById(R.id.city_editText);


        Button btnActOK = (Button) findViewById(R.id.OK_button);
        btnActOK.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {

        EditText name = (EditText) findViewById(R.id.name_editText);
        EditText age = (EditText) findViewById(R.id.age_editText);
        EditText city = (EditText) findViewById(R.id.city_editText);


        if((name.getText().length() == 0) || (age.getText().length() == 0) || (city.getText().length() == 0)){

            Intent intent1 = new Intent(this, RegistrationActivity.class);
            startActivity(intent1);

        }
        else{

            Intent intent1 = new Intent(this, PlayerActivity.class);
            startActivity(intent1);


        }





        }



}

