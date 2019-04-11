package co.paulfran.paulfranco.truthordaregame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    Button mButton;
    private Random random = new Random();
    private int lastDirection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);
        mButton = findViewById(R.id.button);

    }

    public void spin(View view) {
        int newDirection = random.nextInt(3600) + 360;
        float pivotX = mImageView.getWidth()/2;
        float pivotY = mImageView.getHeight()/2;


        Animation rotate = new RotateAnimation(lastDirection, newDirection, pivotX, pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mButton.setEnabled(false);
                mButton.setText("Spinning");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mButton.setEnabled(true);
                mButton.setText("Spin Bottle");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        lastDirection = newDirection;

        mImageView.startAnimation(rotate);

    }
}
