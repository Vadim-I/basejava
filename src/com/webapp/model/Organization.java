package com.webapp.model;

import java.time.YearMonth;

public class Organization {

    private final String name;
    private final YearMonth startDate;
    private final YearMonth endDate;
    private final String description;

    public Organization(String name, YearMonth startDate, YearMonth endDate, String description) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization organization = (Organization) o;

        return name.equals(organization.name)
                && startDate.equals(organization.startDate)
                && endDate.equals(organization.endDate)
                && description.equals(organization.description);
    }

    @Override
    public int hashCode() {
        int hashCodeNumber = name.hashCode();
        hashCodeNumber = 31 * hashCodeNumber + startDate.hashCode();
        hashCodeNumber = 31 * hashCodeNumber + endDate.hashCode();
        hashCodeNumber = 31 * hashCodeNumber + description.hashCode();
        return hashCodeNumber;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "Name = " + name +
                ", startDate = " + startDate +
                ", endDate = " + endDate +
                ", description = " + description +
                "}";
    }
}
