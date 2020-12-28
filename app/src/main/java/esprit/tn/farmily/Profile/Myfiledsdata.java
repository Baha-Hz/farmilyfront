package esprit.tn.farmily.Profile;

public class Myfiledsdata {

    private String titel ;
    private String remaining ;
    private Integer Photo;
    private String surface ;


    public Myfiledsdata(String titel, String remaining, Integer photo, String surface) {
        this.titel = titel;
        this.remaining = remaining;
        Photo = photo;
        this.surface = surface;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public Integer getPhoto() {
        return Photo;
    }

    public void setPhoto(Integer photo) {
        Photo = photo;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }
}
