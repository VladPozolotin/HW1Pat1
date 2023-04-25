package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст должен быть больше или равен нулю!");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null && this.surname == null) {
            throw new IllegalStateException("Не указаны имя и фамилия!");
        }
        if (this.name == null) {
            throw new IllegalStateException("Не указано имя!");
        }
        if (this.surname == null) {
            throw new IllegalStateException("Не указана фамилия!");
        }
        if (this.age > -1 && this.address != null) {
            return new Person(this.name, this.surname, this.age, this.address);
        }
        if (this.age > -1) {
            return new Person(this.name, this.surname, this.age);
        }
        if (this.address != null) {
            return new Person(this.name, this.surname, this.address);
        }
        return new Person(this.name, this.surname);
    }
}
