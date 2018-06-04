<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:animateLayoutChanges="true"
    android:orientation="horizontal"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:showIn="@layout/activity_${className?lower_case}">

    <FrameLayout
        android:id="@+id/content_${className?lower_case}_frameLayout_content"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>