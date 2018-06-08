package com.jesuslcorominas.blank.app.view.activity;

import android.annotation.SuppressLint;

import com.jesuslcorominas.blank.app.App;
import com.jesuslcorominas.blank.app.R;
import com.jesuslcorominas.blank.app.presenter.AwesomePresenter;
import com.jesuslcorominas.blank.app.presenter.Presenter;
import com.jesuslcorominas.blank.app.utils.LicensesUtils;
import com.jesuslcorominas.blank.app.view.callbackview.AwesomeView;
import com.jesuslcorominas.blank.app.view.fragment.AwesomeFragment;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;

import javax.inject.Inject;

/**
 * {@inheritDoc}
 */
@SuppressLint("Registered")
@EActivity(R.layout.activity_awesome)
@OptionsMenu(R.menu.menu_awesome)
public class AwesomeActivity extends AbstractBaseAppCompatActivity<AwesomeView> implements AwesomeView,
        AwesomeFragment.AwesomeFragmentInteractionListener {

    @Inject
    AwesomePresenter presenter;

    // =============================
    // region Activity
    // =============================

    // endregion

    // =============================
    // region AbstractBaseAppCompatActivity
    // =============================
    @Override
    void init() {

    }

    @Override
    Presenter<AwesomeView> getPresenter() {
        return presenter;
    }

    @Override
    AwesomeView getCallbackView() {
        return this;
    }

    @Override
    void initializeDagger() {
        ((App) getApplication()).getAwesomeComponent().inject(this);
    }

    // endregion

    // ==============================
    // Menu
    // ==============================
    @OptionsItem(R.id.item_menu_copyright)
    void showLicenses() {
        LicensesUtils.showLicenses(this);
    }

    // =============================
    // region CallbackView
    // =============================

    // endregion

    // =============================
    // region AwesomeFragment.AwesomeFragmentInteractionListener
    // =============================

    // endregion    

    // =============================
    // region Llamadas al Presenter
    // =============================

    // endregion

    // =============================
    // region Metodos privados
    // =============================

    // endregion
}