package pe.edu.upc.vpg04.dtos;

public class QuantityForumByPsychologistDTO {
    private String psychologistname;
    private String psychologistlastName;
    private int forumCount;

    public String getPsychologistname() {
        return psychologistname;
    }

    public void setPsychologistname(String psychologistname) {
        this.psychologistname = psychologistname;
    }

    public String getPsychologistlastName() {
        return psychologistlastName;
    }

    public void setPsychologistlastName(String psychologistlastName) {
        this.psychologistlastName = psychologistlastName;
    }

    public int getForumCount() {
        return forumCount;
    }

    public void setForumCount(int forumCount) {
        this.forumCount = forumCount;
    }
}
