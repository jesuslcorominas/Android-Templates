package com.jesuslcorominas.blank.app.view.adapter.divider;


import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int verticalSpaceHeight;

    @RootContext
    Context context;

    public void setHeightDimen(@DimenRes int verticalSpaceDimen) {
        this.verticalSpaceHeight = context.getResources().getDimensionPixelOffset(verticalSpaceDimen);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;
        outRect.top = verticalSpaceHeight;
    }
}