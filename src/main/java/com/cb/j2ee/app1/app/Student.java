package com.cb.j2ee.app1.app;

public class Student {

    private Long id;
    private String name;
    private String mykad;

    public Student() {
        super();
    }

    public Student(Long id, String name, String mykad) {
        super();
        this.id = id;
        this.name = name;
        this.mykad = mykad;
    }

    public Student(String name, String mykad) {
        super();
        this.name = name;
        this.mykad = mykad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMyKAD() {
        return mykad;
    }

    public void setMyKAD(String mykad) {
        this.mykad = mykad;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%s, name=%s, mykad=%s]", id, name, mykad);
    }

}
