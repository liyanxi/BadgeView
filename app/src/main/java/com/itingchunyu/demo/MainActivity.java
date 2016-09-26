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

        //无数值
        TextView tv = (TextView) findViewById(R.id.tv);
        IBadgeTextView mBadgeView=new IBadgeTextView(this);
        mBadgeView.setTargetView(tv);
        mBadgeView.setBadgeCount(0);
        //两位数
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        IBadgeTextView mBadgeView2=new IBadgeTextView(this);
        mBadgeView2.setTargetView(tv2);
        mBadgeView2.setBadgeCount(92)
                .setmDefaultRightPadding(20)
                .setmDefaultTopPadding(20);
    }
}
