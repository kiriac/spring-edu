package eu.accesa.springdemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProjectController {
    private final ProjectRepository repository;

    ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/projects")
    List<ProjectDto> all() {
        return repository.findAll()
                .stream()
                .map(singleEntity -> new ProjectDto(singleEntity))
                .collect(Collectors.toList());
    }

    @PostMapping("/projects")
    ProjectDto newProjectDto(@RequestBody ProjectDto project) {
        Project entity = new Project(project.getId(), project.getName());
        Project savedValue = repository.save(entity);
        ProjectDto returnedDto = new ProjectDto(savedValue);
        return returnedDto;
    }

    @GetMapping("/projects/{id}")
    ProjectDto one(@PathVariable Long id) {
        Project foundEntity = repository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        return new ProjectDto(foundEntity);
    }

    @PutMapping("/projects")
    ProjectDto replaceProject(@RequestBody ProjectDto project, @PathVariable Long id) {
        Project entity = new Project();
        entity.setId(project.getId());
        entity.setName(project.getName());
        Project savedEntity = this.repository.save(entity);
        return new ProjectDto(savedEntity);
    }

    @DeleteMapping("/projects/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}