package com.example.vaadintest;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.UI;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.DateClickEvent;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventClick;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.RangeSelectEvent;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.WeekClick;
import com.vaadin.ui.components.calendar.event.BasicEventProvider;
import com.vaadin.ui.components.calendar.handler.BasicDateClickHandler;
import com.vaadin.ui.components.calendar.handler.BasicWeekClickHandler;

public class Home extends UI{
	Calendar calendar;
	
	@WebServlet(value = "/ni", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Home.class, widgetset = "com.example.vaadintest.widgetset.VaadintestWidgetset")
	public static class Servlet extends VaadinServlet {
	}
    private void initCalendar() {
    	BasicEventProvider dataSource = new BasicEventProvider();
 
        calendar = new Calendar(dataSource);
        calendar.setLocale(Locale.getDefault());
        calendar.setImmediate(true);
        calendar.setSizeFull();
 
        GregorianCalendar gregorianCalendar = new GregorianCalendar(calendar.getLocale());
        boolean showWeeklyView = false;
        if (!showWeeklyView) {
            final int rollAmount = gregorianCalendar
                    .get(GregorianCalendar.DAY_OF_MONTH) - 1;
            gregorianCalendar.add(GregorianCalendar.DAY_OF_MONTH, -rollAmount);
         //   resetTime(false);
            Date currentMonthsFirstDate = gregorianCalendar.getTime();
            calendar.setStartDate(currentMonthsFirstDate);
            gregorianCalendar.add(GregorianCalendar.MONTH, 1);
            gregorianCalendar.add(GregorianCalendar.DATE, -1);
            calendar.setEndDate(gregorianCalendar.getTime());
        }
 
        addCalendarEventListeners();
    }
 
    private void addCalendarEventListeners() {
        // Register week clicks by changing the schedules start and end dates.
        calendar.setHandler(new BasicWeekClickHandler() {
 
            @Override
            public void weekClick(final WeekClick event) {
                // let BasicWeekClickHandler handle calendar dates, and update
                // only the other parts of UI here
                super.weekClick(event);
               // switchToWeekView();
            }
        });
    }

	@Override
	protected void init(VaadinRequest request) {
		initCalendar();
		
	}
}
