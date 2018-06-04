#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import org.androidannotations.annotations.EFragment;

#parse("File Header.java") 
@EFragment (R.layout.fragment_${LAYOUT_NAME})
public class ${NAME}Fragment extends AbstractBaseFragment {

    private ${NAME}FragmentInteractionListener listener;
    
    // =============================
    // region View
    // =============================
    
    // endregion
    
    // =============================
    // region NewInstance
    // =============================    
    public static ${NAME}Fragment newInstance() {
        return ${NAME}Fragment_.builder().build();
    }    
    
    // endregion

    // =============================
    // region Fragment
    // =============================
    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);

        try {
            listener = (${NAME}FragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new RuntimeException("Debes implementar " + ${NAME}FragmentInteractionListener.class.getName());
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
    public interface ${NAME}FragmentInteractionListener {
    
    }
    
    // endregion
    
    // =============================
    // region Metodos privados
    // =============================
    
    // endregion    
}