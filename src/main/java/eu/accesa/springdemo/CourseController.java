package eu.accesa.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "/api")
public class CourseController {

    private ProjectRepository projectRepository;

    public CourseController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping(value = "/create")
    public String createProject() {
        Project newProj = new Project();
        newProj.setName("random");
        this.projectRepository.save(newProj);

        return "done";
    }

    @PutMapping
    public void createNewProject(@RequestBody ProjectDto projectDto) {

    }

    @GetMapping("/project/ ???#$ {projectId}")
    public ProjectDto getProj(@RequestParam("projectId") Long projId) {
        return null;
    }



    @GetMapping(value = "/projects")
    public List<Project> findAll() {
        return this.projectRepository.findAll();
    }


}
