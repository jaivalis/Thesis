package com.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Third implements EntryPoint {

	private static UsefulHorizontalPanel horizontalPanel;
	private static int shop;

	@Override
	public void onModuleLoad() {
		shop = 15;
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		rootPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		rootPanel.setSize("100%", "700px");

		SimplePanel headerPanel = new SimplePanel();
		headerPanel.add(new Image("/ico/logo.jpg"));
		rootPanel.add(headerPanel, 0, 0);
		headerPanel.setSize("100%", "20%");

		horizontalPanel = new UsefulHorizontalPanel();
		rootPanel.add(horizontalPanel, 0, 103);
		horizontalPanel.setSize("100%", "70%");

		StackLayoutPanel stackLayoutPanel = new StackLayoutPanel(Unit.EM);
		horizontalPanel.add(stackLayoutPanel);
		horizontalPanel.setCellHeight(stackLayoutPanel, "250px");
		horizontalPanel.setCellWidth(stackLayoutPanel, "170px");

		Label staticAnalyticsMenu = new Label("Static Analytics");
		stackLayoutPanel.add(getStaticMenu(), staticAnalyticsMenu, 2.0);

		Label realtimeAnalyticsMenuItem = new Label("Real time Analytics");
		stackLayoutPanel.add(getRealTimeMenu(), realtimeAnalyticsMenuItem, 2.0);

		Label serverPerformanceMenuItem = new Label("Server Performance");
		stackLayoutPanel.add(getServerPerformanceMenu(), serverPerformanceMenuItem, 2.0);

		stackLayoutPanel.setSize("190px", "100%");

		FlowPanel flowPanel = new FlowPanel();
		//flowPanel.add(StaticScreen.getStaticScreen(15));
		flowPanel.addStyleName("cw-FlowPanel");
		horizontalPanel.add(flowPanel);
		flowPanel.setSize("100%", "100%");

		SimplePanel footerPanel = new SimplePanel();
		//footerPanel.add(new HTML("© 2012"));
		rootPanel.add(footerPanel, 0, 455);
		footerPanel.setSize("100%", "10%");
	}

	public Widget getStaticMenu() {
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.add(new HTML());
		vPanel.setSpacing(5);
		vPanel.setWidth("100%");
		vPanel.addStyleName("cw-FlowPanel");

		Anchor staticVisits = new Anchor("Visits History");
		staticVisits.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RealTimeScreen.stop();
				horizontalPanel.replace(1, StaticScreen.getScreen(shop, 7));
			}
		});
		vPanel.add(staticVisits);

		Anchor demographics = new Anchor("Demographics");
		demographics.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RealTimeScreen.stop();
				horizontalPanel.replace(1, DemographicsScreen.getDemographicsScreen(shop, 7));
			}
		});
		vPanel.add(demographics);

		Anchor system = new Anchor("Users' system info");
		system.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RealTimeScreen.stop();
				horizontalPanel.replace(1, SystemScreen.getScreen(shop, 7));
			}
		});
		vPanel.add(system);

		Anchor referer = new Anchor("Traffic sources");
		referer.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RealTimeScreen.stop();
				horizontalPanel.replace(1, RefererScreen.getScreen(shop, -1));
			}
		});
		vPanel.add(referer);

		return vPanel;
	}

	public Widget getRealTimeMenu() {
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.add(new HTML());
		vPanel.setSpacing(5);
		vPanel.setWidth("100%");
		vPanel.addStyleName("cw-FlowPanel");

		Anchor vMonitor = new Anchor("Visit monitor");
		vMonitor.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RealTimeScreen.stop();
				horizontalPanel.replace(1, RealTimeScreen.getRealTimeScreen());
			}
		});
		vPanel.add(vMonitor);
		return vPanel;
	}

	private Widget getServerPerformanceMenu() {
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.add(new HTML());
		vPanel.setSpacing(5);
		vPanel.setWidth("100%");
		vPanel.addStyleName("cw-FlowPanel");
		Anchor avgPerf = new Anchor("Average performance metrics");
		avgPerf.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				horizontalPanel.replace(1, ServerPerformanceScreen.getScreen(shop));
			}
		});
		vPanel.add(avgPerf);

		return vPanel;
	}




}