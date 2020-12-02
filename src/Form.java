import entity.Location;
import entity.Person;
import generator.CsvGenerator;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Form extends JFrame {
    public Form() {
        super("Demo");
        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);


        JTable table = createDemoTable();
        JButton saveBtn = new JButton("Save");
        saveBtn.addActionListener(e -> {
            try {
                CsvGenerator.generateCsvFile(table.getModel(), "output.csv");
            } catch (IOException ioException) {
                JOptionPane.showConfirmDialog(
                    this,
                    "Unable to store data",
                    "Error",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });

        mainPanel.add(table, BorderLayout.CENTER);
        mainPanel.add(saveBtn, BorderLayout.SOUTH);
    }

    private JTable createDemoTable() {
        List<Pair<Person, Location>> data = Arrays.asList(
            Pair.create(new Person("Иван", "Иванов"), new Location(0, 0)),
            Pair.create(new Person("Петр", "Петров"), new Location(4, 5))
        );
        CustomTableModel model = new CustomTableModel(data);
        return new JTable(model);
    }


}
