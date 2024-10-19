package pe.edu.upc.vpg04.dtos;

public class QuantityPostsByVeteranDTO {
    private String username;
    private String lastnameUser;
    private int quantityPosts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
    }

    public int getQuantityPosts() {
        return quantityPosts;
    }

    public void setQuantityPosts(int quantityPosts) {
        this.quantityPosts = quantityPosts;
    }
}
