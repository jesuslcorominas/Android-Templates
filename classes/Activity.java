#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

#parse("File Header.java") 
@SuppressLint("Registered")
@EActivity (R.layout.activity_${LAYOUT_NAME})
public class ${NAME}Activity extends AbstractBaseAppCompatActivity <${NAME}View> implements ${NAME}View,
    ${NAME}Fragment.${NAME}FragmentInteractionListener {
    
    @Inject
    ${NAME}Presenter presenter;

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
    Presenter<${NAME}View> getPresenter() {
        return presenter;
    }
    
    @Override
    ${NAME}View getCallbackView() {
        return this;
    } 
    
    @Override
    void initializeDagger() {
        ((App) getApplication()).get${NAME}Component().inject(this);
    }
    // endregion
    
    // =============================
    // region CallbackView
    // =============================
    
    // endregion
    
    // =============================
    // region ${NAME}Fragment.${NAME}FragmentInteractionListener
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