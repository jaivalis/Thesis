package com.client;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.Gauge;

public class RefererScreen {
	private static int shop;
	private static final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	private static FlexTable flexTable;

	private static CellTable<MyCell> referers;
	private static List<MyCell> refererList;

	public static Widget getScreen(int shop, int days) {
		flexTable = new FlexTable();

		RefererScreen.shop = shop;

		final int daysBack = days;
		flexTable.setWidget(0, 0, new HTML("<p>Here are the sites that link to your site. (A social media mentions and followers screens could" +
				" be added in the future. Requires facebook, twitter etc. API)</p>"));
		flexTable.setWidth("100%");
		//flexTable.setWidget(1, 0, getMenu());

		Runnable onLoadCallback = new Runnable() {
			public void run() {
				initDataTable();
				flexTable.setWidget(2, 0, referers);
				redrawGraphics(daysBack);
			}
		};
		VisualizationUtils.loadVisualizationApi(onLoadCallback, Gauge.PACKAGE);
		return flexTable;
	}

	private static void initDataTable() {
		referers = new CellTable<MyCell>();
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
		referers.addColumn(nameColumn, "Site");
		referers.addColumn(addressColumn, "Number of Hits");
	}

	private static void drawDataTable(SerializableContainer result) {
		if (result.size() == 0) {
			refererList = new LinkedList<MyCell>();
			refererList.add(new MyCell("No visitors", 0));
			referers.setRowCount(0, true);
			referers.setRowData(0, refererList);
			return;
		}
		refererList = new LinkedList<MyCell>();
		for ( String key : result.keySet()) {
			if (!key.equals("deliberate hits")) {
				refererList.add(new MyCell(key, result.get(key)));
			}
		}
		referers.setRowCount(refererList.size(), false);
		referers.setRowData(0, refererList);
	}

	private static void redrawGraphics(int daysBack) {
		greetingService.getReferersForPastDays(shop, daysBack, new AsyncCallback<SerializableContainer>() {
			@Override
			public void onFailure(Throwable caught) { System.out.println("Error in RPC");	}
			@Override
			public void onSuccess(SerializableContainer result) {
				if (result!=null) {
					flexTable.setWidget(1, 0, new HTML("You have had " + result.get("deliberate hits") + " deliberate visits." +
							"<p>These are your referer sites with the number of hits that originate from of them.</p>"));
					drawDataTable(result);
				}
			}
		});
	}
}
