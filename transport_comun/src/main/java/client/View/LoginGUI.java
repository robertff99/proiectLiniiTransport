package client.View;

import server.Model.LiniiTransport;
import client.Controller.LoginC;
import client.Controller.CalatorC;
import client.Controller.AdministratorC;
import client.Controller.AngajatC;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class LoginGUI extends JFrame {


    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    String rol="x";
    String s = new String();
    LoginC loginc=new LoginC();
    AdministratorC admin=new AdministratorC();
    AngajatC angajat=new AngajatC();
    CalatorC calator=new CalatorC();
    public JFrame frame;
    private JTextField usernameTxtField;
    private JPasswordField passTxtField=new JPasswordField(10);
    private final String newLine="\n";
    JTextField nume;
    JTextField numeNou;
    JTextPane textPane = new JTextPane();
    JTextArea textArea=new JTextArea(1046,317);


    public void setScrollPane(String s) {
        textArea.append(s);
    }

    JScrollPane scrollPane=new JScrollPane(textArea);
    public LoginGUI() {

        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
        //frame.getContentPane().setBackground(new Color(255, 175, 175));
        frame.setBounds(100, 100, 1080, 736);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("Utilizator:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel.setBounds(37, 52, 81, 20);
        frame.getContentPane().add(lblNewLabel);

        usernameTxtField = new JTextField();
        usernameTxtField.setBounds(24, 83, 110, 20);
        frame.getContentPane().add(usernameTxtField);
        usernameTxtField.setColumns(10);

        JLabel lblPassword = new JLabel("Parola:");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblPassword.setBounds(37, 131, 81, 20);
        frame.getContentPane().add(lblPassword);

        passTxtField.setColumns(10);
        passTxtField.setBounds(24, 161, 110, 20);
        frame.getContentPane().add(passTxtField);

        JLabel lblLogin = new JLabel("LOGIN");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblLogin.setBounds(129, 10, 131, 33);
        frame.getContentPane().add(lblLogin);

        JButton btnLogin = new JButton("Logare");
        btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setBackground(Color.CYAN);
        btnLogin.setBounds(37, 209, 85, 21);
        frame.getContentPane().add(btnLogin);

        JButton btnLinii = new JButton("Vizualizare linii");
        btnLinii.setBackground(Color.CYAN);
        btnLinii.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnLinii.setBounds(260, 68, 122, 35);
        frame.getContentPane().add(btnLinii);

        JButton btnTraseu = new JButton("Traseu optim");
        btnTraseu.setBackground(Color.CYAN);
        btnTraseu.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnTraseu.setBounds(260, 131, 122, 35);
        frame.getContentPane().add(btnTraseu);

        JButton btnCautaLinii = new JButton("Cauta linii");
        btnCautaLinii.setBackground(Color.CYAN);
        btnCautaLinii.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnCautaLinii.setBounds(260, 202, 122, 35);
        frame.getContentPane().add(btnCautaLinii);

        JLabel lblNewLabel_1_3 = new JLabel("Numar Linie");
        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_3.setBounds(399, 45, 120, 27);
        frame.getContentPane().add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("Numar nou linie");
        lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_4.setBounds(399, 96, 120, 27);
        //frame.getContentPane().add(lblNewLabel_1_4);

        JLabel lblNewLabel_1_5 = new JLabel("Nume nou statie");
        lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_5.setBounds(399, 164, 120, 27);
        //frame.getContentPane().add(lblNewLabel_1_5);

        JLabel lblNewLabel_1_5_1 = new JLabel("Nume statie");
        lblNewLabel_1_5_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_5_1.setBounds(399, 231, 120, 27);
        frame.getContentPane().add(lblNewLabel_1_5_1);

        JTextField textField_7 = new JTextField();//numarlinie
        textField_7.setBounds(399, 76, 96, 19);
        frame.getContentPane().add(textField_7);
        textField_7.setColumns(10);

        JTextField textField_8 = new JTextField();//numarnoulinie
        textField_8.setColumns(10);
        textField_8.setBounds(399, 133, 96, 19);
        //frame.getContentPane().add(textField_8);

        JTextField textField_9 = new JTextField();//numenoustatie
        textField_9.setColumns(10);
        textField_9.setBounds(399, 202, 96, 19);
        //frame.getContentPane().add(textField_9);


        JTextField textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(399, 264, 96, 19);
        frame.getContentPane().add(textField_10);


        JButton btnAdmin1 = new JButton("Stergere Angajat");
        btnAdmin1.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnAdmin1.setBackground(Color.CYAN);
        btnAdmin1.setBounds(529, 68, 122, 35);
       // frame.getContentPane().add(btnAdmin1);

        JButton btnAdmin2 = new JButton("Adaugare Angajat");
        btnAdmin2.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnAdmin2.setBackground(Color.CYAN);
        btnAdmin2.setBounds(529, 132, 122, 35);
        //frame.getContentPane().add(btnAdmin2);

        JButton btnAdmin3 = new JButton("Vizualizare Anagajat");
        btnAdmin3.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnAdmin3.setBackground(Color.CYAN);
        btnAdmin3.setBounds(529, 202, 122, 35);
        //frame.getContentPane().add(btnAdmin3);

        JButton btnAdmin4 = new JButton("Actualizare Angajat");
        btnAdmin4.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnAdmin4.setBackground(Color.CYAN);
        btnAdmin4.setBounds(529, 264, 122, 35);
        //frame.getContentPane().add(btnAdmin4);

        JTextField textField_2 = new JTextField();
        textField_2.setBounds(699, 83, 96, 19);


        JTextField textField_3 = new JTextField();
        textField_3.setBounds(699, 147, 96, 19);
       // frame.getContentPane().add(textField_3);


        JPasswordField textField_4 = new JPasswordField();
        textField_4.setBounds(699, 202, 96, 19);
        //frame.getContentPane().add(textField_4);


    JLabel labelUser = new JLabel("utilizator");
    labelUser.setFont(new Font("Times New Roman", Font.BOLD, 16));
    labelUser.setBounds(699, 50, 78, 27);
    // frame.getContentPane().add(lblNewLabel_1);

    JLabel labelUserNou = new JLabel("utilizator nou");
    labelUserNou.setFont(new Font("Times New Roman", Font.BOLD, 16));
    labelUserNou.setBounds(699, 124, 96, 13);
    //frame.getContentPane().add(lblNewLabel_2);

    JLabel labelParola = new JLabel("parola");
    labelParola.setFont(new Font("Times New Roman", Font.BOLD, 16));
    labelParola.setBounds(699, 179, 96, 13);
    //frame.getContentPane().add(lblNewLabel_3);

    JButton btnAngajat1 = new JButton("Stergere linie");
    btnAngajat1.setFont(new Font("Times New Roman", Font.BOLD, 12));
    btnAngajat1.setBackground(Color.CYAN);
    btnAngajat1.setBounds(813, 68, 122, 35);
    //frame.getContentPane().add(btnAngajat1);

    JButton btnAngajat2 = new JButton("Adaugare linie");
    btnAngajat2.setFont(new Font("Times New Roman", Font.BOLD, 12));
    btnAngajat2.setBackground(Color.CYAN);
    btnAngajat2.setBounds(813, 132, 122, 35);
    //frame.getContentPane().add(btnAngajat2);

    JButton btnAngajat3 = new JButton("Vizualizare linie");
    btnAngajat3.setFont(new Font("Times New Roman", Font.BOLD, 12));
    btnAngajat3.setBackground(Color.CYAN);
    btnAngajat3.setBounds(813, 195, 122, 35);
    // frame.getContentPane().add(btnAngajat3);

    JButton btnAngajat4 = new JButton("Actualizare linie");
    btnAngajat4.setFont(new Font("Times New Roman", Font.BOLD, 12));
    btnAngajat4.setBackground(Color.CYAN);
    btnAngajat4.setBounds(813, 264, 122, 35);
    //frame.getContentPane().add(btnAngajat4);

        JTextField textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(945, 83, 96, 19);
        //frame.getContentPane().add(textField_5);

        JTextField textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(945, 147, 96, 19);
        //frame.getContentPane().add(textField_6);



        scrollPane.setBounds(10, 347, 1046, 317);
        textArea.setEditable(false);
        frame.getContentPane().add(scrollPane);

        JButton btnRomana = new JButton("Romana");
        btnRomana.setBounds(10, 668, 85, 21);
        frame.getContentPane().add(btnRomana);

        JButton btnFranceza = new JButton("Franceza");
        btnFranceza.setBounds(129, 668, 85, 21);
        frame.getContentPane().add(btnFranceza);

        JButton btnEngleza = new JButton("Engleza");
        btnEngleza.setBounds(241, 668, 85, 21);
        frame.getContentPane().add(btnEngleza);

        JButton btnChineza = new JButton("Chineza");
        btnChineza.setBounds(344, 668, 85, 21);
        frame.getContentPane().add(btnChineza);

        JButton btnRapoarte = new JButton("Generare rapoarte");
        btnRapoarte.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnRapoarte.setBackground(Color.CYAN);
        btnRapoarte.setBounds(673, 264, 122, 35);


        frame.setVisible(false);
        frame.setVisible(true);
        btnLogin.addActionListener(e -> {
            String user = "";
            String pass = "";
            user = usernameTxtField.getText();
            pass = passTxtField.getText();
            String s = "x";
            if(user.equals("") || pass.equals(""))
                rol=("Invalid");
            else {

                try {
                    loginc.rolLogin(user,pass);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
            while(rol.equals("x")){
                System.out.println(getRol());

            }
            if (rol.equals("invalid")) {
                JOptionPane.showMessageDialog(frame, "Invalid username or password");
                rol="x";
            }

            if (rol.equals("angajat")) {
                frame.remove(lblNewLabel);
                frame.remove(lblPassword);
                frame.remove(lblLogin);
                frame.remove(btnLogin);
                //frame.add()
                frame.remove(usernameTxtField);
                frame.remove(passTxtField);
                frame.getContentPane().add(lblNewLabel_1_4);
                frame.getContentPane().add(lblNewLabel_1_5);
                frame.getContentPane().add(textField_8);
                frame.getContentPane().add(textField_9);
                frame.getContentPane().add(btnAngajat1);
                frame.getContentPane().add(btnAngajat2);
                frame.getContentPane().add(btnAngajat3);
                frame.getContentPane().add(btnAngajat4);
                frame.getContentPane().add(btnRapoarte);
                frame.repaint();
            }

            if (rol.equals("administrator")) {
                frame.remove(lblNewLabel);
                frame.remove(lblPassword);
                frame.remove(lblLogin);
                frame.remove(btnLogin);
                frame.remove(btnLinii);
                frame.remove(btnTraseu);
                frame.remove(btnCautaLinii);
                frame.remove(usernameTxtField);
                frame.remove(passTxtField);
                frame.remove(btnLinii);
                frame.remove(btnTraseu);
                frame.remove(btnCautaLinii);
                frame.remove(lblNewLabel_1_3);
                frame.remove(lblNewLabel_1_4);
                frame.remove(lblNewLabel_1_5);
                frame.remove(lblNewLabel_1_5_1);
                frame.remove(textField_7);
                frame.remove(textField_8);
                frame.remove(textField_9);
                frame.remove(textField_10);
                frame.getContentPane().add(btnAdmin1);
                frame.getContentPane().add(btnAdmin2);
                frame.getContentPane().add(btnAdmin3);
                frame.getContentPane().add(btnAdmin4);
                frame.getContentPane().add(textField_2);
                textField_2.setColumns(10);
                frame.getContentPane().add(textField_3);
                textField_3.setColumns(10);
                frame.getContentPane().add(textField_4);
                textField_4.setColumns(10);
                frame.getContentPane().add(labelUser);
                frame.getContentPane().add(labelParola);
                frame.getContentPane().add(labelUserNou);
                frame.repaint();
            }
        });
        btnRomana.addActionListener(e->{
                btnLogin.setText("Logare");
                btnAdmin1.setText("Stergere angajat");
                btnAdmin2.setText("Adaugare angajat");
                btnAdmin3.setText("Vizualizare angajat");
                btnAdmin4.setText("Actualizare angajat");
                btnAngajat1.setText("Stergere linie");
                btnAngajat2.setText("Adaugare linie");
                btnAngajat3.setText("Vizualizare linie");
                btnAngajat4.setText("Actualizare linie");
                btnCautaLinii.setText("Cauta linii");
                btnChineza.setText("Chineza");
                btnEngleza.setText("Engleza");
                btnFranceza.setText("Franceza");
                btnRomana.setText("Romana");
                btnTraseu.setText("Traseu optim!");
                btnLinii.setText("Vizualizare linii");
                btnRapoarte.setText("Generare Rapoarte");
                lblNewLabel.setText("Utilizator");
                lblLogin.setText("Logare");
                lblNewLabel_1_3.setText("Numar linie");
                lblNewLabel_1_4.setText("Numar nou linie");
                lblNewLabel_1_5.setText("Nume nou statie");
                lblNewLabel_1_5_1.setText("Nume statie");
                lblPassword.setText("Parola");
                }
        );btnChineza.addActionListener(e->{
                btnLogin.setText("Zài dēnglù");
                btnAdmin1.setText("Yuángōng shānchú");
                btnAdmin2.setText("Yuángōng zēngjiā");
                btnAdmin3.setText("Yuángōng guāndiǎn");
                btnAdmin4.setText("Yuángōng gēngxīn");
                btnAngajat1.setText("Shānchú xíng");
                btnAngajat2.setText("Jiā xiàn");
                btnAngajat3.setText("Xiàn shìtú");
                btnAngajat4.setText("Xiàn gēngxīn");
                btnCautaLinii.setText("Xúnzhǎo xiàn");
                btnChineza.setText("Zhōngguó rén");
                btnEngleza.setText("Yīngyǔ");
                btnFranceza.setText("Fǎyǔ");
                btnRomana.setText("Luómǎníyǎ yǔ");
                btnTraseu.setText("Zuì jiā lùxiàn");
                btnLinii.setText("Xiàn shìtú");
                btnRapoarte.setText("Ching Chong");
                lblNewLabel.setText("Yònghù");
                lblLogin.setText("Zài dēnglù");
                lblNewLabel_1_3.setText("Diànhuà hàomǎ");
                lblNewLabel_1_4.setText("Xīn xíng hào");
                lblNewLabel_1_5.setText("Xīn zhàn míng");
                lblNewLabel_1_5_1.setText("Zhàn míng");
                 lblPassword.setText("Mìmǎ");
                }
        );btnEngleza.addActionListener(e->{
                btnLogin.setText("Login");
                btnAdmin1.setText("Delete employee");
                btnAdmin2.setText("Add employee");
                btnAdmin3.setText("client.View employee");
                btnAdmin4.setText("Update employee");
                btnAngajat1.setText("Delete line");
                btnAngajat2.setText("Add line");
                btnAngajat3.setText("client.View line");
                btnAngajat4.setText("Update line");
                btnCautaLinii.setText("Search lines");
                btnChineza.setText("Chinese");
                btnEngleza.setText("English");
                btnFranceza.setText("French");
                btnRomana.setText("Romanian");
                btnTraseu.setText("Optimal path");
                btnLinii.setText("Show lines");
                btnRapoarte.setText("Generate reports");
                lblNewLabel.setText("Username");
                lblLogin.setText("Login");
                lblNewLabel_1_3.setText("Line number");
                lblNewLabel_1_4.setText("New line number");
                lblNewLabel_1_5.setText("New station name");
                lblNewLabel_1_5_1.setText("Station name");
                lblPassword.setText("Password");
                }
        );btnFranceza.addActionListener(e->{
                btnLogin.setText("Connecter");
                btnAdmin1.setText("Suppression d'employé");
                btnAdmin2.setText("Ajouter d'employé");
                btnAdmin3.setText("Vues d'employé");
                btnAdmin4.setText("Mise a jour d'employé");
                btnAngajat1.setText("Essuyer la ligne");
                btnAngajat2.setText("Ajouter une ligne");
                btnAngajat3.setText("Vue en ligne");
                btnAngajat4.setText("Mise à jour de la ligne");
                btnCautaLinii.setText("Rechercher des lignes");
                btnChineza.setText("CHINOIS");
                btnEngleza.setText("ANGLAIS");
                btnFranceza.setText("FRANÇAIS");
                btnRomana.setText("ROUMAIN");
                btnTraseu.setText("Itinéraire optimal");
                btnLinii.setText("Vue en ligne");
                btnRapoarte.setText("Generation de raportes");
                lblNewLabel.setText("Utilisateur");
                lblLogin.setText("Connecter");
                lblNewLabel_1_3.setText("Numéro de ligne");
                lblNewLabel_1_4.setText("Nouveau numéro de ligne");
                lblNewLabel_1_5.setText("Nouveau nom de station");
                lblNewLabel_1_5_1.setText("Nom de la station");
                lblPassword.setText("Mot de passe");
                }
        );
        btnAngajat1.addActionListener(e->{
                    System.out.println(textField_7.getText());
            try {
                angajat.deleteLinie(Integer.parseInt(textField_7.getText()));
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            textArea.append("Am sters linia "+textField_7.getText()+newLine);
                }

        );
        btnAngajat2.addActionListener(e->{
                    int numarLinie = 0;
                    numarLinie=Integer.parseInt(textField_7.getText());
            String numeStatie;
            numeStatie=textField_10.getText();
                    try {
                        angajat.addLinie(numarLinie,numeStatie);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    textArea.append("Am adaugat linia cu numarul "+textField_7.getText()+" statia: "+textField_10.getText()+newLine);
        }


        );
        btnAngajat3.addActionListener(e->{
                    int numarLinie = 0;
                    numarLinie=Integer.parseInt(textField_7.getText());
                    try {
                        angajat.searchLinie(numarLinie);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

        );
        btnAngajat4.addActionListener(e->{
                    int numarLinie;
                    numarLinie=Integer.parseInt(textField_7.getText());
            try {
                angajat.updateLinie(numarLinie,textField_9.getText());
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            textArea.append("Am gasit linia cu numarul "+textField_7.getText()+" a fost modificata "+newLine);
                }

        );

        btnAdmin1.addActionListener(e->{
            String numeAngajat;
            numeAngajat=textField_2.getText();
            try {
                admin.deleteAngajat(numeAngajat);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            textArea.append("Angajatul :"+numeAngajat+" a fost sters"+newLine);
                }

        );
        btnAdmin2.addActionListener(e->{
            String numeAngajat,parolaAngajat;
            numeAngajat=textField_2.getText();
            parolaAngajat=textField_4.getText();
            try {
                admin.addAngajat(numeAngajat,parolaAngajat);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
                    try {
                        textArea.append("Angajatul :"+numeAngajat+admin.searchAngajat(numeAngajat)+" a fost adaugat"+newLine);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

        );
        btnAdmin3.addActionListener(e->{
            String numeAngajat;
            numeAngajat=textField_2.getText();
                    try {

                            admin.searchAngajat(numeAngajat);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

        );
        btnAdmin4.addActionListener(e->{
            String numeAngajat,numeNou;
            numeAngajat=textField_2.getText();
            numeNou=textField_3.getText();
                    try {
                        if(admin.searchAngajat(numeAngajat)!=null)
                        { admin.updateAngajat(numeAngajat,numeNou);
                                textArea.append("Angajatul :"+numeAngajat+" a fost modificat "+newLine);}
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

        );
        btnTraseu.addActionListener(e->{
            String numeStatie;
            textArea.append("Afisare traseu optim: 25->37->12->68"+newLine);
                }

        );
        btnRapoarte.addActionListener(e->{
            try {
                angajat.genRaportCSV("csv","E://","RaportCSV");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                angajat.genRaportJSON("json","E://","RaportJSON");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                angajat.genRaportHTML("html","E://","RaportHTML");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                angajat.genRaportTXT("txt","E://","RaportTXT");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        btnLinii.addActionListener(e->{

                    try {
                         calator.afisareLinii();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

        }

        );
        btnCautaLinii.addActionListener(e->{
            int numarLinie = 0;
            numarLinie=Integer.parseInt(textField_7.getText());
                    try {
                       calator.searchLinieA(numarLinie);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

        );

    }

}