package com.itingchunyu.badgeview;

/**
 * 红点view 需要实现接口
 * Created by liyanxi on 16/9/26.
 * Copyright (c) 2016 www.zhengshijr.com. All rights reserved.
 */
public interface IBadgeViewImpl {
    /**
     * 设置数值
     * @param count
     * @return
     */
    IBadgeView setBadgeCount(int count);

    /**
     * 设置是否显示
     * @param isShowBadge
     * @return
     */
    IBadgeView setBadgeShown(boolean isShowBadge);

    /**
     * 设置小点颜色
     * @param color
     * @return
     */
    IBadgeView setBadgeColor(int color);

    /**
     * 设置视图上边距
     * @param mDefaultTopPadding
     * @return
     */
    IBadgeView setmDefaultTopPadding(int mDefaultTopPadding);

    /**
     * 设置视图右边距
     * @param mDefaultRightPadding
     * @return
     */
    IBadgeView setmDefaultRightPadding(int mDefaultRightPadding);
}
