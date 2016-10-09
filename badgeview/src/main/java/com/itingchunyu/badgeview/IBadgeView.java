/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.itingchunyu.badgeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by liyanxi on 16/9/22.
 */
public class IBadgeView {

    private Paint mPaint;
    private Paint mTextPaint;

    /**
     * 默认红点半径基数 unit dp
     */
    private int mDefaultRadiusDp = 8;
    /**
     * 默认红点半径基数 unit dp
     */
    private int mDefaultRadius = 0;
    /**
     * 默认背景颜色
     */
    private int mDefaultBackgroundColor = Color.parseColor("#FE6270");
    /**
     * 默认字体颜色
     */
    private int mDefaultTextColor = Color.WHITE;
    /**
     * 默认字体大小 unit sp
     */
    private int mDefaultTextSize = 11;
    /**
     * 展示数量
     */
    private int mCount;
    /**
     * 是否显示红点
     */
    boolean isShowBadge = true;
    /**
     * 红点宽度
     */
    private int mBadgeWidth;
    /**
     * 红点高度
     */
    private int mBadgeHeight;
    private RectF rectF;
    /**
     * 视图宽度
     */
    private int mViewWidth;
    @SuppressWarnings("unused")
    private int mViewHeight;
    /**
     * 红点距离视图上边距
     */
    private int mDefaultTopPadding;
    /**
     * 红点距离视图右边距
     */
    private int mDefaultRightPadding;
    private View mView;//依附view
    private Context mContext;


    public IBadgeView(View view, Context mContext) {
        this.mView = view;
        this.mContext = mContext;
        init();
    }

    public IBadgeView(View view, Context mContext, AttributeSet attrs) {
        this.mView = view;
        this.mContext = mContext;

        TypedArray t = mContext.obtainStyledAttributes(attrs, R.styleable.IBadgeView);

        mDefaultTopPadding = t.getDimensionPixelOffset(R.styleable.IBadgeView_badge_padding_top, 0);
        mDefaultRightPadding = t.getDimensionPixelOffset(R.styleable.IBadgeView_badge_padding_right, 0);
        mCount = t.getInteger(R.styleable.IBadgeView_badge_count, 0);
        isShowBadge = t.getBoolean(R.styleable.IBadgeView_badge_none_show, false);
        mDefaultBackgroundColor = t.getColor(R.styleable.IBadgeView_badge_color, mDefaultBackgroundColor);

        init();

        t.recycle();
    }

    /**
     * 初始化画笔
     */
    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mDefaultBackgroundColor);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(mDefaultTextColor);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setFakeBoldText(true);

        resetCount();
    }

    private void resetCount() {
        if (mCount > 99) {
            mCount = 99;
        }

        if (mCount >= 10) {
            mBadgeWidth = getRectWidth();
            mBadgeHeight = getCircleHeight();
        } else if (mCount > 0) {
            mBadgeWidth = getCircleHeight();
            mBadgeHeight = getCircleHeight();
        } else {
            mBadgeHeight = mBadgeWidth = getNone();
        }
        mDefaultRadius = mBadgeWidth / 2;

        mTextPaint.setTextSize(mBadgeHeight * 0.8f);

        mView.invalidate();
    }

    /**
     * 请重写
     *
     * @param canvas
     */
    protected void draw(Canvas canvas) {
        if (isShowBadge) {
            if (mCount < 10) {//圆
                canvas.drawCircle(mViewWidth - mBadgeWidth / 2 - mDefaultRightPadding, mBadgeHeight / 2 + mDefaultTopPadding, mDefaultRadius, mPaint);
            } else {//椭圆
                canvas.drawRoundRect(rectF, (int) (mBadgeWidth * 0.6), (int) (mBadgeWidth * 0.6), mPaint);
            }
            if (mCount > 0) {
                Paint.FontMetricsInt fontMetrics = mTextPaint.getFontMetricsInt();
                int baseline = (mBadgeHeight + 0 - fontMetrics.bottom - fontMetrics.top) / 2;
                canvas.drawText(mCount + "", mViewWidth - mBadgeWidth / 2 - mDefaultRightPadding, baseline + mDefaultTopPadding, mTextPaint);
            }
        }
    }

    /**
     * 请重写
     *
     * @param w
     * @param h
     */
    protected void onSizeChanged(int w, int h) {
        mViewWidth = w;
        mViewHeight = h;

        rectF = new RectF(mViewWidth - mBadgeWidth - mDefaultRightPadding,
                mDefaultTopPadding,
                mViewWidth - mDefaultRightPadding,
                mBadgeHeight + mDefaultTopPadding);
    }

    /**
     * 设置小红点
     *
     * @param count
     * @return
     */
    public IBadgeView setCount(int count) {
        this.mCount = count;
        resetCount();
        return this;
    }

    public IBadgeView setShown(boolean isShowBadge) {
        this.isShowBadge = isShowBadge;
        mView.invalidate();
        return this;
    }

    /**
     * 设置背景颜色
     *
     * @param color
     * @return
     */
    public IBadgeView setBackgroundColor(int color) {
        mPaint.setColor(color);
        mView.invalidate();
        return this;
    }

    /**
     * 设置颜色
     *
     * @param color
     * @return
     */
    public IBadgeView setTextColor(int color) {
        mTextPaint.setColor(color);
        mView.invalidate();
        return this;
    }

    /**
     * 设置红点的半径
     *
     * @param mDefaultRadius 默认值(无数字):6dp
     */
    public IBadgeView setmDefaultRadius(int mDefaultRadius) {
        this.mDefaultRadius = mDefaultRadius;
        mView.invalidate();
        return this;
    }

    /**
     * 设置默认数字颜色值
     *
     * @param mDefaultTextColor
     */
    public IBadgeView setmDefaultTextColor(int mDefaultTextColor) {
        this.mDefaultTextColor = mDefaultTextColor;
        mView.invalidate();
        return this;
    }

    /**
     * 设置红点视图上边距
     *
     * @param mDefaultTopPadding
     */
    public IBadgeView setmDefaultTopPadding(int mDefaultTopPadding) {
        this.mDefaultTopPadding = mDefaultTopPadding;
        mView.invalidate();
        return this;
    }

    /**
     * 设置红点视图右边距
     *
     * @param mDefaultRightPadding
     */
    public IBadgeView setmDefaultRightPadding(int mDefaultRightPadding) {
        this.mDefaultRightPadding = mDefaultRightPadding;
        mView.invalidate();
        return this;
    }

    /**
     * convert dip to px
     *
     * @param dpValue
     * @return
     */
    public int dip2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 得到默认的红点高
     *
     * @return
     */
    public int getCircleHeight() {
        if (mContext.getResources().getDisplayMetrics().densityDpi <= DisplayMetrics.DENSITY_HIGH) {
            return dip2px(mDefaultRadiusDp + 2);
        } else {
            return dip2px(mDefaultRadiusDp * 2);
        }
    }

    /**
     * 得到大于10的红点宽
     *
     * @return
     */
    public int getRectWidth() {
        if (mContext.getResources().getDisplayMetrics().densityDpi <= DisplayMetrics.DENSITY_HIGH) {
            return dip2px(mDefaultRadiusDp * 2);
        } else {
            return dip2px(mDefaultRadiusDp * 2 + 9);
        }
    }

    /**
     * 得到无红点的dp大小
     *
     * @return
     */
    public int getNone() {
        if (mContext.getResources().getDisplayMetrics().densityDpi <= DisplayMetrics.DENSITY_HIGH) {
            return dip2px(mDefaultRadiusDp);
        } else {
            return dip2px(mDefaultRadiusDp + 1);
        }
    }
}
