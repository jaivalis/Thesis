package com.client;

import java.util.Date;

import ca.nanometrics.gflot.client.DataPoint;
import ca.nanometrics.gflot.client.PlotModel;
import ca.nanometrics.gflot.client.PlotModelStrategy;
import ca.nanometrics.gflot.client.SeriesHandler;
import ca.nanometrics.gflot.client.SimplePlot;
import ca.nanometrics.gflot.client.event.PlotHoverListener;
import ca.nanometrics.gflot.client.event.PlotItem;
import ca.nanometrics.gflot.client.event.PlotPosition;
import ca.nanometrics.gflot.client.jsni.Plot;
import ca.nanometrics.gflot.client.options.AxisOptions;
import ca.nanometrics.gflot.client.options.GlobalSeriesOptions;
import ca.nanometrics.gflot.client.options.GridOptions;
import ca.nanometrics.gflot.client.options.LineSeriesOptions;
import ca.nanometrics.gflot.client.options.PlotOptions;
import ca.nanometrics.gflot.client.options.PointsSeriesOptions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class RealTimeScreen {

	private static final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	private static Timer timeoutTimer = null;
	private static boolean abortFlag = false;
	static final int TIMEOUT = 4;

	private static SimplePlot plot;
	private static SeriesHandler plotSeries;

	private static Button freezeButton;


	public static FlexTable getRealTimeScreen() {
		abortFlag = false;
		FlexTable flexTable = new FlexTable();

		freezeButton = new Button("Freeze!");

		initializePlot();

		timeoutTimer = new Timer() {
			public void run() {
				if (!abortFlag) {
					updateActiveSessions();
					updateActiveSessionsChart();
				}
			}
		};
		timeoutTimer.scheduleRepeating(TIMEOUT * 1000);

		freezeButton = new Button("Freeze!");
		freezeButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if (!abortFlag) {
					abortFlag = true;
					freezeButton.setText("Resume");
				} else {
					abortFlag = false;
					freezeButton.setText("Freeze!");
				}
			}
		});

		flexTable.setWidget(0, 0, new HTML("<p>Real time visitor chart. Hover on the chart to view each specific timestamp" +
				" and its value at that time.</p>"));
		//ft.setWidget(1, 0, getActiveSessions());
		flexTable.setWidget(1, 0, plot);
		flexTable.setWidget(2, 1, freezeButton);
		return flexTable;
	}

	private static void initializePlot() {
		PlotModel model = new PlotModel( PlotModelStrategy.downSamplingStrategy(20) );
		PlotOptions plotOptions = new PlotOptions();
		plotOptions.setGlobalSeriesOptions( new GlobalSeriesOptions()
		.setLineSeriesOptions( new LineSeriesOptions().setLineWidth(1).setShow(true).setFill(true) )
		.setPointsOptions( new PointsSeriesOptions().setRadius(2).setShow(true) ).setShadowSize(0d) );
		plotOptions.addXAxisOptions( new AxisOptions().setShow(false) );
		plotOptions.addYAxisOptions( new AxisOptions().setMinimum(0));

		plotSeries = model.addSeries( "Active Visitors", "#FF9900" );

		plot = new SimplePlot( model, plotOptions );

		plotOptions.setGridOptions( new GridOptions().setHoverable( true ) );

		final PopupPanel popup = new PopupPanel();
		final Label label = new Label();
		popup.add( label );

		plot.addHoverListener( new PlotHoverListener() {
			public void onPlotHover( Plot plot, PlotPosition position, PlotItem item ) {
				if ( item != null ) {
					String text = new Date((long)item.getDataPoint().getX()) + ", " + (int)item.getDataPoint().getY() + " visit(s)";

					label.setText( text );
					popup.setPopupPosition( item.getPageX() + 10, item.getPageY() - 25 );
					popup.show();
				}
				else {
					popup.hide();
				}
			}
		}, false );

	}

	@SuppressWarnings("deprecation")
	private static void updateActiveSessionsChart() {
		greetingService.getActiveSessionsForThePastXMins(15, 3, new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				GWT.log( "Something went wrong", caught );
			}
			public void onSuccess(Integer result) {
				Date currentDate = new Date();
				plotSeries.add(new DataPoint( Date.UTC( currentDate.getYear(),
						currentDate.getMonth(), currentDate.getDate(), currentDate.getHours(), currentDate.getMinutes(),
						currentDate.getSeconds() ), result) );
				plot.redraw();
			}
		});

	}

	private static Label onlineusers;
	private static void updateActiveSessions() {
		onlineusers = new Label();
		greetingService.getActiveSessionsForThePastXMins(15, 10, new AsyncCallback<Integer>() {
			@Override
			public void onFailure( Throwable caught ) {
				GWT.log( "Something went wrong", caught );
			}
			@Override
			public void onSuccess(Integer result) {
				onlineusers.setText("Active sessions for the past 10 minutes: " + result);
				//System.out.println("getActiveSessionsForThePast10mins: " + result);
			}
		});
	}

	//	private static void cancelTimer() {
	//		if (timeoutTimer != null) {
	//			timeoutTimer.cancel();
	//			timeoutTimer = null;
	//		}
	//	}

	public static void stop() {
		abortFlag = true;
	}

}
