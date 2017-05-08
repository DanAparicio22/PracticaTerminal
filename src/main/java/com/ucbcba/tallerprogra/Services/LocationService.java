package com.ucbcba.tallerprogra.Services;

import com.ucbcba.tallerprogra.Entities.Location;

/**
 * Created by da_20 on 26/4/2017.
 */
public interface LocationService {
    Iterable<Location> listAllLocations();

    Location getLocationById(Integer id);

    Location saveLocation(Location location);

    void deleteLocation(Integer id);

}
