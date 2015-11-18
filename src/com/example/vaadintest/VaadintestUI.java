package com.example.vaadintest;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("vaadintest")
public class VaadintestUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = VaadintestUI.class, widgetset = "com.example.vaadintest.widgetset.VaadintestWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {		
		VerticalLayout cl = new VerticalLayout();
		MyLoginForm lf = new MyLoginForm();
		Panel pl = new Panel(lf);
		pl.setWidth("500px");
		pl.setStyleName("loginPanel");
		cl.addComponent(pl);
	//	cl.setSizeFull();
		setContent(cl);
	}
}