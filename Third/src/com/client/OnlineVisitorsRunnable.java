package com.client;

import ca.nanometrics.gflot.client.DataPoint;
import ca.nanometrics.gflot.client.PlotModel;
import ca.nanometrics.gflot.client.PlotModelStrategy;
import ca.nanometrics.gflot.client.PlotWidget;
import ca.nanometrics.gflot.client.SeriesHandler;
import ca.nanometrics.gflot.client.SimplePlot;
import ca.nanometrics.gflot.client.options.GlobalSeriesOptions;
import ca.nanometrics.gflot.client.options.LineSeriesOptions;
import ca.nanometrics.gflot.client.options.PlotOptions;
import ca.nanometrics.gflot.client.options.PointsSeriesOptions;
import ca.nanometrics.gflot.client.options.TimeSeriesAxisOptions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.VerticalPanel;

public class OnlineVisitorsRunnable {


	private static SimplePlot plot;
	private static Timer updater;

	public static VerticalPanel getOnlineVisitorsPanel() {
		PlotModel model = new PlotModel( PlotModelStrategy.slidingWindowStrategy( 20 ) );
		PlotOptions plotOptions = new PlotOptions();
		plotOptions.setGlobalSeriesOptions( new GlobalSeriesOptions()
		.setLineSeriesOptions( new LineSeriesOptions().setLineWidth( 1 ).setShow( true ) )
		.setPointsOptions( new PointsSeriesOptions().setRadius( 2 ).setShow( true ) ).setShadowSize( 0d ) );
		plotOptions.addXAxisOptions( new TimeSeriesAxisOptions() );

		final SeriesHandler series = model.addSeries( "Random Series", "#FF9900" );

		// pull the "fake" RPC service for new data
		updater = new Timer() {
			@Override
			public void run() {
				update( series, plot );
			}
		};

		updater.scheduleRepeating(4000);

		// create the plot
		plot = new SimplePlot( model, plotOptions );

		VerticalPanel vp = new VerticalPanel();
		vp.add(plot);
		return vp;
	}


	private static final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	private static void update( final SeriesHandler series, final PlotWidget plot ) {

		greetingService.getActiveSessionsForPastMins(15, 60, new AsyncCallback<SerializableContainer>() {
			public void onFailure( Throwable caught ) {
				GWT.log( "Something went wrong", caught );
			}
			public void onSuccess( SerializableContainer result ) {
				DataPoint[] dp = result.getDateTimeDataPoint();

				for ( DataPoint dataPoint : dp ) {
					series.add( dataPoint );
				}
				plot.redraw();
			}
		});
	}


	//		FakeRpcServiceAsync service = getRpcService();
	//		service.getNewData( new AsyncCallback<DataPoint[]>() {
	//			public void onFailure( Throwable caught ) {
	//				GWT.log( "Something went wrong", caught );
	//			}
	//			public void onSuccess( DataPoint[] result ) {
	//				for ( DataPoint dataPoint : result ) {
	//					series.add( dataPoint );
	//				}
	//				plot.redraw();
	//			}
	//		} );


	//	interface FakeRpcServiceAsync {
	//		void getNewData( AsyncCallback<DataPoint[]> callback );
	//	}

	//	private static FakeRpcServiceAsync getRpcService() {
	//		return new FakeRpcServiceAsync() {
	//			@SuppressWarnings( "deprecation" )
	//			public void getNewData( final AsyncCallback<DataPoint[]> callback ) {
	//				Date currentDate = new Date();
	//				callback.onSuccess( new DataPoint[] { new DataPoint( Date.UTC( currentDate.getYear(),
	//						currentDate.getMonth(), currentDate.getDate(), currentDate.getHours(), currentDate.getMinutes(),
	//						currentDate.getSeconds() ), Random.nextDouble() ) } );
	//			}
	//		};
	//	}



}
