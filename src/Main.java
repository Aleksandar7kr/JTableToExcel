import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Form form = new Form();
            form.setSize(400,300);
            form.setVisible(true);
        });
    }
}
