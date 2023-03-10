package controller;

import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Task;

/**
 *
 * @author Bruno
 */
public class TaskController {
    // classe acessora ao banco de dados, em suas funcionalidades
    
    public void save(Task task){
        String sql = "INSERT INTO tasks (idProject, name, description, "
                + "completed, notes, deadLine, createdAt, updatedAt) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            
         
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            //statement.setString(5, task.getObservations());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
            
        } catch (Exception ex) {         
            throw new RuntimeException("Erro ao salvar tarefa."+ex.getMessage()+ ex);          
        } finally {
            ConnectionFactory.closeConnection(conn, statement);   
            
            
        }    
    }
    
    public void update(Task task){
        String sql = "UPDATE tasks SET "
                + "idProject = ?, "
                + "name = ?, "
                + "description = ?, "
                + "notes = ?, "
                + "completed = ?, "
                + "deadLine = ?, "
                + "createdAt = ?, "
                + "updatedAt = ? "
                + "WHERE id = ?";       
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            //statement.setString(4, task.getObservations());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isCompleted());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
            
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar aqui" + e.getMessage() + e);
        }finally {
            ConnectionFactory.closeConnection(conn, statement);
        
        }

    }
    
    public void removeById(int taskId){
       
        String sql = "DELETE FROM tasks WHERE id = ?";
       
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            //ajuda a preparar o comando para executar
            statement = conn.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
            
        }catch(Exception ex) {
            throw new RuntimeException("Erro ao deletar tarefa." + ex.getMessage() + ex);
        }finally {
            ConnectionFactory.closeConnection(conn, statement);
            
        }
    }
    
    public List<Task> getAllTask(int idProject){
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
       
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        // lista de tarefas a ser devolvidas
        List<Task> listTasks = new ArrayList<>();       
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();           
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("completed"));
               // task.setObservations(resultSet.getString("observations"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadLine(resultSet.getDate("deadLine"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));                
                listTasks.add(task);                                 
            }
                        
        } catch (Exception e) {
            throw new RuntimeException("Erro ao pegar a lista de tarefas" + e.getMessage() + e);
        }finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
            
        return listTasks;
    }
       
}
