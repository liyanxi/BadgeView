package com.itingchunyu.badgeview;

/**
 * 红点view 需要实现接口
 * Created by liyanxi on 16/9/26.
 * Copyright (c) 2016 www.zhengshijr.com. All rights reserved.
 */
public interface IBadgeView {
    /**
     * 设置数值
     * @param count
     * @return
     */
    BadgeViewUtil setBadgeCount(int count);

    /**
     * 设置是否显示
     * @param isShowBadge
     * @return
     */
    BadgeViewUtil setBadgeShown(boolean isShowBadge);

    /**
     * 设置小点颜色
     * @param color
     * @return
     */
    BadgeViewUtil setBadgeColor(int color);

    /**
     * 设置视图上边距
     * @param mDefaultTopPadding
     * @return
     */
    BadgeViewUtil setmDefaultTopPadding(int mDefaultTopPadding);

    /**
     * 设置视图右边距
     * @param mDefaultRightPadding
     * @return
     */
    BadgeViewUtil setmDefaultRightPadding(int mDefaultRightPadding);
}
