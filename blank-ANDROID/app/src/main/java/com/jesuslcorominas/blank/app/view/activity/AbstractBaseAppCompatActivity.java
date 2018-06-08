package com.jesuslcorominas.blank.app.view.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.jesuslcorominas.blank.app.R;
import com.jesuslcorominas.blank.app.event.FakeEvent;
import com.jesuslcorominas.blank.app.presenter.Presenter;
import com.jesuslcorominas.blank.app.utils.Navigator;
import com.jesuslcorominas.blank.app.view.callbackview.CallbackView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.Field;

@EActivity
abstract class AbstractBaseAppCompatActivity<V extends CallbackView> extends AppCompatActivity implements CallbackView {

    abstract void init();

    abstract Presenter<V> getPresenter();

    abstract V getCallbackView();

    abstract void initializeDagger();

    @Bean
    Navigator navigator;

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    private ProgressDialog progressDialog;

    // ==============================
    // Activity
    // ==============================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onPause() {
        super.onPause();

        getPresenter().onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        getPresenter().onResume();

        hideProgress();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    // ==============================
    // Inicializacion
    // ==============================
    @AfterViews
    void afterViews() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        initializeDagger();
        initPresenter();

        init();
    }

    // ==============================
    // EventBus
    // ==============================

    /**
     * Metodo sin funcionalidad unicamente para evitar errores de EventBus.
     *
     * @param event Un evento de mentira que nunca llegara a ejecutarse
     * @see com.jesuslcorominas.blank.app.event.FakeEvent
     */
    @SuppressWarnings("unused")
    @Subscribe
    public void onEvent(FakeEvent event) {
    }

    // ==============================
    // ActionBar
    // ==============================
    @OptionsItem(android.R.id.home)
    void homeSelected() {
        navigator.up(this);
    }

    // ==============================
    // Otros
    // ==============================
    private void initPresenter() {
        Presenter<V> presenter = getPresenter();
        if (presenter == null) {
            throw new NullPointerException("Debes establecer un presenter para la activity");
        }

        presenter.setCallbackView(getCallbackView());
    }

    protected void showError(@StringRes int message) {
        showError(getString(message));
    }

    protected void showError(String message) {
        getDialogBuilder(message).create().show();
    }

    protected AlertDialog.Builder getDialogBuilder(@StringRes int message) {
        return getDialogBuilder(getString(message));
    }

    protected AlertDialog.Builder getDialogBuilder(String message) {
        return new AlertDialog.Builder(this).
                setTitle(R.string.app_name).
                setMessage(message).
                setPositiveButton(R.string.button_accept, null);
    }

    // ==============================
    // CallbackView
    // ==============================
    @UiThread
    @Override
    public void showProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this, R.style.CustomProgressDialog);
            progressDialog.setCancelable(false);

            progressDialog.setIndeterminateDrawable(getDrawable(R.drawable.indeterminate_progress));

            progressDialog.show();
        }
    }

    @UiThread
    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.cancel();
            progressDialog = null;
        }
    }

    @UiThread
    @Override
    public void showUndefinedError() {
        showError(R.string.error_unexpected_message);
    }

    @Override
    public void showConnectionError() {
        showError(R.string.error_connection_message);
    }

    @SuppressLint("RestrictedApi")
    protected void removeShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }

        } catch (NoSuchFieldException e) {
            Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode");
        }
    }
}
