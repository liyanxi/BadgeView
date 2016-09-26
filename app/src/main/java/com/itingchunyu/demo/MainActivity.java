package com.itingchunyu.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.itingchunyu.badgeview.IBadgeTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.tv);
        IBadgeTextView mBadgeView=new IBadgeTextView(this);
        mBadgeView.setTargetView(tv);
        mBadgeView.setBadgeCount(29);

    }
}
