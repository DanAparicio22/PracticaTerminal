package com.ucbcba.tallerprogra.Controllers;

import com.ucbcba.tallerprogra.Entities.Location;
import com.ucbcba.tallerprogra.Entities.Terminal;
import com.ucbcba.tallerprogra.Services.LocationService;
import com.ucbcba.tallerprogra.Services.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by da_20 on 26/4/2017.
 */

@Controller
public class LocationController {

    private LocationService locationService;

    private TerminalService terminalService;

    public LocationService getLocationService() {
        return locationService;
    }

    public TerminalService getTerminalService() {
        return terminalService;
    }

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @Autowired
    public void setTerminalService(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @RequestMapping(value = "/Locations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("Locations", locationService.listAllLocations());
        return "Locations";
    }


    @RequestMapping(value = "/Location/{id}", method = RequestMethod.GET)
    public String showLocation(@PathVariable Integer id, Model model) {
        model.addAttribute("Location", locationService.getLocationById(id));
        return "Location";
    }


    @RequestMapping(value = "/Location/delete/{id}", method = RequestMethod.GET)
    public String deleteLocation(@PathVariable Integer id, Model model) {
        locationService.deleteLocation(id);
        return "redirect:/Locations";
    }

    @RequestMapping(value = "/Location/new", method = RequestMethod.GET)
    public String newLocation(Model model) {
        model.addAttribute("Location", new Location());
        model.addAttribute("terminals",terminalService.listAllTerminals());
        return "LocationForm";
    }

    @RequestMapping("Location/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("Location", locationService.getLocationById(id));
        model.addAttribute("terminals",terminalService.listAllTerminals());
        return "LocationForm";
    }


    @RequestMapping(value = "Location", method = RequestMethod.POST)
    public String saveLocation(@Valid Location location, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("Location", location);
            model.addAttribute("terminals",terminalService.listAllTerminals());
            return "LocationForm";
        }
        if(location.getLikes()==null){
            location.setLikes(0);
        }
        locationService.saveLocation(location);
        return "redirect:/Location/" + location.getId();
    }

    @RequestMapping(value = "/Location/Like/{id}", method = RequestMethod.GET)
    public String likeLocation(@PathVariable Integer id){
        Location a=locationService.getLocationById(id);
        a.setLikes(a.getLikes()+1);
        locationService.saveLocation(a);
        return "redirect:/Location/" + a.getId();
    }


    /*@RequestMapping("/")
    String home(Model model) {
        model.addAttribute("Locations", locationService.listAllLocations());
        return "Terminals";
    }*/
}
