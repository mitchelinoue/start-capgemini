package TodoApp;

import controller.ProjectController;
import java.sql.Connection;
import model.Project;
import util.ConnectionFactory;

public class App {
    public static void main(String[] args) {
        
        ProjectController projectController = new ProjectController();
        
        Project project = new Project();
        project.setName("Projeto teste");
        project.setDescription("description");
        projectController.save(project);
        
    }
}
