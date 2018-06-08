package com.jesuslcorominas.blank.commons.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.util.Calendar;

/**
 * Clase de utilidades para el manejo de fechas de jodatime
 *
 * @see <a href="http://www.joda.org/joda-time/">JodaTime</a>
 * <p>
 */
public class DateUtils {

    /**
     * Constructor privado para evitar la instanciacion
     */
    private DateUtils() {

    }

    /**
     * Formato de fecha y hora utilizado para guardar o enviar
     */
    public static final String DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";

    /**
     * Formato de solo fecha para pintar en pantalla
     */
    public static final String PRINT_DATE_FORMAT = "dd/MM/yyyy";

    /**
     * Formato de fecha con nombre de dia y nombre de mes
     */
    public static final String PRINT_DATE_WITH_DAY_FORMAT = "EEEE, d MMMM";

    /**
     * Formato de fecha y hora
     */
    public static final String PRINT_DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm";

    /**
     * Formato de solo hora
     */
    public static final String TIME_FORMAT = "HH:mm";


    /**
     * Obtiene si una fecha es el dia actual
     *
     * @param date La fecha a comprobar
     * @return True si la fecha es hoy, false en caso contrario
     */
    public static boolean isToday(DateTime date) {
        return date.withTimeAtStartOfDay().equals(today());
    }

    /**
     * Obtiene si una fecha es manana
     *
     * @param date La fecha a comprobar
     * @return True si es manana, false en caso contrario
     */
    public static boolean isTomorrow(DateTime date) {
        return date.withTimeAtStartOfDay().equals(tomorrow());
    }

    /**
     * Obtiene si una fecha es un dia entre semana semana(de lunes a viernes)
     *
     * @param date La fecha a comprobar
     * @return True si es de lunes a viernes, false si es fin de semana
     */
    public static boolean isWeekDay(DateTime date) {
        if (date == null) {
            return false;
        }

        return date.getDayOfWeek() <= DateTimeConstants.FRIDAY;
    }

    /**
     * Obtiene el dia actual a las 00:00:00
     *
     * @return El dia actual a las 00:00:00
     */
    public static DateTime today() {
        return new DateTime().withTimeAtStartOfDay();
    }

    /**
     * Obtiene el dia de manana a las 00:00:00
     *
     * @return El dia de manana a las 00:00:00
     */
    public static DateTime tomorrow() {
        return DateUtils.today().plusDays(1);
    }

    /**
     * Convierte una fecha en formato {@link DateTime} en una en formato {@link Calendar}
     *
     * @param date La fecha a convertir
     * @return La fecha en formato {@link Calendar}
     */
    private static Calendar getCalendarFromDateTime(DateTime date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYear(), date.getMonthOfYear() - 1, date.getDayOfMonth());

        return calendar;
    }
}
