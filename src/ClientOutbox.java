/***************************************************************************//**
  file         ClientOutbox.java
  author       Fiachra Gill
  sid          21444356
  date         April 2023
  descr        A class for the client outbox, where I handle sending activities,
               delivering activities, and counting activities in the outbox.
*******************************************************************************/


// Imports:
import java.util.LinkedList;
import java.util.Queue;

// Class implementing ClientInterface.Outbox interface
class ClientOutbox implements ClientInterface.Outbox {

    // Queue to store activities to be sent
    private Queue<ClientInterface.Activity> activities;

    // Constructor initializes the activities queue
    public ClientOutbox() {
        activities = new LinkedList<>();
    }

    // Send an activity and add it to the queue
    @Override
    public boolean send(ClientInterface.Activity activity) {
        return activities.offer(activity);
    }

    // Deliver the next activity from the queue
    @Override
    public ClientInterface.Activity deliverNext() {
        return activities.poll();
    }

    // Get the count of activities in the queue
    @Override
    public int getCount() {
        return activities.size();
    }
}
    
