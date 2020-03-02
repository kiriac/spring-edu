package eu.accesa.springdemo;

public class ProjectNotFoundException extends RuntimeException {
    ProjectNotFoundException(Long id) {
        super("Could not find project " + id);
    }
}
