package esprit.tn.farmily.fields;





import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Worker {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("Fullname")
    @Expose
    private String fullname;
    @SerializedName("Role")
    @Expose
    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}