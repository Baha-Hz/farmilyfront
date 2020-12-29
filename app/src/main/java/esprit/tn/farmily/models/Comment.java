package esprit.tn.farmily.models;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Comment {

        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("body")
        @Expose
        private String body;
        @SerializedName("usercomment")
        @Expose
        private String usercomment;
        @SerializedName("postid")
        @Expose
        private String postid;
        @SerializedName("__v")
        @Expose
        private Integer v;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getUsercomment() {
            return usercomment;
        }

        public void setUsercomment(String usercomment) {
            this.usercomment = usercomment;
        }

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }

    }

