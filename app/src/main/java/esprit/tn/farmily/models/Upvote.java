package esprit.tn.farmily.models;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Upvote {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("postid")
    @Expose
    private String postid;
    @SerializedName("userupvote")
    @Expose
    private String userupvote;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getUserupvote() {
        return userupvote;
    }

    public void setUserupvote(String userupvote) {
        this.userupvote = userupvote;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}