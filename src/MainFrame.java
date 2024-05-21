import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener {

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem newMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem exitMenuItem;
    private JCheckBoxMenuItem JCheckboxMenuItem;

    public MainFrame(){
        initialize();
    }

        private void initialize(){
            frame = new JFrame();
            frame.setVisible(true);
            frame.setTitle("Delfinen Administrativt System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000,700);
            frame.setLayout(new BorderLayout(10, 10));
            frame.setLocationRelativeTo(null);

            // Change font size for menu and menu-item.
            Font f = new Font("Sans-serif", Font.PLAIN, 18);
            UIManager.put("Menu.font", f);
            UIManager.put("MenuItem.font", f);
            UIManager.put("CheckBoxMenuItem.font", f);
            UIManager.put("RadioButtonMenuItem.font", f);

            menuBar = new JMenuBar();
            fileMenu = new JMenu("File");
            newMenuItem = new JMenuItem("Ny... ");
            saveMenuItem = new JMenuItem("Gem");
            exitMenuItem = new JMenuItem("Afslut");

            newMenuItem.addActionListener(this);

            fileMenu.add(newMenuItem);
            fileMenu.add(saveMenuItem);

            fileMenu.add(new JRadioButtonMenuItem("RadioButton"));
            fileMenu.add(new JCheckboxMenuItem("CheckBox"));
            fileMenu.add(new JMenu("Sub-menu"));

            fileMenu.addSeparator();
            fileMenu.add(exitMenuItem);

            menuBar.add(fileMenu);

            frame.setJMenuBar(menuBar);
        }

        public void show(){
            this.frame.setVisible(true);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JMenuItem){
            JMenuItem item = (JMenuItem) e.getSource();
            String text = item.getText();
            System.out.println(text);
        }
    }
}
