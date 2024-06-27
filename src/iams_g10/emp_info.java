/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iams_g10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tasnima Hamid
 */
public class emp_info {
    
    public static void main(String[] args){
        try{
            Connection conn = dbcon.getConnection();
            String query4 = "SELECT `id`, `username`, `mail`, `name`, `emp_position` FROM `registered_users`";

            Statement state = (Statement) conn.createStatement();
            ResultSet res = state.executeQuery(query4);

            String columns[] = {"ID", "Username", "Email", "Name", "Employee_position"};
            String data[][] = new String[12][5];

            int i = 0;
            while(res.next()){
                int id = res.getInt("id");
                String user = res.getString("username");
                String name = res.getString("name");
                String mail = res.getString("mail");
                String emp_pos = res.getString("emp_position");
                data[i][0] = id + "";
                data[i][1] = user;
                data[i][2] = name;
                data[i][3] = mail;
                data[i][4] = emp_pos;
                i++;
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Create JTable from Databaase");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(600, 300);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            conn.close();
            System.out.println("Connection Terminated");
            }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
        }
    }
    
}
