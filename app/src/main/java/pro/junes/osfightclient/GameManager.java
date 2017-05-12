package pro.junes.osfightclient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junes on 23.02.17.
 */

public class GameManager extends GestureDetector.SimpleOnGestureListener{

    private List<Drawable> drawables = new ArrayList<>();
    private View view;
    private Exit exit;
    private Player player;
    private Player player2;
    private Maze maze;
    private Rect rect = new Rect();
    private int screensize;
    private Dot_trampoline [] dot_trampoline = new Dot_trampoline[3];
    private Dot_stair [] dot_stair = new Dot_stair[3];
    Context context;

    private int count_step = 0;


    public GameManager(Context context){


        Client client = new Client("10.0.2.2",8080);
        client.execute();

        create(33,19);
        this.context = context;
    }


    private void create(int size_x, int size_y){

        drawables.clear();
        maze = new Maze(size_x,size_y);
        drawables.add(maze);

        exit = new Exit(maze.getEnd(),size_x);
        drawables.add(exit);

        player = new Player(maze.getStart(),size_x, R.drawable.linux);
        drawables.add(player);

        player2 = new Player(maze.getStart2(),size_x,R.drawable.windows);
        drawables.add(player2);


        Point[] point = maze.get_trampoline_dots();
        for(int i = 0 ; i < 3 ; i++){
            dot_trampoline[i] = new Dot_trampoline(point[i],size_x,R.drawable.trampoline);
            drawables.add(dot_trampoline[i]);

        }

        point = maze.get_stair_dots();
        for(int i = 0 ; i < 3 ; i++){
            dot_stair[i] = new Dot_stair(point[i],size_x,R.drawable.stair);
            drawables.add(dot_stair[i]);

        }

    }


    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        int diffx, diffy;

        diffx = Math.round(e2.getX()) - Math.round(e1.getX());
        diffy = Math.round(e2.getY()) - Math.round(e1.getY());

        //в какую сторону был сделан мах

        if(Math.abs(diffx) > Math.abs(diffy)){

            diffx = diffx > 0 ? 1 : -1;
            diffy = 0;

        }else{
            diffy = diffy > 0 ? 1 : -1;
            diffx = 0;
        }

        int stepX =  player.getX(), stepY = player.getY();
        boolean b_trampline = true;
        while (maze.canPlayerGoTo(stepX+diffx,stepY+diffy) && b_trampline){

            stepX += diffx;
            stepY += diffy;
            // Point p = new Point(stepX,stepY);


            for(int i = 0 ; i < 3 ; i++) {
                if((stepX == dot_trampoline[i].getPoint().x) && (stepY == dot_trampoline[i].getPoint().y)) { b_trampline = false;}
            }  // проверка на батут

            for(int i = 0 ; i < 3 ; i++) {
                if((stepX == dot_stair[i].getPoint().x) && (stepY == dot_stair[i].getPoint().y)) { b_trampline = false;}
            }  // проверка на лестницу

            if (diffx !=0) {
                if(maze.canPlayerGoTo(stepX,stepY+1)||          /// если по пути  горизонтальному есть поворот
                        maze.canPlayerGoTo(stepX,stepY-1)){
                    break;
                }
            }

            if (diffy !=0) {
                if(maze.canPlayerGoTo(stepX + 1,stepY)||        /// если по пути вертикалькому есть поворот
                        maze.canPlayerGoTo(stepX - 1 ,stepY)){
                    break;
                }
            }
        }
        //player.move(newX,newY);

        player.goTo(stepX,stepY);
        count_step ++;

        //  ------ супер ДИНАМИЧЕСКИЙ ЛАБИРИНТ
        // if(count_step == 10) {create(maze.getSize_x(),maze.getSize_y()); count_step =0; }

        // если конец
        if(exit.getPoint().equals(player.getPoint())){

            Log.i(String.valueOf(stepX),"win");
            Toast toast = Toast.makeText(context.getApplicationContext(),
                    "You win! ",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            //create(maze.getSize_x(),maze.getSize_y());
        }


        //если батут
        for(int i = 0 ; i < 3 ; i++) {
            if (dot_trampoline[i].getPoint().equals(player.getPoint())) {
                player.goTo(1, 1);

                create(maze.getSize_x(),maze.getSize_y());
                break;
            }
        }


        for(int i = 0 ; i < 3 ; i++) {
            if (dot_stair[i].getPoint().equals(player.getPoint())) {
                maze.climb(dot_stair[i].getPoint());
                break;
                //create(maze.getSize_x(),maze.getSize_y());
            }
        }

        view.invalidate();
        return super.onFling(e1, e2, velocityX, velocityY);
    }



    public  void draw(Canvas canvas){

        for(Drawable drawableItem:
                drawables){
            drawableItem.draw(canvas,rect,context);
        }
    }



    public void setView(View view) {
        this.view = view;
    }


    public void setScreenSize(int width, int height){
        screensize  = Math.min(width,height);   //минимальная сторона
        /*rect.set(
                (width-screensize )/2,
                (width-screensize )/2,
                (width +screensize )/2,
                (height + screensize )/2
        );*/

        rect.set(
                150,
                40,
                width/10*8,
                (height+ screensize)/2
        );

    }



}

