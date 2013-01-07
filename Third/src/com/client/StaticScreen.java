package com.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.GeoMap;

public class StaticScreen {

	//private static final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	private static int shop;

	private static FlexTable fTable;
	public static FlexTable drawPlot(int shop) {
		fTable = new FlexTable();

		StaticScreen.shop = shop;
		Runnable onLoadCallback = new Runnable() {
			public void run() {
				drawChart(StaticScreen.shop);
			}
		};
		VisualizationUtils.loadVisualizationApi(onLoadCallback, GeoMap.PACKAGE);
		return fTable;
	}


	public static void drawChart(int shop) {

	}

	public static Widget getMenu() {
		HorizontalPanel hp = new HorizontalPanel();
		VerticalPanel vp = new VerticalPanel();

		final ToggleButton month = new ToggleButton("Last Month");
		final ToggleButton week = new ToggleButton("Last Week");
		final ToggleButton day = new ToggleButton("Today");

		week.setDown(true);

		month.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				month.setDown(true);
				week.setDown(false);
				day.setDown(false);
				StaticLineChartGV.redraw(StaticScreen.shop, 30);
			}
		});
		week.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				month.setDown(false);
				week.setDown(true);
				day.setDown(false);
				StaticLineChartGV.redraw(StaticScreen.shop, 7);
			}
		});
		day.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				month.setDown(false);
				week.setDown(false);
				day.setDown(true);
				StaticLineChartGV.redraw(StaticScreen.shop, 1);
			}
		});

		hp.add(month);
		hp.add(week);
		hp.add(day);
		vp.add(new HTML("Showing results for:"));
		vp.add(hp);
		return vp;
	}

	public static FlexTable getScreen(int shop, int noOfDays) {
		FlexTable flexTable = new FlexTable();

		flexTable.setWidget(0, 0, new HTML("<p>This screen provides an overview of the last visits of our shop in " +
				"a weekly basis with a 30 minute precision.<br>You can hover on the points of the graph to see " +
				"the exact date it represents.</p>"));
		flexTable.setWidget(1, 0, getMenu());
		flexTable.setWidget(2, 0, StaticLineChartGV.getOnlineHistory(1440 * noOfDays));
		flexTable.getFlexCellFormatter().setColSpan(2, 0, 4);

		return flexTable;
	}

}
