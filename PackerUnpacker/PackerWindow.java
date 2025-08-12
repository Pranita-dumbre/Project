import MarvellousPackerUnpacker.MarvellousPacker;
import java.awt.event.*;
import javax.swing.*;

public class PackerWindow extends JFrame implements ActionListener {
    JTextField txtFolder, txtFile;
    JButton btnPack;

    public PackerWindow() {
        setTitle("Marvellous Packer");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new JLabel("  Marvellous Packer"));
        setJMenuBar(menuBar);

        JLabel lblFolder = new JLabel("Folder Name:");
        lblFolder.setBounds(30, 30, 100, 30);
        add(lblFolder);

        txtFolder = new JTextField();
        txtFolder.setBounds(140, 30, 200, 30);
        add(txtFolder);

        JLabel lblFile = new JLabel("File Name:");
        lblFile.setBounds(30, 80, 100, 30);
        add(lblFile);

        txtFile = new JTextField();
        txtFile.setBounds(140, 80, 200, 30);
        add(txtFile);

        btnPack = new JButton("Pack");
        btnPack.setBounds(140, 130, 100, 30);
        btnPack.addActionListener(this);
        add(btnPack);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String dir = txtFolder.getText().trim();
        String file = txtFile.getText().trim();

        if (!dir.equals("") && !file.equals("")) {
            MarvellousPacker packer = new MarvellousPacker(file, dir);
            packer.PackingActivity();
            JOptionPane.showMessageDialog(this, "✅ Packing Completed.");
        } else {
            JOptionPane.showMessageDialog(this, "⚠️ Please enter both folder and file name.");
        }
    }

    public static void main(String[] args) {
        new PackerWindow();
    }
}
