# Android-Templates
Plantillas para crear rápidamente un proyecto, activities o clases preconfiguradas

## Proyecto
// **TODO** crear

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

* Activity > res/layout/activity_[NOMBRE].xml
* Content > res/layout/content_[NOMBRE].xml
* Fragment > res/layout/fragment_[NOMBRE].xml

Además, se modifica el fichero AndroidManifest para agregar la nueva Activity.

// **TODO** pendiente hacer un merge del fichero App para que agregue el método getComponent del nuevo Component creado. Ahora mismo, al agregar la Activity el proyecto deja de compilar hasta que se agregue ese método.

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
