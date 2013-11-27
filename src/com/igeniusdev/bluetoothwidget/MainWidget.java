package com.igeniusdev.bluetoothwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * 
 * @author seymores@gmail.com
 * 
 */
public class MainWidget extends AppWidgetProvider {

	private static final String TAG = "MainWidget";
	public static final String ACTION_WIDGET_AIRPLANE = "ActionReceiverAirplane";
	public static final String ACTION_WIDGET_WIFI = "ActionReceiverWifi";
	public static final String ACTION_WIDGET_BLUETOOTH = "ActionReceiverBluetooth";
	public static final String ACTION_WIDGET_DATA = "ActionReceiverData";
	public static final String ACTION_WIDGET_HOTSPOT = "ActionReceiverHotspot";

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {

		RemoteViews remoteViews = new RemoteViews(
				context.getPackageName(), R.layout.main);

		// Intent active = new Intent(context,
		// AirplaneModeReceiver.class);
		// active.setAction(ACTION_WIDGET_AIRPLANE);
		// PendingIntent actionPendingIntent = PendingIntent.getBroadcast(
		// context, 0, active, 0);
		// remoteViews.setOnClickPendingIntent(R.id.btnAirplane,
		// actionPendingIntent);
		//
		// Intent active = new Intent(context,
		// AirplaneModeReceiver.class);
		// active.setAction(ACTION_WIDGET_WIFI);
		// PendingIntent actionPendingIntent = PendingIntent.getBroadcast(
		// context, 0, active, 0);
		// remoteViews.setOnClickPendingIntent(R.id.btnWifi,
		// actionPendingIntent);
		//
		Intent active = new Intent(context, AirplaneModeReceiver.class);
		active.setAction(ACTION_WIDGET_BLUETOOTH);
		PendingIntent actionPendingIntent = PendingIntent.getBroadcast(
				context, 0, active, 0);
		remoteViews.setOnClickPendingIntent(R.id.btnBluetooth,
				actionPendingIntent);
		//
		// active = new Intent(context, AirplaneModeReceiver.class);
		// active.setAction(ACTION_WIDGET_DATA);
		// actionPendingIntent = PendingIntent.getBroadcast(context, 0,
		// active, 0);
		// remoteViews.setOnClickPendingIntent(R.id.btnData,
		// actionPendingIntent);
		//
		// active = new Intent(context, AirplaneModeReceiver.class);
		// active.setAction(ACTION_WIDGET_HOTSPOT);
		// actionPendingIntent = PendingIntent.getBroadcast(context, 0,
		// active, 0);
		// remoteViews.setOnClickPendingIntent(R.id.btnHotspot,
		// actionPendingIntent);

		appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

	}

}
