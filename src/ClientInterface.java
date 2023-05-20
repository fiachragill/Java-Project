/***************************************************************************//**
  file         ClientInterface.java
  author       Fiachra Gill
  sid          21444356
  date         April 2023
  descr        The interfaces I used in the project for activities, inbox, outbox,
               and the main app. It helps keep everything organized.
*******************************************************************************/


public class ClientInterface {
    // Define interfaces for different components
    interface Activity {
        String getURI();
    }

    interface ReceiveMessage {
        boolean receive(Activity activity);
    }

    interface ReadNextMessage {
        Activity readNext();
    }

    interface Inbox extends ReceiveMessage, ReadNextMessage {
        int getCount();
    }

    interface SendMessage {
        boolean send(Activity activity);
    }

    interface DeliverNextMessage {
        Activity deliverNext();
    }

    interface Outbox extends SendMessage, DeliverNextMessage {
        int getCount();
    }

    interface App {
        Inbox getInbox();
        Outbox getOutbox();
        String demo();
        void connect();
        void disconnect();
    }
}
