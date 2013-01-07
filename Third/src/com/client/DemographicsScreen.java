package com.client;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
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
import com.google.gwt.visualization.client.visualizations.GeoMap;

public class DemographicsScreen {
	private static GeoMap geoMap;
	private static FlexTable ft;
	private static DataTable dataTable;
	private static GeoMap.Options options;


	private static CellTable<MyCell> table;
	private static List<MyCell> CELLS;

	public static int shop;

	private static final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	public static FlexTable getDemographicsScreen(int shop, int noOfDays) {
		ft = new FlexTable();

		DemographicsScreen.shop = shop;
		final int days = noOfDays;
		Runnable onLoadCallback = new Runnable() {
			public void run() {
				drawGraphics(days);		// those two are require 1 RPC call
			}
		};
		VisualizationUtils.loadVisualizationApi(onLoadCallback, GeoMap.PACKAGE);
		return ft;
	}

	private static void drawGraphics(int noOfDays) {
		options = GeoMap.Options.create();
		options.setRegion("world");

		createDataTable(noOfDays);

		geoMap = new GeoMap(dataTable, options);
		ft.setWidget(0, 0, new HTML("<p>Demographic information about the visitors of our shop. Where " +
				"their requests originate from, as well as their preference in language of the site.<br>" +
				"You can hover on the map below to get exact visits by country.</p>"));
		ft.getFlexCellFormatter().setColSpan(0, 0, 4);
		ft.setWidget(1, 0, geoMap);
		ft.getFlexCellFormatter().setColSpan(1, 0, 2);

		initDemographicsList();

		VerticalPanel vp = new VerticalPanel();
		vp.add(getMenu());
		vp.add(table);
		ft.setWidget(1, 1, vp);
	}


	private static void initDemographicsList() {
		table = new CellTable<MyCell>();

		TextColumn<MyCell> nameColumn = new TextColumn<MyCell>() {
			@Override
			public String getValue(MyCell cell) {
				return cell.getStrVal();
			}
		};

		TextColumn<MyCell> addressColumn = new TextColumn<MyCell>() {
			@Override
			public String getValue(MyCell cell) {
				return cell.getNumVal() + "";
			}
		};

		table.addColumn(nameColumn, "Country code");
		table.addColumn(addressColumn, "# of visits");
	}

	private static void createDataTable(int noOfDays) {
		dataTable = DataTable.create();
		dataTable.addRows(2);
		dataTable.addColumn(ColumnType.STRING, "ADDRESS", "address");
		dataTable.addColumn(ColumnType.NUMBER, "Visits", "color");

		greetingService.getVisitorLocationsForDateRange(shop, null, noOfDays, new AsyncCallback<SerializableContainer>() {
			@Override
			public void onFailure(Throwable caught) { System.out.println("Error in RPC");	}
			@Override
			public void onSuccess(SerializableContainer result) {
				fillCellList(result);
				fillDataTable(result);
			}
		});
	}

	private static void fillDataTable(SerializableContainer result) {
		int i = 0;
		dataTable.removeRows(0, dataTable.getNumberOfRows());
		//dataTable.removeColumns(1, dataTable.getNumberOfColumns());
		for (String key : result.keySet()) {
			dataTable.addRow();
			dataTable.setValue(i, 0, key);
			dataTable.setValue(i++, 1, result.get(key));
		}
		if (dataTable.getNumberOfRows() == 0) {
			dataTable.addRow();
		}
		geoMap.draw(dataTable, options);
	}

	private static void fillCellList(SerializableContainer result) {
		if (result.size() == 0) {
			CELLS = new LinkedList<MyCell>();
			CELLS.add(new MyCell("No visitors", 0));
			table.setRowCount(0, true);
			table.setRowData(0, CELLS);
			return;
		}
		CELLS = new LinkedList<MyCell>();
		for ( String key : result.keySet()) {
			CELLS.add(new MyCell(key, result.get(key)));
		}
		table.setRowCount(CELLS.size(), false);

		// Push the data into the widget.
		table.setRowData(0, CELLS);
	}

	public static void redrawGraphics(int days) {
		greetingService.getVisitorLocationsForDateRange(shop, null, days, new AsyncCallback<SerializableContainer>() {
			@Override
			public void onFailure(Throwable caught) { System.out.println("Error in RPC");	}
			@Override
			public void onSuccess(SerializableContainer result) {
				fillCellList(result);
				fillDataTable(result);
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
				redrawGraphics(0);
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










