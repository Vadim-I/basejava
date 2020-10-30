package com.webapp.model;

import java.time.YearMonth;
import java.util.List;

public class Organization {

    private final String name;
    private final List<Position> positions;

    public Organization(String name, List<Position> positions) {
        this.name = name;
        this.positions = positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization organization = (Organization) o;

        return name.equals(organization.name)
                && positions.equals(organization.positions);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + positions.hashCode();
    }

    @Override
    public String toString() {
        return "Organization {" +
                "Name = " + name +
                ", Position = " + positions +
                "}";
    }

    public static class Position {

        private final YearMonth startDate;
        private final YearMonth endDate;
        private final String description;

        public Position(YearMonth startDate, YearMonth endDate, String description) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.description = description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            return startDate.equals(position.startDate)
                    && endDate.equals(position.endDate)
                    && description.equals(position.description);
        }

        @Override
        public int hashCode() {
            int hashCodeNumber = startDate.hashCode();
            hashCodeNumber = 31 * hashCodeNumber + endDate.hashCode();
            hashCodeNumber = 31 * hashCodeNumber + description.hashCode();
            return hashCodeNumber;
        }

        @Override
        public String toString() {
            return "Position {" +
                    "startDate = " + startDate +
                    ", endDate = " + endDate +
                    ", description = " + description +
                    "}";
        }

    }
}
