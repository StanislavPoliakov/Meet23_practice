package home.stanislavpoliakov.meet23_practice;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.lang.annotation.Repeatable;


/**
 * A simple {@link Fragment} subclass.
 */
public class BXMLFragment extends DialogFragment {

    public static BXMLFragment newInstance() {
        return new BXMLFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bxml, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.imageView2);
        //imageView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.base));
        Animation animationXML = AnimationUtils.loadAnimation(getContext(), R.anim.base);
        imageView.startAnimation(animationXML);
        //translate.setStartOffset(3000);

        animationXML.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //AnimationSet translate = new AnimationSet()
                Animation translate = new TranslateAnimation(
                        0.0f,
                        100.0f,
                        0.0f,
                        10.0f);
                animationXML.setDuration(20);
                translate.setRepeatCount(0);
                imageView.startAnimation(translate);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



        //imageView.startAnimation(translate);
    }
}
