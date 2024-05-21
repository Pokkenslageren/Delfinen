import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Flow;

public class JFrameOne extends JFrame implements ActionListener{

    private JFrame frame1;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label;
    private JLabel label2;
    private JButton button;
    private JTextField textField;

    public JFrameOne(){
        initialize();
    }

    public void initialize(){
        frame1 = new JFrame();
        frame1.setVisible(true);

        frame1.setTitle("Java Swing Panel Demo");
        frame1.setSize(1720,1200);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());

        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.setBackground(Color.GRAY);
        frame1.add(panel2, BorderLayout.NORTH);

        label = new JLabel("Login-menu");
        panel2.add(label);

        label.setForeground(Color.WHITE);

        label.setFont(new Font("Sans-serif", Font.BOLD, 36));

        ImageIcon labelIcon = new ImageIcon("delfin.png");
        label.setIcon(labelIcon);
        label.setIconTextGap(50);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);

        panel3 = new JPanel();
        label2 = new JLabel("Indtast navn");
        textField = createJTextfield();
        button = new JButton("Save");

        button.addActionListener(this);
        /*
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Navn gemt.");
            }
        }); */

        panel3.add(label2);
        panel3.add(textField);
        panel3.add(button);
        frame1.add(panel3, BorderLayout.CENTER);


        //button = createButton();
        //panel1.add(button);

        /*
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(10);
        borderLayout.setVgap(10);
        frame1.setLayout(borderLayout);

        frame1.add(new JButton("Medlem"), BorderLayout.WEST);
        frame1.add(new JButton("Resultater"), BorderLayout.EAST);
        frame1.add(new JButton("Afslut"), BorderLayout.SOUTH);
        */
    }

    public JTextField createJTextfield(){
        JTextField textField = new JTextField(10);
        textField.setFont(new Font("Arial", Font.BOLD, 16));
        textField.setMargin(new Insets(5, 10, 5, 10));

        textField.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        return textField;
    }
    private JButton createButton(){
        JButton button = new JButton("Medlem");
        button.setFocusable(false);
        button.setToolTipText("Tryk her");
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setMargin(new Insets(10, 10, 10, 10));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Printer medlem.");
            }
        });

        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(textField.getText());
    }
}
