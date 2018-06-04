<?xml version="1.0"?>
<recipe>
 
    <instantiate from="src/app_package/CallbackView.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view/callbackview/${className}View.java" />
    <instantiate from="src/app_package/Activity.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view/activity/${className}Activity.java" />
   <instantiate from="src/app_package/Fragment.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view/fragment/${className}Fragment.java" />				   				   				   				   
    <instantiate from="src/app_package/Presenter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/presenter/${className}Presenter.java" />
   <instantiate from="src/app_package/PresenterImpl.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/presenter/impl/${className}PresenterImpl.java" />
   <instantiate from="src/app_package/Component.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/di/component/${className}Component.java" />				   
   <instantiate from="src/app_package/Module.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/di/module/${className}Module.java" />				   				   
	
   <instantiate from="res/layout/fragment.xml.ftl"
				   to="${escapeXmlAttribute(resOut)}/layout/fragment_${classToResource(className)}.xml" />

   <instantiate from="res/layout/activity.xml.ftl"
				   to="${escapeXmlAttribute(resOut)}/layout/activity_${classToResource(className)}.xml" />				   

   <instantiate from="res/layout/content.xml.ftl"
				   to="${escapeXmlAttribute(resOut)}/layout/content_${classToResource(className)}.xml" />				   
 
   <merge from="AndroidManifest.xml.ftl"
           to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />
		   
    <open file="${srcOut}/App.java"/>
</recipe>