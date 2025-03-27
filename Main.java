import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



public class Main {
    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> {
            FenetreUI fenetre = new FenetreUI();
            fenetre.setVisible(true);
        });
    }
}



class FenetreUI extends JFrame {
    private JLabel imageLabel;
    private JButton bouton;
    private JTable tableau;

   
    public FenetreUI() {
        setTitle("Interface Graphique - 10000 Codeurs");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

       
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        String imagePath = "./image/10000Codeurs.jpg";
        File imageFile = new File(imagePath);
        if (imageFile.exists()) {
            imageLabel = new JLabel(new ImageIcon(imagePath));
        } else {
            imageLabel = new JLabel("Image non trouvée !");
            imageLabel.setForeground(Color.RED);
        }
        topPanel.add(imageLabel);
        add(topPanel, BorderLayout.NORTH);

       
        String[] columns = {"ID", "Nom", "Âge", "Formation"};
        Object[][] data = {
            {"1", "AICHA", "30", "Développement Web"},
            {"2", "SARRA", "25", "Cybersécurité"},
            {"3", "IMEN", "28", "Data Science"},
            {"4", "DONIA", "22", "Cloud Computing"},
            {"5", "RASSIL", "27", "Intelligence Artificielle"}
        };
        
        DefaultTableModel model = new DefaultTableModel(data, columns);
        tableau = new JTable(model);
        tableau.setRowHeight(30);
        tableau.setFont(new Font("Arial", Font.PLAIN, 14));
        tableau.setGridColor(Color.LIGHT_GRAY);
        
     
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tableau.getColumnCount(); i++) {
            tableau.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JTableHeader header = tableau.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(new Color(0, 102, 204)); 
        header.setForeground(Color.WHITE);
        
        
        tableau.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row % 2 == 0) {
                    cell.setBackground(new Color(230, 242, 255)); 
                } else {
                    cell.setBackground(Color.WHITE);
                }
                return cell;
            }
        });

        add(new JScrollPane(tableau), BorderLayout.CENTER);

        bouton = new JButton("Rejoindre la formation");
        bouton.setFont(new Font("Arial", Font.BOLD, 14));
        bouton.setBackground(Color.BLUE);
        bouton.setForeground(Color.WHITE);
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bienvenue chez 10000 Codeurs !");
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(bouton);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
