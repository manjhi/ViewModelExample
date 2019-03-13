package com.omninos.demo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GenerateViewModel viewModel;
    private Button buttonData;
    private TextView random_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewModel = ViewModelProviders.of(this).get(GenerateViewModel.class);

        buttonData = findViewById(R.id.buttonData);
        random_tv = findViewById(R.id.random_tv);


        buttonData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) (Math.random() * 50 + 1);
                viewModel.SetNumber(random);
            }
        });


        viewModel.GetNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                random_tv.setText(String.valueOf(integer));
            }
        });
    }
}
