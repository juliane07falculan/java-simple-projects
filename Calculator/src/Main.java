import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // runs in a thread safe manner, will make gui more responsive and smoother
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // instantiate CalculatorGUI object and make it visible
                new CalculatorGUI().setVisible(true);
            }
        });
    }
}