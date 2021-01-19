package indi.huishi.studentscore.entity;

public class StuScore {
    public StuScore(String no, String name, float score, int className) {
        this.no = no;
        this.name = name;
        this.score = score;
        this.className = className;
    }

    public StuScore() {
    }

    /**
     * 学生实体类,属性：姓名，学号，成绩，班级
     */
    private String no;
    private String name;
    private float score;
    private int className;
    @Override
    public String toString() {
        return "StuScore{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", className=" + className +
                '}';
    }
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getClassName() {
        return className;
    }

    public void setClassName(int className) {
        this.className = className;
    }
}
