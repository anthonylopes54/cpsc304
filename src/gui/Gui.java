package gui;

import controller.Trip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Gui extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel Insertion;
    private JPanel Deletion;
    private JPanel Update;
    private JPanel Join;
    private JPanel NestedAggregation;
    private JPanel Division;
    private JTextField insertionTextField;
    private JButton addPassengerButton;
    private JPanel mainPanel;
    private JTextField deletionField;
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
    private JTextField joinTextField;
    private JButton queryButton;
    private JLabel nestedAggregationAnswer;
    private JButton executeQueryButton;
    private JLabel divisionQueryAnswer;
    private JButton executeQueryButton1;
    private JPanel Projection;
    private JPanel Selection;
    private JComboBox trainDropDownModels;
    private JButton executeQueryButton2;
    private JButton getEmployeesButton;
    private JLabel queryCompleted;
    private JLabel deleteQuery;
    private JTextArea joinTextArea;
    private JTextArea nestedTextArea;
    private JTextArea projectionTextArea;
    private JTextArea selectionTextArea;
    private JTextField nameTextField;
    private JPanel Aggregation;
    private JTextField aggregationTextFieldTrain;
    private JTextField aggregationTextFieldRoute;
    private JLabel aggregationResultText;
    private JButton aggergationButton;
    private JLabel joinResultField;

    public Gui() {
        Trip trip = new Trip();

        setContentPane(mainPanel);
        setTitle("Train Manager");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        addPassengerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = insertionTextField.getText();
                queryCompleted.setText("Added " + name + " to the database");
                trip.insertQuery(name);

            }
        });

        executeQueryButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int passengerID = Integer.parseInt(deletionField.getText());
                trip.deleteQuery(passengerID);
                deleteQuery.setText("Passenger was deleted");

            }
        });

        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passengerID = (joinTextField.getText());
                joinTextArea.setText(trip.joinQuery(passengerID));
            }
        });
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nestedTextArea.setText(trip.nestedAggregationQuery());
                System.out.println(trip.nestedAggregationQuery());
            }
        });
        executeQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                divisionQueryAnswer.setText(trip.divisionQuery());
            }
        });

        getEmployeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               projectionTextArea.setText(trip.projectionQuery());
            }
        });
        executeQueryButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectionTextArea.setText(trip.selectionQuery(trainDropDownModels.getSelectedItem().toString()));
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date change = new Date(dateTextField.getText());
                Date expr = new Date(licenseExpiryDateTextField.getText());
                Date epor = new Date(certificationIssueDateTextField.getText());

                trip.updateQuery(   Integer.parseInt(empIdTextField.getText()),
                                    nameTextField.getText(),
                                    change,
                                    emailTextField.getText(),
                                    Integer.parseInt(salaryTextField.getText()),
                                    specializationTextField.getText(),
                                    Integer.parseInt(freightCarTextField.getText()),
                                    expr,
                                    Integer.parseInt(licenseNumberTextField.getText()),
                                    epor);

            }
        });
        aggergationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aggregationResultText.setText(Integer.toString
                        (trip.aggregationQuery(
                            Integer.parseInt(aggregationTextFieldTrain.getText()),
                            Integer.parseInt(aggregationTextFieldRoute.getText())
                )));
            }
        });
    }

    public static void main(String[] args) {
        Gui g = new Gui();
    }



}
