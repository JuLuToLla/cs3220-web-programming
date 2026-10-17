package cs3220.model;

import java.time.Year;

public class Student
{
    private String name;
    private int session;
    private int birthYear;
    private String level;
    private String firstChoice;
    private String secondChoice;

    public Student(String name, int session, int birthYear,
                   String level, String firstChoice, String secondChoice)
    {
        this.name = name;
        this.session = session;
        this.birthYear = birthYear;
        this.level = level;
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;
    }

    public String getName()
    {
        return name;
    }

    public int getSession()
    {
        return session;
    }

    public int getBirthYear()
    {
        return birthYear;
    }

    public String getLevel()
    {
        return level;
    }

    public String getFirstChoice()
    {
        return firstChoice;
    }

    public String getSecondChoice()
    {
        return secondChoice;
    }

    public int getAge()
    {
        return Year.now().getValue() - birthYear;
    }
}