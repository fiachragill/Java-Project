/***************************************************************************//**
  file         Person.java
  author       Fiachra Gill
  sid          21444356
  date         April 2023
  descr        A class for a person in the social networking app. It has info about
               the person, like their name, URI, and lists of people they follow and
               are followed by.
*******************************************************************************/

// Imports:
import java.util.ArrayList;
import java.util.List;


// Class representing a person in the system
public class Person {
    private String uri;
    private String name;
    private String id;
    private List<Person> following;
    private List<Person> followers;

    // Constructor for Person
    public Person(String uri, String name) {
        this.uri = uri;
        this.name = name;
        this.following = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    // Getter for the person's ID
    public String getId() {
        return id;
    }

    // Getter for the person's URI
    public String getURI() {
        return uri;
    }

    // Setter for the person's URI
    public void setURI(String uri) {
        this.uri = uri;
    }

    // Getter for the person's name
    public String getName() {
        return name;
    }

    // Setter for the person's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the list of people this person is following
    public List<Person> getFollowing() {
        return following;
    }

    // Getter for the list of people following this person
    public List<Person> getFollowers() {
        return followers;
    }

    // Method to follow another person
    public void follow(Person person) {
        if (!following.contains(person)) {
            following.add(person);
            person.addFollower(this);
        }
    }

    // Method to unfollow another person
    public void unfollow(Person person) {
        if (following.contains(person)) {
            following.remove(person);
            person.removeFollower(this);
        }
    }

    // Method to add a follower to this person
    private void addFollower(Person person) {
        if (!followers.contains(person)) {
            followers.add(person);
        }
    }

    // Method to remove a follower from this person
    private void removeFollower(Person person) {
        if (followers.contains(person)) {
            followers.remove(person);
        }
    }

    // toString method for Person
    @Override
    public String toString() {
        return "Person{" +
                "uri='" + uri + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
