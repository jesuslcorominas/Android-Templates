<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/white"
    android:fitsSystemWindows="false">

    <android.support.design.widget.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <include layout="@layout/content_${className?lower_case}" />

</android.support.design.widget.CoordinatorLayout>