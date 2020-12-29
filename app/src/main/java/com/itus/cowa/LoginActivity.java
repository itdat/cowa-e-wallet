package com.itus.cowa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView useFaceDetection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), MainActivity.class));
            }
        });

        useFaceDetection = findViewById(R.id.useFaceDetection);
        useFaceDetection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFaceDetectionDialog();
            }
        });
    }

    private void showFaceDetectionDialog() {
        FragmentManager fm = getSupportFragmentManager();
        FaceDetectionFragment fragment = FaceDetectionFragment.newInstance("Nhận dạng khuôn mặt");
        fragment.show(fm, "fragment_face_detection");
    }
}