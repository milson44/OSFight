package pro.junes.osfightclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;

import static android.R.attr.left;
import static android.R.attr.right;
import static pro.junes.osfightclient.R.id.bottom;
import static pro.junes.osfightclient.R.id.top;

/**
 * Created by junes on 23.02.17.
 */

public class PlayerActivity extends AppCompatActivity {

    private MazeView view;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        GameManager gameManager = new GameManager(getApplicationContext());

        view = new MazeView(this,gameManager);

        android.graphics.drawable.Drawable background = getResources().getDrawable(R.drawable.background);
        background.setBounds(left, top, right, bottom);
        view.setBackground(background);

        setContentView(view);
        gestureDetector = new GestureDetector(this,gameManager);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return gestureDetector.onTouchEvent(event);
    }
}
