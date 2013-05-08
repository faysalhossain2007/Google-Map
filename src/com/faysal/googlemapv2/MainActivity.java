package com.faysal.googlemapv2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {
	static final LatLng DESTINATION = new LatLng(73.58, 9.8);
	static final LatLng FAYSAL = new LatLng(153.551, 9.993);
	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		Marker myMarker = map.addMarker(new MarkerOptions().position(
				DESTINATION).title("Hamburg"));
		Marker kiel = map.addMarker(new MarkerOptions()
				.position(FAYSAL)
				.title("Faysal")
				.snippet("HERE I AM")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_launcher)));

		map.moveCamera(CameraUpdateFactory.newLatLngZoom(DESTINATION, 15));

		map.animateCamera(CameraUpdateFactory.zoomTo(20), 1000, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}