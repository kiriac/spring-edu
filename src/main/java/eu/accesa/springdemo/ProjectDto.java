package eu.accesa.springdemo;

public class ProjectDto {

    private Long id;
    private String name;

    public ProjectDto() {

    }
    public ProjectDto(Project entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
