package com.igeniusdev.bluetoothwidget;

import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.igeniusdev.bluetoothwidget.wifihotspotutils.WifiApManager;

public class AirplaneModeReceiver extends BroadcastReceiver {

	private static final String TAG = "AirplaneModeReceiver";
	private Context context;
	private boolean isEnabled = false;
	private WifiApManager wifiApManager;
	private RemoteViews views;

	@Override
	public void onReceive(Context context, Intent intent) {

		views = new RemoteViews(context.getPackageName(), R.layout.main);
		this.context = context;

		// if
		// (intent.getAction().equals(MainWidget.ACTION_WIDGET_AIRPLANE))
		// {
		// System.out.println("Aiplane");
		// toggleAirplaneMode();
		//
		// }
		// else
		if (intent.getAction().equals(MainWidget.ACTION_WIDGET_BLUETOOTH)) {
			System.out.println("bluetooth");
			toggleBluetooth();
		}
		// else if (intent.getAction().equals(
		// MainWidget.ACTION_WIDGET_DATA)) {
		// System.out.println("data");
		// toggleDataConnection();
		// } else if (intent.getAction().equals(
		// MainWidget.ACTION_WIDGET_HOTSPOT)) {
		// System.out.println("hotspot");
		// toggleWifiHotspot();
		// } else
		// if (intent.getAction().equals(MainWidget.ACTION_WIDGET_WIFI)) {
		// System.out.println("wifi");
		// toggleWifi();
		// }

		AppWidgetManager appWidgetManager = AppWidgetManager
				.getInstance(context);
		appWidgetManager.updateAppWidget(new ComponentName(context,
				MainWidget.class), views);

	}

	// private void toggleWifiHotspot() {
	// System.out.println("toggle wifi hot spot");
	// wifiApManager = new WifiApManager(context);
	// if (wifiApManager.isWifiApEnabled()) {
	// wifiApManager.setWifiApEnabled(null, false);
	// isEnabled = false;
	// } else {
	// wifiApManager.setWifiApEnabled(null, true);
	// isEnabled = true;
	// }
	// if (isEnabled) {
	// views.setInt(R.id.hotspot, "setBackgroundResource",
	// R.color.on_green);
	// } else {
	// views.setInt(R.id.hotspot, "setBackgroundResource",
	// R.color.on_red);
	// }
	// }
	//
	private void toggleBluetooth() {
		BluetoothAdapter mBluetoothAdapter = BluetoothAdapter
				.getDefaultAdapter();
		if (mBluetoothAdapter.isEnabled()) {
			isEnabled = false;
			mBluetoothAdapter.disable();
		} else {
			mBluetoothAdapter.enable();
			isEnabled = true;
		}
		if (isEnabled) {
			views.setInt(R.id.bluetooth, "setBackgroundResource",
					R.color.on_green);
		} else {
			views.setInt(R.id.bluetooth, "setBackgroundResource",
					R.color.on_red);
		}
	}

	// private void toggleWifi() {
	// WifiManager wifi = (WifiManager) context
	// .getSystemService(Context.WIFI_SERVICE);
	// isEnabled = wifi.isWifiEnabled();
	// wifi.setWifiEnabled(!isEnabled);
	// isEnabled = !isEnabled;
	// if (isEnabled) {
	// views.setInt(R.id.wifi, "setBackgroundResource",
	// R.color.on_green);
	// } else {
	// views.setInt(R.id.wifi, "setBackgroundResource",
	// R.color.on_red);
	// }
	// }

	// private void toggleAirplaneMode() {
	// isEnabled = Settings.System.getInt(context.getContentResolver(),
	// Settings.System.AIRPLANE_MODE_ON, 0) != 0;
	//
	// // toggle airplane mode
	// Settings.System
	// .putInt(context.getContentResolver(),
	// Settings.System.AIRPLANE_MODE_ON,
	// isEnabled ? 0 : 1);
	//
	// // Post an intent to reload
	// Intent changeMode = new Intent(
	// Intent.ACTION_AIRPLANE_MODE_CHANGED);
	// changeMode.putExtra("state", !isEnabled);
	// context.sendBroadcast(changeMode);
	// isEnabled = !isEnabled;
	// if (isEnabled) {
	// views.setInt(R.id.airplane, "setBackgroundResource",
	// R.color.on_green);
	// } else {
	// views.setInt(R.id.airplane, "setBackgroundResource",
	// R.color.on_red);
	// }
	// }

	// private void toggleDataConnection() {
	// System.out.println("Set data enabled");
	// isEnabled = !isMobileDataEnabled();
	// ConnectivityManager conman = (ConnectivityManager) context
	// .getSystemService(Context.CONNECTIVITY_SERVICE);
	// Class conmanClass;
	// try {
	// System.out.println("in try method");
	// conmanClass = Class.forName(conman.getClass().getName());
	// Field iConnectivityManagerField = conmanClass
	// .getDeclaredField("mService");
	// iConnectivityManagerField.setAccessible(true);
	// Object iConnectivityManager = iConnectivityManagerField
	// .get(conman);
	// Class iConnectivityManagerClass = Class
	// .forName(iConnectivityManager.getClass()
	// .getName());
	// Method setMobileDataEnabledMethod = iConnectivityManagerClass
	// .getDeclaredMethod("setMobileDataEnabled",
	// Boolean.TYPE);
	// setMobileDataEnabledMethod.setAccessible(true);
	// setMobileDataEnabledMethod.invoke(iConnectivityManager,
	// isEnabled);
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (NoSuchFieldException e) {
	// e.printStackTrace();
	// } catch (IllegalArgumentException e) {
	// e.printStackTrace();
	// } catch (IllegalAccessException e) {
	// e.printStackTrace();
	// } catch (NoSuchMethodException e) {
	// e.printStackTrace();
	// } catch (InvocationTargetException e) {
	// e.printStackTrace();
	// }
	// if (isEnabled) {
	// views.setInt(R.id.data, "setBackgroundResource",
	// R.color.on_green);
	// } else {
	// views.setInt(R.id.data, "setBackgroundResource",
	// R.color.on_red);
	// }
	//
	// }
	//
	// private Boolean isMobileDataEnabled() {
	// Object connectivityService = context
	// .getSystemService(Context.CONNECTIVITY_SERVICE);
	// ConnectivityManager cm = (ConnectivityManager) connectivityService;
	//
	// try {
	// Class<?> c = Class.forName(cm.getClass().getName());
	// Method m = c.getDeclaredMethod("getMobileDataEnabled");
	// m.setAccessible(true);
	// return (Boolean) m.invoke(cm);
	// } catch (Exception e) {
	// e.printStackTrace();
	// return null;
	// }
	// }
	//
	// public void turnGPSOn() {
	// Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
	// intent.putExtra("enabled", true);
	// context.sendBroadcast(intent);
	//
	// String provider = Settings.Secure.getString(
	// context.getContentResolver(),
	// Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
	// if (!provider.contains("gps")) {
	// // if gps is disabled
	// final Intent poke = new Intent();
	// poke.setClassName("com.android.settings",
	// "com.android.settings.widget.SettingsAppWidgetProvider");
	// poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
	// poke.setData(Uri.parse("3"));
	// context.sendBroadcast(poke);
	// }
	// }
	//
	// public void turnGPSOff() {
	// String provider = Settings.Secure.getString(
	// context.getContentResolver(),
	// Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
	// if (provider.contains("gps")) { // if gps is enabled
	// final Intent poke = new Intent();
	// poke.setClassName("com.android.settings",
	// "com.android.settings.widget.SettingsAppWidgetProvider");
	// poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
	// poke.setData(Uri.parse("3"));
	// context.sendBroadcast(poke);
	// }
	// }

}
