package com.khatab.animalapp.util;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import static com.khatab.animalapp.util.LogUtil.verbose;

public class UserLocationListener implements LocationListener {
    @Override
    public void onLocationChanged(Location location) {

        verbose("onLocationChanged: current location" + location);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
