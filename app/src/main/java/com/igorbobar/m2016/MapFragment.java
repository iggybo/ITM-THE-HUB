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

@Override
public void onMapReady(GoogleMap map){
    mapReady=true;
    m_map = map;
    LatLng munich = new LatLng(48.14965999999999,11.567860200000041);
    CameraPosition target = CameraPosition.builder().target(munich).zoom(17).build();
    m_map.moveCamera(CameraUpdateFactory.newCameraPosition(Target));
}
