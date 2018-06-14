# Android-Templates
Plantillas para crear rápidamente un proyecto, activities o clases preconfiguradas

## Proyecto
Plantilla de proyecto en blanco.

// TODO explicar la plantilla
// TODO comentar el codigo

## Componentes
En la carpeta **components** puedes encontrar plantillas para crear de una sola vez componentes complejos, como activities o fragments. Copia las carpetas de las plantillas que te interesen en 

`[CARPETA_ANDROID_STUDIO]\plugins\android\lib\templates\other`

Con esto, cuando hagas en AndroidStudio **clic derecho > nuevo**, en la sección Other tendrás el elemento importado.

### Activity
Con la plantilla Activity se crea todo lo necesario para tener una Activity con el patrón MVP. Debes darle un nombre a la funcionalidad y todos los ficheros se nombrarán a partir de él. Las clases y ficheros que se generan son:

#### Clases

* Activity > [package_name]/view/activity/[NOMBRE]Activity.java
* CallbackView > [package_name]/view/callbackview/[NOMBRE]View.java
* Presenter > [package_name]/presenter/[NOMBRE]Presenter.java
* PresenterImpl > [package_name]/presenter/impl/[NOMBRE]PresenterImpl.java
* Fragment > [package_name]/view/fragment/[NOMBRE]Fragment.java
* Dagger Compent > [package_name]/di/component/[NOMBRE]Component.java
* Dagger Module > [package_name]/di/module/[NOMBRE]Module.java

#### Layouts
// TODO arreglar el nombrado de content_className en activity_layout y content_className_frameLayout en content_layout

* Activity > res/layout/activity_[NOMBRE].xml
* Content > res/layout/content_[NOMBRE].xml
* Fragment > res/layout/fragment_[NOMBRE].xml

Además, se modifica el fichero AndroidManifest para agregar la nueva Activity.

Al crear la Activity hay que modificar el fichero App.java para agregar el nuevo Component de Dagger y el método para obtenerlo. El problema es que no se puede hacer un merge del fichero java.

// **TODO** plugin para AndroidStudio que haga un merge con el fichero App.java para agregar:


    import [package_name].di.component.[NOMBRE]Component;

    import [package_name].di.component.Dagger[NOMBRE]Component;
    
    ...
    
    public class App extends Application {
    
    ...
       
    private [NOMBRE]Component [nombre]Component;	
	
    ...	
    
    @Override
    public void onCreate() {
        super.onCreate();		
		
        ...		
      
        [nombre]Component = Dagger[NOMBRE]Component.builder().build();		
    }		
     
    ...	
    
    public [NOMBRE]Component get[NOMBRE]Component() {
        return [nombre]Component;
    }
    
### SplashActivity
// TODO crear	
	
### LoginActivity
// TODO crear

### RecyclerActivity
// TODO crear

## Classes
Puedes crear rápidamente clases con la estructura básica ya definida. Copia el contenido de la carpeta **classes** en 

`[CARPETA_USUARIO]\.Android[VERSION]\config\fileTemplates`

* Activity
* CallbackView
* DaggerActivityComponent
* DaggerActivityModule
* Fragment
* Presenter
* PresenterImpl

## Documentación y enlaces de interés
* [http://www.i-programmer.info/professional-programmer/resources-and-tools/6845-android-adt-template-format-document.html](http://www.i-programmer.info/professional-programmer/resources-and-tools/6845-android-adt-template-format-document.html)
* [https://freemarker.apache.org/docs/](https://freemarker.apache.org/docs/)
* [https://freemarker.apache.org/docs/ref_builtins_string.html](https://freemarker.apache.org/docs/ref_builtins_string.html)
* [https://riggaroo.co.za/custom-file-template-group-android-studiointellij/](https://riggaroo.co.za/custom-file-template-group-android-studiointellij/)
* [https://coderwall.com/p/fsxvyw/file-templates-in-android-studio](https://coderwall.com/p/fsxvyw/file-templates-in-android-studio)
