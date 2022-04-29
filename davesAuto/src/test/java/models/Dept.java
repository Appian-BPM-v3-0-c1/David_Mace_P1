package models;

public class Dept {
    private int id;
    private String name_dept;

    public Dept () {
    }



    public Dept(int id, String name_dept) {
        this.id = id;
        this.name_dept = name_dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_dept() {
        return name_dept;
    }

    public void setName_dept(String name_dept) {
        this.name_dept = name_dept;
    }

}