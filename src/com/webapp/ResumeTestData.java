package com.webapp;

import com.webapp.model.*;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {

    public static void main(String[] args) {

// uuid, name
        Resume testResume = new Resume("uuid1", "Григорий Кислин");

// contacts
        testResume.setContact(ContactType.PHONE, "+7(921) 855-0482");
        testResume.setContact(ContactType.SKYPE, "grigory.kislin");
        testResume.setContact(ContactType.MAIL, "gkislin@yandex.ru");
        testResume.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        testResume.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        testResume.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        testResume.setContact(ContactType.HOME_PAGE, "http://gkislin.ru/");

// objective
        testResume.setSection(SectionType.OBJECTIVE, new TextSection(
                "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));

// personal
        testResume.setSection(SectionType.PERSONAL, new TextSection(
                "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

// achievement
        List<String> achievements = new ArrayList<>();
        achievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"");
        achievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike");
        achievements.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM");
        testResume.setSection(SectionType.ACHIEVEMENT, new ListSection(achievements));

// qualifications
        List<String> skills = new ArrayList<>();
        skills.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        skills.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        skills.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        testResume.setSection(SectionType.QUALIFICATIONS, new ListSection(skills));

// experience
        List<Organization> organizations = new ArrayList<>();
        Organization companyOne = new Organization(
                "Java Online Projects",
                YearMonth.of(2013, 10),
                YearMonth.of(2020, 10),
                "Автор проекта");
        organizations.add(companyOne);
        Organization companyTwo = new Organization(
                "Wrike",
                YearMonth.of(2014, 10),
                YearMonth.of(2016, 1),
                "Старший разработчик (backend)");
        organizations.add(companyTwo);
        testResume.setSection(SectionType.EXPERIENCE, new OrganizationSection(organizations));

// education
        List<Organization> institutions = new ArrayList<>();
        Organization institutionOne = new Organization(
                "Coursera",
                YearMonth.of(2013, 3),
                YearMonth.of(2013, 5),
                "\"Functional Programming Principles in Scala\" by Martin Odersky");
        institutions.add(institutionOne);
        Organization institutionTwo = new Organization("Luxoft",
                YearMonth.of(2011, 3),
                YearMonth.of(2011, 4),
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"");
        institutions.add(institutionTwo);
        testResume.setSection(SectionType.EDUCATION, new OrganizationSection(institutions));

        System.out.println("Person:\n" + testResume.toString());
        System.out.println("Contacts:\n" + testResume.getContacts());
        System.out.println("OBJECTIVE:\n" + testResume.getSection(SectionType.OBJECTIVE));
        System.out.println("PERSONAL:\n" + testResume.getSection(SectionType.PERSONAL));
        System.out.println("ACHIEVEMENT:\n" + testResume.getSection(SectionType.ACHIEVEMENT));
        System.out.println("QUALIFICATIONS:\n" + testResume.getSection(SectionType.QUALIFICATIONS));
        System.out.println("EXPERIENCE:\n" + testResume.getSection(SectionType.EXPERIENCE));
        System.out.println("EDUCATION:\n" + testResume.getSection(SectionType.EDUCATION));
    }
}

