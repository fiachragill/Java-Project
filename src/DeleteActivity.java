/***************************************************************************//**
  file         DeleteActivity.java
  author       Fiachra Gill
  sid          21444356
  date         April 2023
  descr        This is a class for the Delete activity. I used it to represent
               different user actions and create a unique identifier for each activity.
*******************************************************************************/


// Imports:
import java.util.UUID;

// Class representing a delete activity
public class DeleteActivity implements ClientInterface.Activity {
    private final String id;
    private final Person person;
    private final StreamObject target;

    // Constructor for DeleteActivity
    public DeleteActivity(Person person, StreamObject target) {
        this.id = UUID.randomUUID().toString();
        this.person = person;
        this.target = target;
    }

    // Getter for activity URI
    @Override
    public String getURI() {
        return "example://activity/delete/" + person.getId() + "/" + id;
    }

    // Getter for the person who created the activity
    public Person getPerson() {
        return person;
    }

    // Getter for the target StreamObject to delete
    public StreamObject getTarget() {
        return target;
    }
}
