package com.example.TP3_4_TLEMCANI_KAWTAR.model;

public class MeteoResponse {

    private DailyForecastItem[] forecast;


    public DailyForecastItem[] getForecast() {
        return forecast;
    }

    public void setForecast(DailyForecastItem[] forecast) {
        this.forecast = forecast;
    }


    public static class DailyForecastItem {
        private int day;
        private String datetime;
        private double wind10m;  // Wind speed at 10 meters (in km/h)
        private double gust10m;  // Wind gusts at 10 meters (in km/h)
        private double rr1;  // Total rainfall for the last hour (in mm)
        private int probarain;  // Probability of rain (percentage)
        private double tmin;  // Minimum temperature for the day (°C)
        private double tmax;  // Maximum temperature for the day (°C)
        private double weather;  // Weather condition description


        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public double getWind10m() {
            return wind10m;
        }

        public void setWind10m(double wind10m) {
            this.wind10m = wind10m;
        }

        public double getGust10m() {
            return gust10m;
        }

        public void setGust10m(double gust10m) {
            this.gust10m = gust10m;
        }

        public double getRr1() {
            return rr1;
        }

        public void setRr1(double rr1) {
            this.rr1 = rr1;
        }

        public int getProbarain() {
            return probarain;
        }

        public void setProbarain(int probarain) {
            this.probarain = probarain;
        }

        public double getTmin() {
            return tmin;
        }

        public void setTmin(double tmin) {
            this.tmin = tmin;
        }

        public double getTmax() {
            return tmax;
        }

        public void setTmax(double tmax) {
            this.tmax = tmax;
        }

        public double getWeather() {
            return weather;
        }

        public void setWeather(double weather) {
            this.weather = weather;
        }
    }
}
