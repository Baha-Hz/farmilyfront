

package esprit.tn.farmily.models;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hire {

    @SerializedName("state")
    @Expose
    private Boolean state;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("employer")
    @Expose
    private String employer;
    @SerializedName("employee")
    @Expose
    private String employee;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}