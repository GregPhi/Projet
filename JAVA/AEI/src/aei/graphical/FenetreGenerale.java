package aei.graphical;
 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
 
import javax.swing.*;
 
public class FenetreGenerale extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3173093998089215823L;
	private JButton suivant;
    private JPanel titre;
    private JPanel contenu;
    private JPanel navigation;
    private JTextField tf;
    private JLabel erreures;
    public static final String serveur = "http://media.epfl.ch/itp/";
    public InputStream is; //Contient les stream des pages trouvé sur le serveur
     
    public FenetreGenerale(){
        //On redimensionne et on positionne la fen�tre
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
         
        setSize(300, 300);
        setLocation(d.width/2 - 400, d.height/2-300);
         
        this.setLayout(new BorderLayout());
         
        //On cr�e les composants
        suivant = new JButton("Suivant");
        tf = new JTextField(10);
        erreures = new JLabel();
         
        //On charge les panel de base
        titre = etape1Titre();
        contenu = etape1Contenu();
        navigation = new JPanel();
         
        navigation.add(suivant);
         
        //On les place dans le layout
        this.add(titre, BorderLayout.NORTH);
        this.add(contenu, BorderLayout.CENTER);
        this.add(navigation, BorderLayout.SOUTH);
         
        //On g�re la fermeture
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Et enfin les listener
        //Pour la première page
        suivant.addActionListener(new Etape1Listener());
    }
     
    private JPanel etape1Contenu(){
        JPanel p1 = new JPanel(new GridLayout(3,1));
        JPanel p2 = new JPanel();
        p2.add(new JLabel("Veuillez entrer un nombre entier positif : "));
        p2.add(tf);
         
        p1.add(new JLabel());
        p1.add(p2);
        p1.add(erreures);
         
         
        return p1;
    }
     
    private JPanel etape2Contenu(){
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Bravo vous avez accédé à la 2ème étape !!!"));
        return p1;
    }
     
    private JPanel etape1Titre(){
        JPanel p = new JPanel();
        p.add(new JLabel("Etape 1/5"));
         
        return p;
    }
     
    private JPanel etape2Titre(){
        JPanel p = new JPanel();
        p.add(new JLabel("Etape 2/5"));
         
        return p;
    }
     
    class Etape1Listener implements ActionListener{
        private int numero = 0;
        private URL url;
        private URLConnection urlCo;
        public void actionPerformed(ActionEvent e) {
            //On r�cup�re l'entier
            try{
                erreures.setText("");
                numero = Integer.parseInt(tf.getText());
                     
                //On traite les erreures
                if(numero < 0){
                    erreures.setText("Le nombre doit �tre positif");
                }
                else{
                    //On charge le fichier
                    url = new URL(FenetreGenerale.serveur+numero+".aiff");
                    urlCo = url.openConnection();
                    if(urlCo == null){
                        erreures.setText("Le serveur est inaccessible");
                    }
                    else{
                        is = urlCo.getInputStream();
                     
                        suivant.addActionListener(new Etape2Listener());
                     
                        titre = etape2Titre();
                         
                        contenu = etape2Contenu();
                         
                        pack();
                         
                        erreures.setText("aie");
                    }
                }
            }
            catch(MalformedURLException mURL){
                erreures.setText("L'URL n'est pas valide");
            }
            catch(FileNotFoundException fnf){
                erreures.setText("Le num�ro est invalide");
            }
            catch(IOException io){
                erreures.setText("Probl�me de connection au serveur");
            }
            catch(NumberFormatException nf){
                if(tf.getText().charAt(0) == '-'){
                    erreures.setText("Le nombre doit �tre un entier positif");
                }
                else{
                    erreures.setText("Le nombre doit �tre un entier");
                }
            }
        }
    }
     
    class Etape2Listener implements ActionListener{
 
        @Override
        public void actionPerformed(ActionEvent e) {
        	FenetreGenerale.this.remove(contenu);
        	add(etape2Contenu(), BorderLayout.CENTER);
        	validate();             
        }
         
    }
    
    public static void main(String[] args) {
    	FenetreGenerale f = new FenetreGenerale();
    	f.setVisible(true);
    }
}