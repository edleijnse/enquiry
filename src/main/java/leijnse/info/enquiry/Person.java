package leijnse.info.enquiry;

public class Person {
    private int age;
    private Gender sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }
    // constructor, getters & setters

    public enum Gender {MALE, FEMALE}
    Person(int age, Gender sex){
        this.age = age;
        this.sex = sex;
    }
}
