package com.monstershore.maraudersmap.view.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.monstershore.maraudersmap.R;
import com.monstershore.maraudersmap.databinding.ActivityNewMapBinding;
import com.monstershore.maraudersmap.view.ui.adapters.NewMapAdapter;

public class NewMapActivity extends AppCompatActivity {

    private ActivityNewMapBinding mNewMapActivityBinding;
    private NewMapAdapter mNewMapAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNewMapActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_map);
        mNewMapAdapter = new NewMapAdapter(getSupportFragmentManager());
        mNewMapActivityBinding.pager.setAdapter(mNewMapAdapter);
    }
}
