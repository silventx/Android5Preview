package com.xpower.android5preview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.View;
import android.widget.SeekBar;

import com.xpower.android5preview.R;

/**
 * Created by 4399-3040 on 2016/7/21.
 */
public class CardViewActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private CardView mCardView;
    private AppCompatSeekBar mSeekBarRadius, mSeekBarElevation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mCardView = (CardView) findViewById(R.id.card_cv);
        mSeekBarRadius = (AppCompatSeekBar) findViewById(R.id.card_seekbar_radius);
        mSeekBarElevation = (AppCompatSeekBar) findViewById(R.id.card_seekbar_elevation);

        mToolBar.setTitle(getResources().getStringArray(R.array.widget_list)[1]);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mSeekBarRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mCardView.setRadius((float)i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSeekBarElevation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mCardView.setElevation((float)i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
