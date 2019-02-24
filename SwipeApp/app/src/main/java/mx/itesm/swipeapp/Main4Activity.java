package mx.itesm.swipeapp;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private GestureDetectorCompat detector;
    private final float SWIPE_THRESHOLD = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        detector = new GestureDetectorCompat(this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.detector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Intent intent;
        float d = e2.getX() - e1.getX();
        if(Math.abs(d) < SWIPE_THRESHOLD)
            return false;
        if(d > 0) {
            intent = new Intent(Main4Activity.this, Main3Activity.class);
            Toast.makeText(getApplicationContext(), "Swipe right" , Toast.LENGTH_SHORT).show();
        }else {
            intent = new Intent(Main4Activity.this, MainActivity.class);
            Toast.makeText(getApplicationContext(), "Swipe left" , Toast.LENGTH_SHORT).show();
        }
        startActivity(intent);
        return true;    }
}
