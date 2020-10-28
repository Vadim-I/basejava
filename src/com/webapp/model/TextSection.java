package com.webapp.model;

public class TextSection extends Section {

    private final String content;

    public TextSection(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection textSection = (TextSection) o;

        return content.equals(textSection.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

    @Override
    public String toString() {
        return content;
    }

}
