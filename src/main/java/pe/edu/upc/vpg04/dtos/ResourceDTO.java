package pe.edu.upc.vpg04.dtos;

public class ResourceDTO {

    private int id;
    private String resourcetype;
    private String resourcedescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(String resourcetype) {
        this.resourcetype = resourcetype;
    }

    public String getResourcedescription() {
        return resourcedescription;
    }

    public void setResourcedescription(String resourcedescription) {
        this.resourcedescription = resourcedescription;
    }

}
