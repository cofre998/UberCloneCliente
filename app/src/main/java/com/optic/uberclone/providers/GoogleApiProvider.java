package com.optic.uberclone.providers;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.optic.uberclone.R;
import com.optic.uberclone.retrofit.IGoogleApi;
import com.optic.uberclone.retrofit.RetrofitClient;

import java.util.Date;

import retrofit2.Call;

public class GoogleApiProvider {

    private Context context;

    public GoogleApiProvider(Context context) {
        this.context = context;
    }

    public Call<String> getDirections(LatLng originLatLng, LatLng destinationLatLng) {
        String baseUrl = "https://maps.googleapis.com";
        String query = "/maps/api/directions/json?mode=driving&transit_routing_preferences=less_driving&"
                     + "origin=" + originLatLng.latitude + "," + originLatLng.longitude + "&"
                     + "destination=" + destinationLatLng.latitude + "," + destinationLatLng.longitude + "&"
                     + "key=" + context.getResources().getString(R.string.google_maps_key);
        return RetrofitClient.getClient(baseUrl).create(IGoogleApi.class).getDirections(baseUrl + query);
    }
}
