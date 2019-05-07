package ${packageName}.view.activity;

import android.annotation.SuppressLint;

import ${packageName}.App;
import ${packageName}.R;

import ${packageName}.presenter.${className}Presenter;
import ${packageName}.presenter.Presenter;

import ${packageName}.view.callbackview.${className}View; 
import ${packageName}.view.fragment.${className}Fragment; 

import org.androidannotations.annotations.EActivity;
import javax.inject.Inject;

/**
 * {@inheritDoc}
 */
@SuppressLint("Registered")
@EActivity (R.layout.activity_${classToResource(className)})
public class ${className}Activity extends AbstractBaseAppCompatActivity<${className}View> implements ${className}View, 
	${className}Fragment.${className}FragmentInteractionListener {
 
    @Inject
    ${className}Presenter presenter;

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
    Presenter<${className}View> getPresenter() {
        return presenter;
    }
    
    @Override
    ${className}View getCallbackView() {
        return this;
    } 
    
    @Override
    void initializeDagger() {
        ((App) getApplication()).get${className}Component().inject(this);
    }
    // endregion
    
    // =============================
    // region CallbackView
    // =============================
    
    // endregion
    
    // =============================
    // region ${className}Fragment.${className}FragmentInteractionListener
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