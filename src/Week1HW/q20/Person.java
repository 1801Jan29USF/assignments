package Week1HW.q20;

import java.util.Objects;

/**
 * Functionality: A bean which describes a person.
 * Also contains a helper function to separate colon separate values.
 */
public class Person {
    private String firstName, lastName, state;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(state, person.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, state, age);
    }

    Person(String colonCompactedString){
        String[] separatedString = separate(colonCompactedString);
        this.firstName = separatedString[0];
        this.lastName = separatedString[1];
        this.state = separatedString[3];
        this.age = Integer.parseInt(separatedString[2]);
    }

    private String[] separate(String colonCompactedString) {
        return colonCompactedString.split(":");
    }

    public String toString(){//overrides the tostring function of an object for simple output
        return "Name: " + firstName + " " + lastName + "\nAge: " + age + " years\nState: " + state + " State";
    }
}
