package com.jesuslcorominas.blank.app.view.adapter.divider;


import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class HorizontalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int horizontalSpaceWidth;

    @RootContext
    Context context;

    public void setWidthDimen(@DimenRes int horizontalSpaceWidthDimen) {
        this.horizontalSpaceWidth = context.getResources().getDimensionPixelOffset(horizontalSpaceWidthDimen);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.right = horizontalSpaceWidth;
        outRect.left = horizontalSpaceWidth;
    }
}