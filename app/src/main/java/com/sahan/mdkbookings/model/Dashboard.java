package com.sahan.mdkbookings.model;

public class Dashboard {
    //id, company, flight_no, type, from, to, time

    private int id;
    private String company;
    private String flight_no;
    private String type; //Enum
    private String from;
    private String to;
    private String time;

    public Dashboard() {
    }

    public Dashboard(int id, String company, String flight_no, String type, String from, String to, String time) {
        this.id = id;
        this.company = company;
        this.flight_no = flight_no;
        this.type = type;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public Dashboard(String company, String flight_no, String to, String time) {
        this.company = company;
        this.flight_no = flight_no;
        this.to = to;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
