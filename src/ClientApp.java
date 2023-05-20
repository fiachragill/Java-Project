/***************************************************************************//**
  file         ClientApp.java
  author       Fiachra Gill
  sid          21444356
  date         April 2023
  descr        The main class of the app, where I demo the use of interfaces,
               activities, and persons in a simple social networking app.
*******************************************************************************/

// Main class that implements the ClientInterface.App interface
public class ClientApp implements ClientInterface.App {

    // Declare inbox and outbox instances
    private ClientInterface.Inbox inbox;
    private ClientInterface.Outbox outbox;

    // Constructor initializes the inbox and outbox
    public ClientApp() {
        inbox = new ClientInbox();
        outbox = new ClientOutbox();
    }

    // Getter for the inbox instance
    @Override
    public ClientInterface.Inbox getInbox() {
        return inbox;
    }

    // Getter for the outbox instance
    @Override
    public ClientInterface.Outbox getOutbox() {
        return outbox;
    }

    // Connect to the server
    @Override
    public void connect() {
        System.out.println("Connected to the server...");
    }

    // Disconnect from the server
    @Override
    public void disconnect() {
        System.out.println("Disconnected from the server.");
    }

    // Demo method to showcase the functionality of the social media simulator
    public String demo() {
        
        // Create Person instances
        Person person1 = new Person("https://fiachragill.com/me", "Fiachra Gill");
        System.out.println("Person1 added");
        System.out.println("- URI: " + person1.getURI());
        System.out.println("- name: " + person1.getName());
    
        Person person2 = new Person("https://fiachragill.com/dad", "Padraig Gill");
        System.out.println("\nPerson2 added");
        System.out.println("- URI: " + person2.getURI());
        System.out.println("- name: " + person2.getName());
    
        // Person1 adds a CreateActivity to Outbox
        String createActivityDescription = "This is the first post in JavaVerse!";
        CreateActivity createActivity = new CreateActivity(person1, createActivityDescription);
        outbox.send(createActivity);
        System.out.println("\nPerson1 Outbox delivery");
        System.out.println("- " + createActivity.getURI() + " posted");
    
        // Person2 adds a FollowActivity to Outbox
        FollowActivity followActivity = new FollowActivity(person2, person1);
        outbox.send(followActivity);
        System.out.println("\nPerson2 Outbox delivery");
        System.out.println("- " + followActivity.getURI());
        System.out.println("- added " + person1.getURI() + " to Following list");
    
        // Person1 Inbox delivery
        inbox.receive(followActivity);
        System.out.println("\nPerson1 Inbox delivery");
        System.out.println("- " + followActivity.getURI());
    
        // Person1 reads a FollowActivity from Inbox
        ClientInterface.Activity receivedActivity = inbox.readNext();
        System.out.println("\nPerson1 reads a FollowActivity from Inbox");
        if (receivedActivity instanceof FollowActivity) {
        FollowActivity receivedFollowActivity = (FollowActivity) receivedActivity;
        System.out.println("- " + receivedFollowActivity.getActor().getName() + " followed " + receivedFollowActivity.getTarget().getName());
        }

        // Person2 adds a LikeActivity to Outbox
        StreamObject postToLike = new StreamObject("https://fiachragill.com/post/001", "This is a post to like.");
        LikeActivity likeActivity = new LikeActivity(person2, postToLike);
        outbox.send(likeActivity);
        System.out.println("\nPerson2 Outbox delivery");
        System.out.println("- " + likeActivity.getURI());
        System.out.println("- " + person2.getName() + " liked " + postToLike.getURI());

        // Person1 adds a DeleteActivity to Outbox
        StreamObject postToDelete = new StreamObject("https://fiachragill.com/post/002", "This is a post to delete.");
        DeleteActivity deleteActivity = new DeleteActivity(person1, postToDelete);
        outbox.send(deleteActivity);
        System.out.println("\nPerson1 Outbox delivery");
        System.out.println("- " + deleteActivity.getURI());
        System.out.println("- " + person1.getName() + " deleted " + postToDelete.getURI());

        // Person2 adds an UnfollowActivity to Outbox
        UnfollowActivity unfollowActivity = new UnfollowActivity(person2, person1);
        outbox.send(unfollowActivity);
        System.out.println("\nPerson2 Outbox delivery");
        System.out.println("- " + unfollowActivity.getURI());
        System.out.println("- " + person2.getName() + " unfollowed " + person1.getName());
            
        return "\nDemo completed!";
    }
    
    // Main method
    public static void main(String[] args) {

        ClientApp app = new ClientApp();
        System.out.println(app.demo());

    }
}
