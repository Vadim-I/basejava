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
        testResume.setContact(ContactType.PHONE, "+7(921)855-0482");
        testResume.setContact(ContactType.SKYPE, "grigory.kislin");
        testResume.setContact(ContactType.MAIL, "gkislin@yandex.ru");
        testResume.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        testResume.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        testResume.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        testResume.setContact(ContactType.HOME_PAGE, "http://gkislin.ru/");

        // objective
        testResume.setSection(SectionType.OBJECTIVE, new TextSection(
                "Ведущий стажировок и корпоративного обучения по Java"));

        // personal
        testResume.setSection(SectionType.PERSONAL, new TextSection(
                "Аналитический склад ума, сильная логика, креативность, инициативность"));

        // achievement
        List<String> achievements = new ArrayList<>();
        achievements.add("Разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"");
        achievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами");
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
        List<Organization.Position> positionsOfCompanyOne = new ArrayList<>();
        positionsOfCompanyOne.add(new Organization.Position(
                YearMonth.of(2013, 10),
                YearMonth.of(2020, 10),
                "Автор проекта",
                "Обучение разработке на Java"));
        organizations.add(new Organization("Java Online Projects", "https://javaops.ru", positionsOfCompanyOne));
        List<Organization.Position> positionsOfCompanyTwo = new ArrayList<>();
        positionsOfCompanyTwo.add(new Organization.Position(
                YearMonth.of(2014, 10),
                YearMonth.of(2016, 1),
                "Старший разработчик (backend)",
                "Разработка серверной логики"));
        organizations.add(new Organization("Wrike", "https://wrike.ru", positionsOfCompanyTwo));
        testResume.setSection(SectionType.EXPERIENCE, new OrganizationSection(organizations));

        // education
        List<Organization> institutions = new ArrayList<>();
        List<Organization.Position> positionsOfInstituteOne = new ArrayList<>();
        positionsOfInstituteOne.add(new Organization.Position(
                YearMonth.of(2013, 3),
                YearMonth.of(2013, 5),
                "Listener",
                "Functional Programming Principles in Scala"));
        institutions.add(new Organization("Coursera", "https://coursera.org", positionsOfInstituteOne));
        List<Organization.Position> positionsOfInstituteTwo = new ArrayList<>();
        positionsOfInstituteTwo.add(new Organization.Position(
                YearMonth.of(2011, 3),
                YearMonth.of(2011, 4),
                "Listener",
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\""));
        institutions.add(new Organization("Luxoft", "https://luxoft.ru", positionsOfInstituteTwo));
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

    public static Resume createResume(String uuid, String fullName) {

        Resume newResume = new Resume(uuid, fullName);

        newResume.setContact(ContactType.PHONE, "+7(900)000-0000");
        newResume.setContact(ContactType.SKYPE, "ivan.ivanov");
        newResume.setContact(ContactType.MAIL, "ivanov@yandex.ru");
        newResume.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/ivanov");
        newResume.setContact(ContactType.GITHUB, "https://github.com/ivanov");
        newResume.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/000000");
        newResume.setContact(ContactType.HOME_PAGE, "http://ivanov.ru/");

        newResume.setSection(SectionType.OBJECTIVE, new TextSection("Java-разработчик"));

        newResume.setSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума"));

        // achievement
        List<String> achievements = new ArrayList<>();
        achievements.add("Разработка Web приложений");
        achievements.add("Реализация аутентификации для онлайн платформы");
        achievements.add("Налаживание процесса разработки ERP системы");
        newResume.setSection(SectionType.ACHIEVEMENT, new ListSection(achievements));

        // qualifications
        List<String> skills = new ArrayList<>();
        skills.add("JEE AS: GlassFish (v2.1, v3), Tomcat");
        skills.add("Git, Mercury, ClearCase, Perforce");
        skills.add("DB: PostgreSQL, Redis, H2, Oracle");
        newResume.setSection(SectionType.QUALIFICATIONS, new ListSection(skills));

        // experience
        List<Organization> organizations = new ArrayList<>();
        List<Organization.Position> positionsOfCompanyOne = new ArrayList<>();
        positionsOfCompanyOne.add(new Organization.Position(
                YearMonth.of(2018, 10),
                YearMonth.of(2020, 10),
                "Middle Java-разработчик",
                "Programming backend"));
        positionsOfCompanyOne.add(new Organization.Position(
                YearMonth.of(2015, 10),
                YearMonth.of(2018, 10),
                "Junior Java-разработчик",
                "Programming, testing application"));
        organizations.add(new Organization("CompanyOne", "https://companyone.ru", positionsOfCompanyOne));
        List<Organization.Position> positionsOfCompanyTwo = new ArrayList<>();
        positionsOfCompanyTwo.add(new Organization.Position(
                YearMonth.of(2014, 10),
                YearMonth.of(2015, 9),
                "Старший разработчик (backend)",
                "Programming backend"));
        organizations.add(new Organization("CompanyTwo", "https://companytwo.ru", positionsOfCompanyTwo));
        newResume.setSection(SectionType.EXPERIENCE, new OrganizationSection(organizations));

        // education
        List<Organization> institutions = new ArrayList<>();
        List<Organization.Position> positionsOfInstituteOne = new ArrayList<>();
        positionsOfInstituteOne.add(new Organization.Position(
                YearMonth.of(2013, 3),
                YearMonth.of(2013, 5),
                "Listener",
                "Functional Programming"));
        institutions.add(new Organization("Coursera", "https://coursera.org", positionsOfInstituteOne));
        List<Organization.Position> positionsOfInstituteTwo = new ArrayList<>();
        positionsOfInstituteTwo.add(new Organization.Position(
                YearMonth.of(2011, 3),
                YearMonth.of(2011, 4),
                "Listener",
                "Java-programming"));
        institutions.add(new Organization("Luxoft", "https://luxoft.ru", positionsOfInstituteTwo));
        newResume.setSection(SectionType.EDUCATION, new OrganizationSection(institutions));

        return newResume;
    }
}

