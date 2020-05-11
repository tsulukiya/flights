package com.service.filtering;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Filter {
    private String filteredField;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    public Filter() {
    }

    public Filter(String filteredField, Date startDate, Date endDate) {
        this.filteredField = filteredField;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getFilteredField() {
        return filteredField;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
