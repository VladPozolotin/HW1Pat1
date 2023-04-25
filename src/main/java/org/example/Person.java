package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return (this.age > -1);
    }

    public boolean hasAddress() {
        return (this.address != null);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            return OptionalInt.of(age);
        }
        return OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = getAge().getAsInt() + 1;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.getSurname());
        child.setAge(0);
        child.setAddress(this.getAddress());
        return child;
    }

    @Override
    public String toString() {
        if (hasAge() && hasAddress()) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    '}';
        } else if (hasAge()) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    '}';
        } else if (hasAddress()) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        } else {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
