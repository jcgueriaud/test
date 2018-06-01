package com.gmail.jeanchristophe;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datepicker.DatePicker.DatePickerI18n;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Classe utilitaire pour la gestion des fichiers
 * 
 * @author jcgueriaud
 *
 */
public class DateUtils {
	
	//private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final List<String> MONTH_NAMES = Arrays.asList(
			"Janvier", "Février", "Mars", "Avril", "Mai",
        	"Juin", "Juillet", "Août", "Septembre",
        	"Octobre", "Novembre", "Decembre");
	
	private static final List<String> WEEKDAYS = Arrays.asList("Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi");
	
	private static final List<String> WEEKDAYS_SHORT = Arrays.asList("Dim", "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam");
	
	
	public static String getColumnDateJour(LocalDate date){
		String dayOfTheWeek = WEEKDAYS_SHORT.get(date.getDayOfWeek().getValue() % 7);
		return dayOfTheWeek + ". "+ date.getDayOfMonth();
	}
	
	/**
	 * Internationalize the supplied DatePicker component.
	 * @param c the component to process
	 */
	public static void initDatePickerI18n(DatePicker c){
		c.setLocale(Locale.FRANCE);
		c.setI18n(new DatePickerI18n()
        		.setCalendar("Calendrier")
        		.setCancel("Annuler")
        		.setClear("Effacer")
        		.setFirstDayOfWeek(1)
        		.setMonthNames(MONTH_NAMES)
        		.setToday("Aujourd'hui")
        		.setWeek("Semaine")
        		.setWeekdays(WEEKDAYS)
        		.setWeekdaysShort(WEEKDAYS_SHORT));
	}

}
