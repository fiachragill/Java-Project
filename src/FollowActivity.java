/***************************************************************************//**
  file         FollowActivity.java
  author       Fiachra Gill
  sid          21444356
  date         April 2023
  descr        This is a class for the follow activity. I used it to represent
               different user actions and create a unique identifier for each activity.
*******************************************************************************/


// Imports:
import java.util.UUID;

// Class representing a follow activity
public class FollowActivity implements ClientInterface.Activity {
    private final String id;
    private final Person actor;
    private final Person target;

    // Constructor for FollowActivity
    public FollowActivity(Person actor, Person target) {
        this.id = UUID.randomUUID().toString();
        this.actor = actor;
        this.target = target;
    }

    // Getter for activity URI
    @Override
    public String getURI() {
        return "example://activity/follow/" + actor.getId() + "/" + id;
    }

    // Getter for the person who created the activity
    public Person getActor() {
        return actor;
    }

    // Getter for the target person to follow
    public Person getTarget() {
        return target;
    }
}

