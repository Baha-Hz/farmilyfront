package esprit.tn.farmily.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Downvote {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("postid")
    @Expose
    private String postid;
    @SerializedName("userdownvote")
    @Expose
    private String userdownvote;
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

    public String getUserdownvote() {
        return userdownvote;
    }

    public void setUserdownvote(String userdownvote) {
        this.userdownvote = userdownvote;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
