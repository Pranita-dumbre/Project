import MarvellousPackerUnpacker.MarvellousUnpaker;
import java.awt.event.*;
import javax.swing.*;

public class UnpackerWindow extends JFrame implements ActionListener {
    JTextField txtFile;
    JButton btnUnpack;

    public UnpackerWindow() {
        setTitle("Marvellous Unpacker");
        setSize(400, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new JLabel("  Marvellous Unpacker"));
        setJMenuBar(menuBar);

        JLabel lblFile = new JLabel("File Name:");
        lblFile.setBounds(30, 40, 100, 30);
        add(lblFile);

        txtFile = new JTextField();
        txtFile.setBounds(140, 40, 200, 30);
        add(txtFile);

        btnUnpack = new JButton("Unpack");
        btnUnpack.setBounds(140, 90, 100, 30);
        btnUnpack.addActionListener(this);
        add(btnUnpack);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String file = txtFile.getText().trim();

        if (!file.equals("")) {
            MarvellousUnpaker unpacker = new MarvellousUnpaker(file);
            unpacker.UnpackingActivity();
            JOptionPane.showMessageDialog(this, "✅ Unpacking Completed.");
        } else {
            JOptionPane.showMessageDialog(this, "⚠️ Please enter file name.");
        }
    }

    public static void main(String[] args) {
        new UnpackerWindow();
    }
}
