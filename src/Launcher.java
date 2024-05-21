import javax.swing.*;

public class Launcher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //MainWindow main = new MainWindow();
                //main.show();
                //JFrameOne frame1 = new JFrameOne();
                MainFrame mainFrame = new MainFrame();
            }
        });
    }

}
