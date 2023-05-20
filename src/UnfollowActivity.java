/***************************************************************************//**
  file         UnfollowActivity.java
  author       Fiachra Gill
  sid          21444356
  date         April 2023
  descr        This is a class for the unfollow activity. I used it to represent
               different user actions and create a unique identifier for each activity.
*******************************************************************************/

// Imports:
import java.util.UUID;

// Class representing an unfollow activity
public class UnfollowActivity implements ClientInterface.Activity {
    private final String id;
    private final Person person;
    private final Person target;

    // Constructor for UnfollowActivity
    public UnfollowActivity(Person person, Person target) {
        this.id = UUID.randomUUID().toString();
        this.person = person;
        this.target = target;
    }

    // Getter for activity URI
    @Override
    public String getURI() {
        return "example://activity/unfollow/" + person.getId() + "/" + id;
    }

    // Getter for the person who created the activity
    public Person getPerson() {
        return person;
    }

    // Getter for the person being unfollowed
    public Person getTarget() {
        return target;
    }
}

