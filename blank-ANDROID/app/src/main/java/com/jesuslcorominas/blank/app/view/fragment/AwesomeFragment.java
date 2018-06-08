package com.jesuslcorominas.blank.app.view.fragment;

import android.app.Activity;

import org.androidannotations.annotations.EFragment;

import com.jesuslcorominas.blank.app.R;

/**
 * {@inheritDoc}
 */
@EFragment(R.layout.fragment_awesome)
public class AwesomeFragment extends AbstractBaseFragment {

    private AwesomeFragmentInteractionListener listener;

    // =============================
    // region View
    // =============================

    // endregion

    // =============================
    // region NewInstance
    // =============================    
    public static AwesomeFragment newInstance() {
        return AwesomeFragment_.builder().build();
    }

    // endregion

    // =============================
    // region Fragment
    // =============================
    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);

        try {
            listener = (AwesomeFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new RuntimeException("Debes implementar " + AwesomeFragmentInteractionListener.class.getName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listener = null;
    }

    // endregion

    // =============================
    // region AbstractBaseFragment
    // =============================

    @Override
    void init() {

    }

    // endregion

    // =============================
    // region Events
    // =============================

    // endregion    

    // =============================
    // region Interaction
    // =============================
    public interface AwesomeFragmentInteractionListener {

    }

    // endregion

    // =============================
    // region Metodos privados
    // =============================

    // endregion    
}