package com.example.a05_android_send_email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button Send_Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Send_Email = findViewById(R.id.Send_Email);

        Send_Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"hoangphi11343@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Đây là tiêu đề");
                intent.putExtra(Intent.EXTRA_TEXT, "Đây là nội dung");

                try {
                    startActivity(Intent.createChooser(intent, "Chọn ứng dụng email"));
                } catch (android.content.ActivityNotFoundException ex) {
                    // Xử lý nếu không có ứng dụng email nào được cài đặt trên thiết bị
                    Toast.makeText(MainActivity.this, "Không có ứng dụng Email nào trên thiết bị của bạn", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}