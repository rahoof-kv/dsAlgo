package study.streams;

public class User {
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    String name;

    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
