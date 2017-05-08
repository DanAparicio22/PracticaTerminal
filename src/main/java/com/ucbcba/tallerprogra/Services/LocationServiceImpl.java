package com.ucbcba.tallerprogra.Services;

import com.ucbcba.tallerprogra.Entities.Location;
import com.ucbcba.tallerprogra.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by da_20 on 26/4/2017.
 */
@Service
public class LocationServiceImpl implements LocationService{

    private LocationRepository locationRepository;

    public LocationRepository getLocationRepository() {
        return locationRepository;
    }

    @Autowired
    @Qualifier(value = "locationRepository")
    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Iterable<Location> listAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(Integer id) {
        return locationRepository.findOne(id);
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Integer id) {
        locationRepository.delete(id);
    }
}
