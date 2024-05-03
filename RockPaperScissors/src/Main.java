import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // allows to run in thread safe manner
        // this will make GUI more responsive and smoother
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // instantiate RockPaperScissorsGUI and set visibility to true
                new RockPaperScissors().setVisible(true);
            }
        });
    }
}