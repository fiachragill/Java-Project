/***************************************************************************//**
  file         ClientInbox.java
  author       Fiachra Gill
  sid          21444356
  date         April 2023
  descr        A class for the client inbox, where I handle receiving activities,
               reading activities, and counting activities in the inbox.
*******************************************************************************/


// Imports:
import java.util.LinkedList;
import java.util.Queue;

// Class implementing ClientInterface.Inbox interface
class ClientInbox implements ClientInterface.Inbox {

    // Queue to store received activities
    private Queue<ClientInterface.Activity> activities;

    // Constructor initializes the activities queue
    public ClientInbox() {
        activities = new LinkedList<>();
    }

    // Receive an activity and add it to the queue
    @Override
    public boolean receive(ClientInterface.Activity activity) {
        return activities.offer(activity);
    }

    // Read the next activity from the queue
    @Override
    public ClientInterface.Activity readNext() {
        return activities.poll();
    }

    // Get the count of activities in the queue
    @Override
    public int getCount() {
        return activities.size();
    }
}
