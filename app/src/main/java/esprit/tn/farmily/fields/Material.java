package esprit.tn.farmily.fields;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Material {


    @SerializedName("Type")
    @Expose
    private String Type;


    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

}



