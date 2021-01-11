package esprit.tn.farmily.models;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import esprit.tn.farmily.fields.Material;
import esprit.tn.farmily.fields.Worker;


public class Filedsmodel {



    @SerializedName("Creator")
    @Expose
    private String creator;
    @SerializedName("Location")
    @Expose
    private Location location;
    @SerializedName("Material")
    @Expose
    private List<Material> material = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("dimensions")
    @Expose
    private Integer dimensions;
    @SerializedName("ReadyTime")
    @Expose
    private Integer readyTime;
    @SerializedName("TypeName")
    @Expose
    private String typeName;
    @SerializedName("Worker")
    @Expose
    private List<Worker> worker = null;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Material> getMaterials() {
        return material;
    }

    public void setMaterials(List<Material> material) {
        this.material = material;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDimensions() {
        return dimensions;
    }

    public void setDimensions(Integer dimensions) {
        this.dimensions = dimensions;
    }

    public Integer getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(Integer readyTime) {
        this.readyTime = readyTime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Worker> getWorker() {
        return worker;
    }

    public void setWorker(List<Worker> worker) {
        this.worker = worker;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

}