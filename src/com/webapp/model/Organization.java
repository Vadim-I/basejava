package com.webapp.model;

import com.webapp.util.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.YearMonth;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String url;
    private List<Position> positions;

    public Organization() {
    }

    public Organization(String name, String url, List<Position> positions) {
        this.name = name;
        this.url = (url == null) ? "" : url;
        this.positions = positions;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization organization = (Organization) o;

        return name.equals(organization.name)
                && url.equals(organization.url)
                && positions.equals(organization.positions);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + 31 * url.hashCode() + positions.hashCode();
    }

    @Override
    public String toString() {
        return "Organization {" +
                "Name = " + name +
                "Url = " + url +
                ", Position = " + positions +
                "}";
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position implements Serializable {

        @XmlJavaTypeAdapter(DateAdapter.class)
        private YearMonth startDate;
        @XmlJavaTypeAdapter(DateAdapter.class)
        private YearMonth endDate;
        private String title;
        private String description;

        public Position() {
        }

        public Position(YearMonth startDate, YearMonth endDate, String title, String description) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = (description == null) ? "" : description;
        }

        public YearMonth getStartDate() {
            return startDate;
        }
        public YearMonth getEndDate() {
            return endDate;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            return startDate.equals(position.startDate)
                    && endDate.equals(position.endDate)
                    && title.equals(position.title)
                    && description.equals(position.description);
        }

        @Override
        public int hashCode() {
            int hashCodeNumber = startDate.hashCode();
            hashCodeNumber = 31 * hashCodeNumber + endDate.hashCode();
            hashCodeNumber = 31 * hashCodeNumber + title.hashCode();
            hashCodeNumber = 31 * hashCodeNumber + description.hashCode();
            return hashCodeNumber;
        }

        @Override
        public String toString() {
            return "Position {" +
                    "startDate = " + startDate +
                    ", endDate = " + endDate +
                    ", title = " + title +
                    ", description = " + description +
                    "}";
        }

    }
}
