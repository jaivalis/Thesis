package com.client;

import java.util.Date;

import ca.nanometrics.gflot.client.DataPoint;
import ca.nanometrics.gflot.client.PlotModel;
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
import ca.nanometrics.gflot.client.options.TimeSeriesAxisOptions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class StaticLineChartGV {

	private static SimplePlot plot;
	private static final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	public static VerticalPanel getOnlineHistory(int minutes) {
		final VerticalPanel vp = new VerticalPanel();
		final int mins = minutes;
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			public void execute() {
				drawPlot(mins);
				vp.add(plot);

			}
		});
		return vp;
	}

	public static void drawPlot(int minutes) {
		model = new PlotModel();
		PlotOptions plotOptions = new PlotOptions();
		//plotOptions.setLegendOptions( new LegendOptions().setBackgroundOpacity(0).setPosition( LegendPosition.NORTH_WEST ) );
		plotOptions.addXAxisOptions( new TimeSeriesAxisOptions() );
		plotOptions.addYAxisOptions( new AxisOptions().setMinimum(0));
		plotOptions.setGlobalSeriesOptions( new GlobalSeriesOptions()
		.setLineSeriesOptions( new LineSeriesOptions().setLineWidth(1).setShow(true) )
		.setPointsOptions( new PointsSeriesOptions().setRadius(2).setShow(true) ).setShadowSize(0d) );

		plot = new SimplePlot( model, plotOptions );

		plotOptions.setGridOptions( new GridOptions().setHoverable(true) );

		final PopupPanel popup = new PopupPanel();
		final Label label = new Label();
		popup.add( label );

		plot.addHoverListener( new PlotHoverListener() {
			public void onPlotHover( Plot plot, PlotPosition position, PlotItem item ) {
				if ( item != null ) {
					String text = new Date((long)item.getDataPoint().getX()) + ", " + (int)item.getDataPoint().getY() + " visit(s)";
					label.setText( text );
					popup.setPopupPosition(item.getPageX() + 10, item.getPageY() - 25);
					popup.show();
				} else {
					popup.hide();
				}
			}
		}, false );

		series = model.addSeries("Visitor activity for the past week", "#FF9900");
		generateHistoryData( minutes);
	}

	private static SeriesHandler series;
	private static PlotModel model;

	public static void generateHistoryData(int minutes) {
		greetingService.getActiveSessionsForPastMins(15, minutes, new AsyncCallback<SerializableContainer>() {
			public void onFailure( Throwable caught ) {
				GWT.log( "RPCFailure: getActiveSessionsForPastMins ", caught );
			}
			public void onSuccess( SerializableContainer result ) {
				System.out.println();
				DataPoint[] dp = result.getDateTimeDataPoint();
				for (DataPoint dataPoint : dp) {
					series.add(dataPoint);
				}
				plot.redraw();
			}
		});
	}

	public static void redraw(int shop, int days) {
		model.removeAllSeries();
		if (days == 30) {
			series = model.addSeries("Visitor activity for the past month", "#FF9900");
		} else if (days == 7) {
			series = model.addSeries("Visitor activity for the past week", "#FF9900");
		} else if (days == 1) {
			series = model.addSeries("Visitor activity today", "#FF9900");
		}
		generateHistoryData(days * 1440);
	}
}
