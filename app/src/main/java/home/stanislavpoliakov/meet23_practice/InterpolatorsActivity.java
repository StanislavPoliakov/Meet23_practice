package home.stanislavpoliakov.meet23_practice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class InterpolatorsActivity extends AppCompatActivity {
    private static final String TAG = "meet23_logs";
    private ImageView catView, elephantView, owlView, goatView, pigView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolators);

        init();
    }

    private void init() {
        catView = findViewById(R.id.catView);
        catView.setImageDrawable(getResources().getDrawable(R.drawable.cat, getTheme()));

        elephantView = findViewById(R.id.elephantView);
        elephantView.setImageDrawable(getResources().getDrawable(R.drawable.elephant, getTheme()));

        goatView = findViewById(R.id.goatView);
        goatView.setImageDrawable(getResources().getDrawable(R.drawable.goat, getTheme()));

        owlView = findViewById(R.id.owlView);
        owlView.setImageDrawable(getResources().getDrawable(R.drawable.owl, getTheme()));

        pigView = findViewById(R.id.pigView);
        pigView.setImageDrawable(getResources().getDrawable(R.drawable.pig, getTheme()));

        //ViewGroup.LayoutParams lp = catView.getLayoutParams();
        float startPosition = catView.getX();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        float endPosition = size.x - catView.getPaddingRight() - 160;

        ValueAnimator rotateAnimator = ValueAnimator.ofFloat(0, 3600);
        rotateAnimator.addUpdateListener((animator) -> {
            catView.setRotation((float) animator.getAnimatedValue());
            elephantView.setRotation((float) animator.getAnimatedValue());
            goatView.setRotation((float) animator.getAnimatedValue());
            owlView.setRotation((float) animator.getAnimatedValue());
            pigView.setRotation((float) animator.getAnimatedValue());
        });
        rotateAnimator.setDuration(5000);
        rotateAnimator.start();

        ValueAnimator catPositionAnimator = ValueAnimator.ofFloat(startPosition, endPosition);
        catPositionAnimator.addUpdateListener((animator) -> {
            catView.setX((float) animator.getAnimatedValue());
            catView.setY((float)  (Math.sin((float) animator.getAnimatedValue() / 50) * 50));
            //catView.setRotation((float) animator.getAnimatedValue());
        });

        catPositionAnimator.setDuration(5000);
        //catPositionAnimator.setInterpolator(new OvershootInterpolator());
        catPositionAnimator.start();

        ValueAnimator elephantPositionAnimator = ValueAnimator.ofFloat(startPosition, endPosition);
        elephantPositionAnimator.addUpdateListener((animator) -> {
            elephantView.setX((float) animator.getAnimatedValue());
            //elephantView.setRotation((float) animator.getAnimatedValue());
        });

        elephantPositionAnimator.setDuration(5000);
        elephantPositionAnimator.setInterpolator(new LinearOutSlowInInterpolator());
        elephantPositionAnimator.start();

        ValueAnimator goatPositionAnimator = ValueAnimator.ofFloat(startPosition, endPosition);
        goatPositionAnimator.addUpdateListener((animator) -> {
            goatView.setX((float) animator.getAnimatedValue());
            //goatView.setRotation((float) animator.getAnimatedValue());
        });

        goatPositionAnimator.setDuration(5000);
        goatPositionAnimator.setInterpolator(new BounceInterpolator());
        goatPositionAnimator.start();

        ValueAnimator owlPositionAnimator = ValueAnimator.ofFloat(startPosition, endPosition);
        owlPositionAnimator.addUpdateListener((animator) -> {
            owlView.setX((float) animator.getAnimatedValue());
            //owlView.setRotation((float) animator.getAnimatedValue());
        });

        owlPositionAnimator.setDuration(5000);
        owlPositionAnimator.setInterpolator(new AnticipateInterpolator());
        owlPositionAnimator.start();

        ValueAnimator pigPositionAnimator = ValueAnimator.ofFloat(startPosition, endPosition);
        pigPositionAnimator.addUpdateListener((animator) -> {
            pigView.setX((float) animator.getAnimatedValue());
            //pigView.setRotation((float) animator.getAnimatedValue());
        });

        pigPositionAnimator.setDuration(5000);
        pigPositionAnimator.setInterpolator(new FastOutLinearInInterpolator());
        pigPositionAnimator.start();

        TranslateAnimation translateAnimation = new TranslateAnimation(0, -200,
                0, 200);
        RotateAnimation rotateDownAnimation = new RotateAnimation(0,
                90, (- startPosition + endPosition + 160) / 2, 0);

        RotateAnimation rotateUpAnimation = new RotateAnimation(0,
                -90, (- startPosition + endPosition + 160) / 2, 0);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(rotateDownAnimation);
        animationSet.setDuration(6000);

        rotateAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                catView.startAnimation(animationSet);
                elephantView.startAnimation(animationSet);
                goatView.startAnimation(animationSet);
                owlView.startAnimation(animationSet);
                pigView.startAnimation(animationSet);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, InterpolatorsActivity.class);
    }
}
