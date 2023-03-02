package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

public class ProjectController {
    
       public void save(Project project){
        
        String sql = "INSERT INTO projects ("
                + "name,"
                + "description,"
                + "createdAt,"
                + "updatedAt"
                + ") VALUES (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.execute();
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a projeto " + 
                    ex.getMessage(), ex);
        } finally {
        ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void update(Project project){
        
        String sql = "UPDATE projects SET "
                + "name = ?,"
                + "description = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?,"
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            // preparando a query
            statement = connection.prepareStatement(sql);
            //setando os valores do statement
      
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            //executando a query
            statement.execute();
            
        } catch (Exception ex) {
        throw new RuntimeException("Erro ao atualizar o projeto" + 
                    ex.getMessage(), ex);
        } finally {
        ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void removeById(int idProject) {
        
        String sql = "DELETE FROM projects WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //criação da conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            //preparando a query
            statement = connection.prepareStatement(sql);
            //setando os valores
            statement.setInt(1, idProject);
            //executando a query
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar o projeto" + 
                    ex.getMessage(), ex);
        } finally {
        ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public List<Project> getAll() {
        
        String sql = "SELECT * FROM projects";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //lista de terefas que será devolvida quando o chamado do método acontecer
        List<Project> projects = new ArrayList<Project>();
        
        try {
            //criando conexão
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            // valor retornado pela execução da query
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                projects.add(project);
            }
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao listar os projetos" + 
                    ex.getMessage(), ex);
        } finally {
        ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        //lista de tarefas que foi criada e carregada do banco de dados
        return projects;
    }
    
}
