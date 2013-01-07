package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.Gauge;

public class ServerPerformanceScreen {
	private static Gauge gauge;
	private static DataTable gaugeData;
	private static Gauge.Options gaugeOptions;
	private static int shop;
	private static final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	private static FlexTable flexTable;

	public static Widget getScreen(int shop) {
		flexTable = new FlexTable();

		ServerPerformanceScreen.shop = shop;

		flexTable.setWidget(0, 0, new HTML("<p>Here is the average speed performance of the web server as calculated by" +
				" our metric system.</p>"));
		flexTable.setWidth("100%");
		flexTable.setWidget(1, 0, getMenu());

		Runnable onLoadCallback = new Runnable() {
			public void run() {
				initGraphics();
				initDataTable(7);

				flexTable.setWidget(2, 0, gauge);
				redrawGraphics(7);
			}
		};
		VisualizationUtils.loadVisualizationApi(onLoadCallback, Gauge.PACKAGE);
		flexTable.setWidget(2, 0, gauge);
		return flexTable;
	}

	private static void initGraphics() {
		gaugeOptions = Gauge.Options.create();
		gaugeOptions.setWidth(400);
		gaugeOptions.setHeight(240);
		gaugeOptions.setGaugeRange(0, 1024);
		//gaugeOptions.setGreenRange(0, 256);
		gaugeOptions.setYellowRange(640, 768);
		gaugeOptions.setRedRange(768, 1024);
	}
	private static void initDataTable(int days) {
		gaugeData = DataTable.create();
		gaugeData.addColumn(ColumnType.NUMBER, "Kb/sec");
		gaugeData.addRow();
		gauge = new Gauge(gaugeData, gaugeOptions);
	}

	private static void redrawGraphics(int daysBack) {
		greetingService.getAverageSpeed(shop, daysBack, new AsyncCallback<Double>() {
			@Override
			public void onFailure(Throwable caught) { System.out.println("Error in RPC");	}
			@Override
			public void onSuccess(Double result) {
				gaugeData.setCell(0, 0, result, result + "", null);
				gauge.draw(gaugeData, gaugeOptions);
			}
		});
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
				redrawGraphics(30);
				month.setDown(true);
				week.setDown(false);
				day.setDown(false);
			}
		});
		week.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				redrawGraphics(7);
				month.setDown(false);
				week.setDown(true);
				day.setDown(false);
			}
		});
		day.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				redrawGraphics(1);
				month.setDown(false);
				week.setDown(false);
				day.setDown(true);
			}
		});

		hp.add(month);
		hp.add(week);
		hp.add(day);
		vp.add(new HTML("Showing results for:"));
		vp.add(hp);
		return vp;
	}
}
