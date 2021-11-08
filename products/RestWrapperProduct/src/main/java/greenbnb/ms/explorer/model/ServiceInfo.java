package greenbnb.ms.explorer.model;

import java.util.List;

public class ServiceInfo {

    //Rest countries
    private String countryName;
    private String currencyName;
    private String capitalName;
    private String population;
    private List<String> borders;
    private List<Wheather> weather;

    public ServiceInfo(String countryName, String currencyName, String capitalName, String population, List<String> borders, List<Wheather> weather) {
        this.countryName = countryName;
        this.currencyName = currencyName;
        this.capitalName = capitalName;
        this.population = population;
        this.borders = borders;
        this.weather = weather;
    }

    public ServiceInfo(String countryName, String currencyName, String capitalName, String population, List<String> borders) {
        this.countryName = countryName;
        this.currencyName = currencyName;
        this.capitalName = capitalName;
        this.population = population;
        this.borders = borders;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public List<Wheather> getWeather() {
        return weather;
    }

    public void setWeather(List<Wheather> weather) {
        this.weather = weather;
    }

    public class Wheather {
        public Wheather(String tempMin, String tempMax, String tempDay, String tempNight, String humidity, String clouds, String rain) {
            this.tempMin = tempMin;
            this.tempMax = tempMax;
            this.tempDay = tempDay;
            this.tempNight = tempNight;
            this.humidity = humidity;
            this.clouds = clouds;
            this.rain = rain;
        }

        //Wheather
        private String tempMin;
        private String tempMax;
        private String tempDay;
        private String tempNight;
        private String humidity;
        private String clouds;
        private String rain;
    }
}

