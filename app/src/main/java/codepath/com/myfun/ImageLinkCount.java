package codepath.com.myfun;

public class ImageLinkCount {
    private long id;
    private String URL;
    private int timesSeen;

    public ImageLinkCount(String URL, int timesSeen) {
        setURL(URL);
        setTimesSeen(timesSeen);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getTimesSeen() {
        return timesSeen;
    }

    public void setTimesSeen(int timesSeen) {
        this.timesSeen = timesSeen;
    }

    public void incrementTimesSeen() {
        this.timesSeen += 1;
    }
}
