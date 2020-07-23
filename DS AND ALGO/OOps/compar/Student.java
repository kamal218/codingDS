public class Student implements Comparable<Student> {
    private int rollNo = 1;
    private int Class = 4;
    private String name = "";

    @Override
    public String toString() {
        return "name:" + this.name + ", class:" + this.Class + ", rollNo:" + this.rollNo + "\n";
    }

    public Student(String name, int Class, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.Class = Class;
    }

    public void setRollNo(int r) {
        this.rollNo = r;
    }

    public void setClass(int c) {
        this.Class = c;
    }

    public void setName(String n) {
        this.name = n;
    }

    public int getRollNo() {
        return this.rollNo;
    }

    public int getclass() {
        return this.Class;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.charAt(0) - o.name.charAt(0);
    }
}