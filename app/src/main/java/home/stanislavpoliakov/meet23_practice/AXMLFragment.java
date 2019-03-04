package home.stanislavpoliakov.meet23_practice;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AXMLFragment extends DialogFragment {

    public static AXMLFragment newInstance() {
        return new AXMLFragment();
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
        return inflater.inflate(R.layout.fragment_bc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.imageView3);

        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater
                .loadAnimator(getContext(), R.animator.translation_object);
        animatorSet.setTarget(imageView);
        //animatorSet.playSequentially();
        animatorSet.setStartDelay(1000);
        animatorSet.start();

        /*ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,
                View.X,
                0f, 500f);
        animator.setDuration(200);
        animator.start();*/
    }
}
