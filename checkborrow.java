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

public class checkborrow extends JFrame {

    JPanel panel;
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    JButton backButton;

    public checkborrow() {
        panel = new JPanel(new BorderLayout());
         panel.setBackground(Color.BLACK);
        

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Contact");
        tableModel.addColumn("Amount");
        tableModel.addColumn("Date");
        tableModel.addColumn("Due Date");
        tableModel.addColumn("Reason");

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
            
            	borrow.main(null);
                dispose(); // Close the current JFrame
            
            }
        });

        loadDataFromDatabase();

        setTitle("Borrow Records");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on screen
        setContentPane(panel);
    }

    public void loadDataFromDatabase() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdata", "root", "attack")) {
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM borrow");

            while (resultSet.next()) {
                Object[] rowData = {
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("contact"),
                        resultSet.getString("amount"),
                        resultSet.getString("date"),
                        resultSet.getString("due_date"),
                        resultSet.getString("reason")
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            checkborrow borrowPage = new checkborrow();
            borrowPage.setVisible(true);
        });
    }
}

