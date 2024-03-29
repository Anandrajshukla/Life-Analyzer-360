import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class checktrip extends JFrame {

    JPanel panel;
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    JButton backButton;

    public checktrip() {
        panel = new JPanel(new BorderLayout());
         panel.setBackground(Color.BLACK);
        

        tableModel = new DefaultTableModel();
        tableModel.addColumn("NAME");
        tableModel.addColumn("START_DATE");
        tableModel.addColumn("END_DATE");
        tableModel.addColumn("ROUTE");
        tableModel.addColumn("ROUTE2");
        tableModel.addColumn("ROUTE3");
        tableModel.addColumn("DESTINATION");
        tableModel.addColumn("ACTIVITIES");
        

        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.GRAY);
        panel.add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
       
        panel.add(backButton, BorderLayout.SOUTH);





        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            	trip.main(null);
                dispose(); 
            
            }
        });




        loadDataFromDatabase();

        setTitle("TRIP Records");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setContentPane(panel);
    }

    public void loadDataFromDatabase() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "attack")) {
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM trips");

            while (resultSet.next()) {
                Object[] rowData = {
                        resultSet.getString("name"),
                        resultSet.getString("start_date"),
                        resultSet.getString("end_date"),
                        resultSet.getString("route"),
                        resultSet.getString("route2"),
                        resultSet.getString("route3"),
                        resultSet.getString("destination"),
                        resultSet.getString("activities"),
                        
                        
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            checktrip borrowPage = new checktrip();
            borrowPage.setVisible(true);
        });
    }
}
