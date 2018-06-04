#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import dagger.Module;
import dagger.Provides;

#parse("File Header.java")

@Module(includes = {UseCaseModule.class})
public class ${NAME}Module {

    @Provides
    ${NAME}Presenter provide${NAME}Presenter() {
        return new ${NAME}PresenterImpl();
    }
}