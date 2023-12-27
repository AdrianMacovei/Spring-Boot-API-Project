package com.adiFirstProject.model;

import java.util.List;

public class UserDtoEnvelope {

    private List<UserDto> data;
    private String status;
    private String timeGenerated;
    private Integer totalRecords;

    public UserDtoEnvelope(List<UserDto> data, String status, String timeGenerated, Integer totalRecords) {
        this.data = data;
        this.status = status;
        this.timeGenerated = timeGenerated;
        this.totalRecords = totalRecords;
    }

    public List<UserDto> getData() {
        return data;
    }

    public void setData(List<UserDto> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeGenerated() {
        return timeGenerated;
    }

    public void setTimeGenerated(String timeGenerated) {
        this.timeGenerated = timeGenerated;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }
}
