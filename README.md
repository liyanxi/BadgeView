### BadgeView
add badgeview to any targetView in Android

## Usage

### Step1
Add dependencies in build.gradle.
```
    dependencies {
           compile 'com.itingchunyu.badgeview:badgeview:1.0.0'
    }
```
### Step2
使用样例
```
    //第一种方式:可依附任意view(无限制)
    TextView tv = (TextView) findViewById(R.id.tv);
    IBadgeTextView mBadgeView=new IBadgeTextView(this);
    mBadgeView.setTargetView(tv);//设置目标targetView(可任意:此处只做演示)
    mBadgeView2.setBadgeCount(92)//数量(0:表示小红点)
            .setmDefaultRightPadding(20)//右视图距离
            .setmDefaultTopPadding(20);//上视图距离
```
```
    //第二种方式:布局中直接引用(仅作为TextView是用)
    <com.itingchunyu.badgeview.IBadgeTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:gravity="center"
        android:text="Hello World"
        app:badge_count="9"
        android:textSize="30dp"
        app:badge_padding_right="5dp"
        app:badge_padding_top="5dp"/>
```
### 预览图
![效果图](gif/pre_pic.png)
### 参考实例代码

<https://github.com/stefanjauker/BadgeView>

<https://github.com/wwwrookie/BadgeView>

### License
```
 Copyright 2016 itingchunyu
    &
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
    &
 http://www.apache.org/licenses/LICENSE-2.0
    &
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```