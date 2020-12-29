package com.itus.cowa;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class FaceDetectionFragment extends DialogFragment {
    private LottieAnimationView imgDetecting;
    private TextView txtDetecting;

    public FaceDetectionFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static FaceDetectionFragment newInstance(String title) {
        FaceDetectionFragment frag = new FaceDetectionFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_face_detection, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Nhận dạng khuôn mặt");
        getDialog().setTitle(title);

        imgDetecting = getView().findViewById(R.id.imgDetecting);
        txtDetecting = getView().findViewById(R.id.txtDetecting);

        new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                imgDetecting.setAnimation(R.raw.success);
                imgDetecting.resumeAnimation();
                txtDetecting.setText("Nhận dạng thành công");

                new CountDownTimer(800, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }
                    public void onFinish() {
                        dismiss();
                        startActivity(new Intent(getContext(), MainActivity.class));
                    }
                }.start();
            }
        }.start();
    }
}