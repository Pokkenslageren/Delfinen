import javax.swing.*;
import java.awt.*;

public class MainWindow {

    private JFrame window;

    public MainWindow(){
        window = new JFrame();
        window.setTitle("Delfinen Administrativt System");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1800, 1200);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        JPanel medlemmer = new JPanel();
        medlemmer.setLayout(new BorderLayout(5,5));

        medlemmer.setBackground(Color.BLACK);

        Button medlem1 = new Button("Medlem");
        medlemmer.add(medlem1);

        Button medlem2 = new Button("Medlem 2");
        medlemmer.add(medlem2);

        Button medlem3 = new Button("Medlem 3");
        medlemmer.add(medlem3);

        //panel.setPreferredSize(new Dimension(450, 100));

        window.add(medlemmer, BorderLayout.WEST);

    }

    public void show(){
        window.setVisible(true);
    }
}
