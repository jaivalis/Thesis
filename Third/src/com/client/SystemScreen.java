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
import com.google.gwt.visualization.client.visualizations.PieChart;
import com.google.gwt.visualization.client.visualizations.PieChart.Options;

public class SystemScreen {
	private static FlexTable ft;

	private static int shop;
	private static final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);



	public static Widget getScreen(int shop, int noOfDays) {
		SystemScreen.shop = shop;

		ft = new FlexTable();

		final int days = noOfDays;

		ft.setWidget(0, 0, new HTML("<p>System information of the visitors of our shop. Operating systems " +
				"they use as well as Browser and Internet Service Provider preferences.<br>" +
				"You can click the pie data below to get precise figures and overall percentages.</p>"));
		ft.getFlexCellFormatter().setColSpan(0, 0, 2);
		Runnable onLoadCallback = new Runnable() {
			public void run() {
				initGraphics();		// those two are require 1 RPC call
				fetchShowData(days);

				//drawGraphics(days);
				ft.setWidget(2, 0, OSPie);
				ft.setWidget(2, 1, tableOS);
				ft.setWidget(3, 0, tableBrowser);
				ft.setWidget(3, 1, BrowserPie);
			}
		};
		VisualizationUtils.loadVisualizationApi(onLoadCallback, PieChart.PACKAGE);

		ft.setWidget(1, 0, getMenu());
		return ft;
	}

	private static void initGraphics() {
		initOSList();
		initOSPie();

		initBrowserList();
		initBrowserPie();
	}

	private static void initBrowserPie() {
		BrowserPieData = DataTable.create();
		BrowserPieData.addColumn(ColumnType.STRING, "Visitors' Browser preferences");
		BrowserPieData.addColumn(ColumnType.NUMBER, "Users");
		BrowserPie = new PieChart(BrowserPieData, createBrowserPieOptions());
	}

	private static void initBrowserList() {
		tableBrowser = new CellTable<MyCell>();
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
		tableBrowser.addColumn(nameColumn, "Browser");
		tableBrowser.addColumn(addressColumn, "users");
	}

	private static PieChart OSPie;
	private static DataTable OSPieData;
	private static CellTable<MyCell> tableOS;

	private static PieChart BrowserPie;
	private static DataTable BrowserPieData;
	private static CellTable<MyCell> tableBrowser;

	private static void initOSPie() {
		OSPieData = DataTable.create();
		OSPieData.addColumn(ColumnType.STRING, "Visitors' Operating System preferences");
		OSPieData.addColumn(ColumnType.NUMBER, "Users");
		OSPie = new PieChart(OSPieData, createOSPieOptions());
	}

	private static Options createBrowserPieOptions() {
		Options options = Options.create();
		options.setWidth(400);
		options.setHeight(240);
		options.set3D(true);
		options.setTitle("Visitors' Browser preferences");
		return options;
	}

	private static Options createOSPieOptions() {
		Options options = Options.create();
		options.setWidth(400);
		options.setHeight(240);
		options.set3D(true);
		options.setTitle("Visitors' Operating System preferences");
		return options;
	}


	private static void initOSList() {
		tableOS = new CellTable<MyCell>();

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

		tableOS.addColumn(nameColumn, "Operating System");
		tableOS.addColumn(addressColumn, "users");
	}

	private static void redrawGraphics(int days) {
		fetchShowData(days);
	}

	private static void fetchShowData(int noOfDays) {
		greetingService.getOSForPastDays(shop, noOfDays, new AsyncCallback<SerializableContainer>() {
			@Override
			public void onFailure(Throwable caught) { System.out.println("Error in RPC");	}
			@Override
			public void onSuccess(SerializableContainer result) {
				fillOSList(result);
				fillOSPieData(result);
				OSPie.draw(OSPieData, createOSPieOptions());
			}
		});

		greetingService.getBrowserForPastDays(shop, noOfDays, new AsyncCallback<SerializableContainer>() {
			@Override
			public void onFailure(Throwable caught) { System.out.println("Error in RPC");	}
			@Override
			public void onSuccess(SerializableContainer result) {
				fillBrowserList(result);
				fillBrowserPieData(result);
				BrowserPie.draw(BrowserPieData, createBrowserPieOptions());
			}
		});
	}

	private static void fillOSPieData(SerializableContainer result) {
		int i = 0;
		OSPieData.removeRows(0, OSPieData.getNumberOfRows());
		for (String key : result.keySet()) {
			OSPieData.addRow();
			OSPieData.setValue(i, 0, key);
			OSPieData.setValue(i++, 1, result.get(key));
		}
		if (OSPieData.getNumberOfRows() == 0) {
			OSPieData.addRow();
		}
	}

	private static List<MyCell> OSCELLS;

	private static void fillOSList(SerializableContainer result) {
		if (result.size() == 0) {
			OSCELLS = new LinkedList<MyCell>();
			OSCELLS.add(new MyCell("No visitors", 0));
			tableOS.setRowCount(0, true);
			tableOS.setRowData(0, OSCELLS);
			return;
		}
		OSCELLS = new LinkedList<MyCell>();
		for ( String key : result.keySet()) {
			OSCELLS.add(new MyCell(key, result.get(key)));
		}
		tableOS.setRowCount(OSCELLS.size(), false);

		// Push the data into the widget.
		tableOS.setRowData(0, OSCELLS);
	}

	private static void fillBrowserPieData(SerializableContainer result) {
		int i = 0;
		BrowserPieData.removeRows(0, BrowserPieData.getNumberOfRows());
		for (String key : result.keySet()) {
			BrowserPieData.addRow();
			BrowserPieData.setValue(i, 0, key);
			BrowserPieData.setValue(i++, 1, result.get(key));
		}
		if (BrowserPieData.getNumberOfRows() == 0) {
			BrowserPieData.addRow();
		}

	}

	private static List<MyCell> BrowserCELLS;

	private static void fillBrowserList(SerializableContainer result) {
		if (result.size() == 0) {
			BrowserCELLS = new LinkedList<MyCell>();
			BrowserCELLS.add(new MyCell("No visitors", 0));
			tableBrowser.setRowCount(0, true);
			tableBrowser.setRowData(0, BrowserCELLS);
			return;
		}
		BrowserCELLS = new LinkedList<MyCell>();
		for ( String key : result.keySet()) {
			BrowserCELLS.add(new MyCell(key, result.get(key)));
		}
		tableBrowser.setRowCount(BrowserCELLS.size(), false);

		tableBrowser.setRowData(0, BrowserCELLS);
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
