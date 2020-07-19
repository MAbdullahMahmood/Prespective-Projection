package com.example.prespectiveprojection;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;

import me.pqpo.smartcropperlib.SmartCropper;
import me.pqpo.smartcropperlib.view.CropImageView;


public class MainActivity extends AppCompatActivity {


    ImageView outputImageview;
    CropImageView ivTransform;
    Button btn;
    TextView btn_next;
    Bitmap icon;
    ArrayList<Integer> list = new ArrayList();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SmartCropper.buildImageDetector(this);
        setContentView(R.layout.activity_main);
        outputImageview = findViewById(R.id.output_image);
        ivTransform = findViewById(R.id.iv_crop);
        btn = findViewById(R.id.btn_ok);
        btn_next = findViewById(R.id.btn_next);

        list.add(R.raw.h);
        list.add(R.raw.g);
        list.add(R.raw.bookimg);
        list.add(R.raw.d);
        list.add(R.raw.prespective);
        list.add(R.raw.test15);
        list.add(R.raw.test20);
        list.add(R.raw.e);






        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputImageview.setImageBitmap(null);
                if (count <list.size()){
                    count++;
                }else {
                    count = 0;
                }
                onResume();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (count <list.size()){
            icon = BitmapFactory.decodeResource(getResources(),
                    list.get(count));
        }else {
            count =0;
                icon = BitmapFactory.decodeResource(getResources(),
                        list.get(count));
        }



        ivTransform.setImageToCrop(icon);
        final android.graphics.Point[] points = ivTransform.getCropPoints();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivTransform.setCropPoints(points);
                outputImageview.setImageBitmap(ivTransform.crop());
            }
        });
    }
}
