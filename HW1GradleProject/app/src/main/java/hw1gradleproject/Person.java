package hw1gradleproject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private int age;


    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public static void saveJSON(String filename, Person person) {
        List<Person> list;
        list = readJSON(filename);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(person);
        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        String jsom = GSON.toJson(list);
        System.out.println(jsom);
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.write(jsom);
            out.flush();
            System.out.println("Сохранено в JSON файл");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Person> readJSON(String filename) {
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new FileReader(filename))) {
            ArrayList<Person> personList = new ArrayList<>();
            reader.beginArray();
            while (reader.hasNext()) {
                Person person = gson.fromJson(reader, Person.class);
                personList.add(person);
            }
            return personList;

        } catch (IOException e) {
            System.out.println("Parsing error");
        }
        return null;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("age", age)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return new EqualsBuilder()
                .append(age, person.age)
                .append(firstName, person.firstName)
                .append(lastName, person.lastName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(lastName)
                .append(age)
                .toHashCode();
    }
}
