package esprit.tn.farmily.feed;

public class MypostsData {
    private String PublisherName ;
    private String PublisherRole ;
    private Integer PublisherPhoto;
    private String PublisherPost ;

    public MypostsData(String publisherName, String publisherRole, Integer publisherPhoto, String publisherPost) {
        this.PublisherName = publisherName;
        this.PublisherRole = publisherRole;
        this.PublisherPhoto = publisherPhoto;
        this.PublisherPost = publisherPost;


    }

    public String getPublisherName() {
        return PublisherName;
    }

    public void setPublisherName(String publisherName) {
        PublisherName = publisherName;
    }

    public String getPublisherRole() {
        return PublisherRole;
    }

    public void setPublisherRole(String publisherRole) {
        PublisherRole = publisherRole;
    }

    public Integer getPublisherPhoto() {
        return PublisherPhoto;
    }

    public void setPublisherPhoto(Integer publisherPhoto) {
        PublisherPhoto = publisherPhoto;
    }

    public String getPublisherPost() {
        return PublisherPost;
    }

    public void setPublisherPost(String publisherPost) {
        PublisherPost = publisherPost;
    }
}
