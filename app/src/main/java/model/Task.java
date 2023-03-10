package model;

/**
 *
 * @author Bruno
 */
import java.util.Date;

public class Task {
    private int id;
    private int idProject;
    private String name;
    private String description;
    private boolean completed;
    private String observations; 
    private String notes;
    private Date deadLine;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, int idProject, String name, String description, boolean completed, String observations, String notes, Date deadLine, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.observations = observations;
        this.notes = notes;
        this.deadLine = deadLine;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Task(){
        this.createdAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        System.out.println(completed + " de dentro do metodo");
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", completed=" + completed + ", observations=" + observations + ", notes=" + notes + ", deadLine=" + deadLine + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

}



