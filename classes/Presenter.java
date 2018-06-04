#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

#parse("File Header.java")

public interface ${NAME}Presenter extends Presenter <${NAME}View> {
}