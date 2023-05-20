/***************************************************************************//**
  file         StreamObject.java
  author       Fiachra Gill
  sid          21444356
  date         April 2023
  descr        A class that represents different types of content in the app, like
               posts or comments. It has a URI and content, making it versatile.
*******************************************************************************/


// Class representing a stream object (e.g., a post or comment)
public class StreamObject {
    private String uri;
    private String content;

    // Constructor for StreamObject
    public StreamObject(String uri, String content) {
        this.uri = uri;
        this.content = content;
    }

    // Getter for the StreamObject's URI
    public String getURI() {
        return uri;
    }

    // Setter for the StreamObject's URI
    public void setURI(String uri) {
        this.uri = uri;
    }

    // Getter for the StreamObject's content
    public String getContent() {
        return content;
    }

    // Setter for the StreamObject's content
    public void setContent(String content) {
        this.content = content;
    }
}