import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


//Définition de la classe principale et de la méthode main.
public class Main {
    public static void main(String[] args) {
        

       // Création et affichage de la fenêtre graphique.
        SwingUtilities.invokeLater(() -> {
            FenetreUI fenetre = new FenetreUI();
            fenetre.setVisible(true);
        });
    }
}

//Définition de la classe FenetreUI avec une image, un bouton et un tableau.
class FenetreUI extends JFrame {
    private JLabel imageLabel;
    private JButton bouton;
    private JTable tableau;

    

    //Constructeur de la fenêtre graphique.
    public FenetreUI() {


        //Configuration de la fenêtre (titre, taille, fermeture, position et disposition).
        setTitle("Interface Graphique - 10000 Codeurs");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

       

       //Création d'un panneau en haut avec un alignement en ligne.
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        //Affichage d'une image ou d'un message d'erreur si elle est absente.
        String imagePath = "./image/10000Codeurs.jpg";
        File imageFile = new File(imagePath);
        if (imageFile.exists()) {
            imageLabel = new JLabel(new ImageIcon(imagePath));
        } else {
            imageLabel = new JLabel("Image non trouvée !");
            imageLabel.setForeground(Color.RED);
        }

        //Ajout de l’image dans le panneau supérieur.
        topPanel.add(imageLabel);
        add(topPanel, BorderLayout.NORTH);

       


       //Définition des colonnes et des données du tableau.
        String[] columns = {"ID", "Nom", "Âge", "Formation"};
        Object[][] data = {
            {"1", "AICHA", "30", "Développement Web"},
            {"2", "SARRA", "25", "Cybersécurité"},
            {"3", "IMEN", "28", "Data Science"},
            {"4", "DONIA", "22", "Cloud Computing"},
            {"5", "RASSIL", "27", "Intelligence Artificielle"}
        };
        

        //Création du modèle et du tableau avec les données.
        DefaultTableModel model = new DefaultTableModel(data, columns);
        tableau = new JTable(model);

        //Personnalisation de l’apparence du tableau.
        tableau.setRowHeight(30);
        tableau.setFont(new Font("Arial", Font.PLAIN, 14));
        tableau.setGridColor(Color.LIGHT_GRAY);
        
        
     //Centrage du texte dans toutes les colonnes.
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tableau.getColumnCount(); i++) {
            tableau.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }


      //Personnalisation de l’en-tête du tableau.
      
        JTableHeader header = tableau.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(new Color(0, 102, 204)); 
        header.setForeground(Color.WHITE);
        

        //Alternance des couleurs des lignes du tableau.
        
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

        //Ajout du tableau avec un défilement vertical.

        add(new JScrollPane(tableau), BorderLayout.CENTER);

        

        //Création et personnalisation du bouton.
        bouton = new JButton("Rejoindre la formation");
        bouton.setFont(new Font("Arial", Font.BOLD, 14));
        bouton.setBackground(Color.BLUE);
        bouton.setForeground(Color.WHITE);

        //Ajout d’un message lorsque le bouton est cliqué.
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bienvenue chez 10000 Codeurs !");
            }
        });

        //Ajout du bouton dans un panneau en bas de la fenêtre.

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(bouton);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
