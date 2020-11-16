package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class FlightController {

    private List<FlightInfo> flightInfoList = new ArrayList<>();

    public FlightController() {
        flightInfoList.add(new FlightInfo("Delhi Indira Gandhi", "Stuttgart", "D80"));
        flightInfoList.add(new FlightInfo("Tokio Haneda", "Frankfurt", "110"));
        flightInfoList.add(new FlightInfo("Kilimanjaro Arusha", "Boston", "15"));
        flightInfoList.add(new FlightInfo("Berlin Schönefeld", "Tenerife", "15"));
    }

    @GetMapping("flights/{id}")
    public FlightInfo getFlightInfo (@PathVariable int id) {
        return flightInfoList.get(id);
    }

}