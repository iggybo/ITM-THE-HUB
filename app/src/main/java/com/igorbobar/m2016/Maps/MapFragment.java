package com.igorbobar.m2016;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
    setContentview(R.layout.activity_main);
    
    Button btnMap = (Button) findViewById(R.id.btnMap);
    btnMap.setOnClickListener((v) -> {  
      if(mapReady)
          n_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    });
    Button btnSatellite = (Button) findViewById(R.id.btnSatellite);
    btnSatellite.setOnClickListener((v) -> {
        if(mapReady)
            n_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    });
    Button btnHybrid = (Button) findViewById(R.id.btnHybrid);
    btnHybrid.setOnClickListener((v) -> {
        if(mapReady)
            n_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    });
  
  MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
  mapFragment.getMapAsync(this);
}

GoogleMap m_map;
boolean mapReady=false;
LatLng tuinnenstadt1=new LatLng(48.151890, 11.567371)
LatLng tuinnenstadt2=new LatLng(48.151006, 11.570608)
LatLng tuinnenstadt3=new LatLng(48.146990, 11.568205)
LatLng tuinnenstadt4=new LatLng(48.147820, 11.564825)

LatLng tugarching1=new LatLng(48.272077, 11.663913)
LatLng tugarching2=new LatLng(48.272108, 11.685706)
LatLng tugarching3=new LatLng(48.258434, 11.679782)
LatLng tugarching4=new LatLng(48.261180, 11.658981)

LatLng lmuinnenstadt1=new LatLng(48.152992, 11.579284)
LatLng lmuinnenstadt2=new LatLng(48.148926, 11.576645)
LatLng lmuinnenstadt3=new LatLng(48.147429, 11.582348)
LatLng lmuinnenstadt4=new LatLng(48.152156, 11.584292)

static final CameraPosition MUNICH = CameraPosition.builder()
        .target(new LatLng(48.13863099999999,11.573625399999969)
        .zoom(16)
        .bearing(0)
        .tilt(45)
        .build();


@Override
public void onMapReady(GoogleMap map){
  map.moveCamera(CameraUpdateFactory.newCameraPosition(MUNICH));
  map.addPolyline(new PolylineOptions().geodesic(true)
          .add()
    
}
