#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import javax.inject.Singleton;

import dagger.Component;

#parse("File Header.java")
@Singleton
@Component(modules = {${NAME}Module.class})
public interface ${NAME}Component {

    void inject(${NAME}Activity activity);
}

