import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
    Form(String title) {
        // it will set the title of the frame
        super(title);

        // it will close the gui once after exit is clicked
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the size of the frame
        setSize(450, 600);

        // disable the frame resize
        setResizable(false);

        // gui opens at the center of the screen
        setLocationRelativeTo(null);

        // set background color
        getContentPane().setBackground(new Color(0xe5e7eb));

        // set layout to null, allows us to position our components manually
         setLayout(null);

    }
}
