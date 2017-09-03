package org.hhs.vo;

/**
 * Created by hewater on 2017/9/3.
 */
public class Person {
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
