package com.itingchunyu.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.itingchunyu.badgeview.BadgeTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //无数值
        TextView tv = (TextView) findViewById(R.id.tv);
        BadgeTextView mBadgeTextView =new BadgeTextView(this);
        mBadgeTextView.setTargetView(tv);
        mBadgeTextView.setBadgeCount(0).setmDefaultTopPadding(15).setmDefaultRightPadding(20);
        mBadgeTextView.setBadgeShown(true);
        //两位数
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        BadgeTextView mBadgeTextView2 =new BadgeTextView(this);
        mBadgeTextView2.setBadgeShown(true);
        mBadgeTextView2.setTargetView(tv2);
        mBadgeTextView2.setBadgeCount(92).setmDefaultRightPadding(20).setmDefaultTopPadding(15);

    }
}
