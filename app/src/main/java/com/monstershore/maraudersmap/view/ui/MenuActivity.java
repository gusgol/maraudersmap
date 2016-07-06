package com.monstershore.maraudersmap.view.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.monstershore.maraudersmap.R;


public class MenuActivity extends AppCompatActivity {

    private Context mContext;

    private CardView mNewMap;
    private CardView mMyMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mNewMap = (CardView) findViewById(R.id.newMap);
        mMyMaps = (CardView) findViewById(R.id.myMaps);

        mContext = this;

        mNewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NewMapActivity.class);
                mContext.startActivity(intent);
            }
        });

        mMyMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, NewMapActivity.class);
//                mContext.startActivity(intent);
            }
        });
    }
}
