package com.frame.kotlintoolkit.presentation.indicatorseekbar;

import android.view.View;

import com.frame.kotlintoolkit.R;
import com.frame.kotlintoolkit.presentation.indicatorseekbar.utils.IndicatorSeekBar;

/**
 * created by zhuangguangquan on  2017/9/6
 */

public class IndicatorFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.custom_indicator;
    }

    @Override
    protected void initView(View root) {
        //custom indicator text by java code
        IndicatorSeekBar seekBarWithProgress = root.findViewById(R.id.custom_indicator_by_java_code);
        seekBarWithProgress.setIndicatorTextFormat("${PROGRESS} %");

        //custom indicator text by java code
        IndicatorSeekBar seekBarWithTickText = root.findViewById(R.id.custom_indicator_by_java);
        seekBarWithTickText.setIndicatorTextFormat("${TICK_TEXT} --");
    }
}
