/***************************************************************************//**
  file         CreateActivity.java
  author       Fiachra Gill
  sid          21444356
  date         April 2023
  descr        This is a class for the Create activity. I used it to represent
               different user actions and create a unique identifier for each activity.
*******************************************************************************/


// Imports:
import java.util.UUID;

// Class representing a create activity
public class CreateActivity implements ClientInterface.Activity {
    private final String id;
    private final Person person;
    private final String content;

    // Constructor for CreateActivity
    public CreateActivity(Person person, String content) {
        this.id = UUID.randomUUID().toString();
        this.person = person;
        this.content = content;
    }

    // Getter for activity URI
    @Override
    public String getURI() {
        return "example://activity/create/" + person.getId() + "/" + id;
    }

    // Getter for the person who created the activity
    public Person getPerson() {
        return person;
    }

    // Getter for the content of the activity
    public String getContent() {
        return content;
    }
}
