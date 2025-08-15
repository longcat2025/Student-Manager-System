public class Student {
    private String name;
    private double grade;
    private String ID;

    public Student() {
    }

    public Student(String name, double grade, String ID) {
        this.name = name;
        this.grade = grade;
        this.ID = ID;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * 设置
     *
     * @param grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * 获取
     *
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * 设置
     *
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    public String toString() {
        return "Student{name = " + name + ", grade = " + grade + ", ID = " + ID + "}";
    }
}