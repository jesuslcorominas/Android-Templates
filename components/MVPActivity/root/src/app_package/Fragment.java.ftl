package ${packageName}.view.fragment;

import android.app.Activity;

import org.androidannotations.annotations.EFragment;

import ${packageName}.R;

/**
 * {@inheritDoc}
 */
@EFragment (R.layout.fragment_${classToResource(className)})
public class ${className}Fragment extends AbstractBaseFragment {

    private ${className}FragmentInteractionListener listener;
    
    // =============================
    // region View
    // =============================
    
    // endregion
    
    // =============================
    // region NewInstance
    // =============================    
    public static ${className}Fragment newInstance() {
        return ${className}Fragment_.builder().build();
    }    
    
    // endregion

    // =============================
    // region Fragment
    // =============================
    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);

        try {
            listener = (${className}FragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new RuntimeException("Debes implementar " + ${className}FragmentInteractionListener.class.getName());
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
    public interface ${className}FragmentInteractionListener {
    
    }
    
    // endregion
    
    // =============================
    // region Metodos privados
    // =============================
    
    // endregion    
}