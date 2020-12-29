package com.itus.cowa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class TransactionActivity extends AppCompatActivity {

    private ImageButton btnBack;
    private Button btnTransfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        btnBack = findViewById(R.id.btnBack);
        btnTransfer = findViewById(R.id.btnTransfer);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FaceDetectionFragment fragment = FaceDetectionFragment.newInstance("Nhận dạng khuôn mặt");
                fragment.show(fm, "fragment_face_detection");
                Toast.makeText(getApplicationContext(), "Chuyển tiền thành công", Toast.LENGTH_LONG);
            }
        });
    }
}