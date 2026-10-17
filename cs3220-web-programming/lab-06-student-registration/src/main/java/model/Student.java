package model;

import java.time.Year;

public class Student {

    // properties (fields)
    private static int nextId = 1;
    private static int id;
    private String name;
    private int session;
    private String birthYear;
    private String level;
    private String timeOne;
    private String timeTwo;

    // default constructor
    public Student(String name, int session,
                    String birthYear, String level, String timeOne,
                    String timeTwo) {
        this.name = name;
        this.session = session;
        this.birthYear = birthYear;
        this.level = level;
        this.timeOne = timeOne;
        this.timeTwo = timeTwo;
        Student.id = id++;
    }

    // getters
    public String getName() { return name; }
    public int getSession() { return session; }
    // gets age because currentYear - birthYear = age
    public int getAge() { return Year.now().compareTo(Year.parse(birthYear)); }
    public String getLevel() { return level; }
    public String getTimeOne() { return timeOne; }
    public String getTimeTwo() { return timeTwo; }
    public int getId() { return id; }

}
