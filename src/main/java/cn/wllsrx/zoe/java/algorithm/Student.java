package cn.wllsrx.zoe.java.algorithm;

/**
 * @author zoe
 **/
public class Student implements Comparable<Student> {

    private final String name;
    private Integer score;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return this.name.equals(student.name);
    }

    @Override
    public int compareTo(Student o) {
        /*if (this.score < o.score) {
            return -1;
        } else if (this.score.equals(o.score)) {
            return 0;
        }
        return 1;*/
        return this.score - o.score;
    }
}
