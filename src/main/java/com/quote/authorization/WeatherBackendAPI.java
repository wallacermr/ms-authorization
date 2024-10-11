package com.quote.authorization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherBackendAPI {

    @GetMapping(value = "/general/outlook", produces = "application/json")
    public String infoAboutGeneralOutlook() {
        return "Try a POST also against this URL! Just send some body with it like";
    }

}