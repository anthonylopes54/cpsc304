import javax.swing.*;

public class gui extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel Insertion;
    private JPanel Deletion;
    private JPanel Update;
    private JPanel Join;
    private JPanel NestedAggregation;
    private JPanel Division;
    private JTextField textField1;
    private JButton addPassengerButton;
    private JPanel mainPanel;
    private JTextField textField2;
    private JTextField dateTextField;
    private JTextField licenseNumberTextField;
    private JTextField certificationIssueDateTextField;
    private JTextField emailTextField;
    private JTextField specializationTextField;
    private JTextField licenseExpiryDateTextField;
    private JTextField freightCarTextField;
    private JTextField salaryTextField;
    private JTextField empIdTextField;
    private JButton updateButton;
    private JButton joinButton;
    private JTextField textField3;
    private JButton queryButton;
    private JLabel nestedAggregationAnswer;
    private JButton executeQueryButton;
    private JLabel divisionQueryAnswer;
    private JButton executeQueryButton1;
    private JPanel Projection;
    private JPanel Selection;
    private JComboBox Models;
    private JButton executeQueryButton2;
    private JButton getEmployeesButton;

    public gui () {
        setContentPane(mainPanel);
        setTitle("Train Manager");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        gui g = new gui();

    }
}
