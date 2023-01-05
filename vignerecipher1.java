
import java.applet.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class vignerecipher1 extends Applet {
    JButton encrypt;
    Image photo = null;
    Dialog error_dialog;
    TextField key_tf;
    CheckboxGroup cg;
    Checkbox enc,dec;
    ImageIcon enc_ico,dec_ico,key_ico,text_ico,final_ico,final_ico_2,mode_ico;
    TextArea text_ta,final_ta;
    JLabel text_lb, key_lb, radio_lb, final_lb;
    int i, j, val, val1;
    String a,mainstring, key, ciphertext = "", decryptedtext = "", decypheredtxt = "", mainstringog, ciphertxt = "", mainstringlowcase;
    String values = "abcdefghijklmnopqrstuvwxyz";
    public void init(){
    GridBagLayout gd = new GridBagLayout();
    GridBagConstraints gdc = new GridBagConstraints();
    setLayout(gd);
    Font unifont = new Font("Verdana",Font.BOLD,18);
    this.setFont(unifont);
    encrypt = new JButton("Encrypt");
    encrypt.setFont(unifont);


    key_lb = new JLabel("Enter key: ");
    key_lb.setFont(unifont);
    key_tf = new TextField();
    cg = new CheckboxGroup();
    enc = new Checkbox("Encryption",cg,true);
    dec = new Checkbox("Decryption",cg,false);
    enc.setFont(unifont);
    dec.setFont(unifont);
    text_lb = new JLabel("Enter normal Text: ");
    text_lb.setFont(unifont);
    text_ta = new TextArea(5,10);
    radio_lb = new JLabel("Select Mode: ");
    radio_lb.setFont(unifont);
    final_lb = new JLabel("Encrypted text:");
    final_lb.setFont(unifont);
    final_ta = new TextArea(5,10);


        try {
            photo = ImageIO.read(new File("D:\\sem 3 degree\\Java\\Practical\\java_project\\lockk.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        photo=photo.getScaledInstance(35, 25, Image.SCALE_DEFAULT);
        enc_ico = new ImageIcon(photo);
        encrypt.setIcon(enc_ico);

        try {
            photo = ImageIO.read(new File("D:\\sem 3 degree\\Java\\Practical\\java_project\\mode.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        photo=photo.getScaledInstance(35, 25, Image.SCALE_DEFAULT);
        mode_ico = new ImageIcon(photo);
        radio_lb.setIcon(mode_ico);


        try {
            photo = ImageIO.read(new File("D:\\sem 3 degree\\Java\\Practical\\java_project\\key.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        photo=photo.getScaledInstance(35, 25, Image.SCALE_DEFAULT);
        key_ico = new ImageIcon(photo);
        key_lb.setIcon(key_ico);

        try {
            photo = ImageIO.read(new File("D:\\sem 3 degree\\Java\\Practical\\java_project\\textt.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        photo=photo.getScaledInstance(35, 25, Image.SCALE_DEFAULT);
        text_ico = new ImageIcon(photo);
        text_lb.setIcon(text_ico);

        try {
            photo = ImageIO.read(new File("D:\\sem 3 degree\\Java\\Practical\\java_project\\lock_closed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        photo=photo.getScaledInstance(35, 25, Image.SCALE_DEFAULT);
        final_ico = new ImageIcon(photo);
        final_lb.setIcon(final_ico);

        try {
            photo = ImageIO.read(new File("D:\\sem 3 degree\\Java\\Practical\\java_project\\lock_open.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        photo=photo.getScaledInstance(35, 25, Image.SCALE_DEFAULT);
        final_ico_2 = new ImageIcon(photo);

        try {
            photo = ImageIO.read(new File("D:\\sem 3 degree\\Java\\Practical\\java_project\\lock_open_.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        photo=photo.getScaledInstance(35, 25, Image.SCALE_DEFAULT);
        dec_ico = new ImageIcon(photo);

    final_ta.enable(false);
    gdc.fill = GridBagConstraints.HORIZONTAL;
    gdc.gridwidth = 2;
    gdc.gridx = 0;
    gdc.gridy = 0;
    add(radio_lb,gdc);
    gdc.gridwidth = 1;
    gdc.gridx = 2;
    add(enc,gdc);
    gdc.gridx = 3;
    add(dec,gdc);

    gdc.fill = GridBagConstraints.HORIZONTAL;
    gdc.gridwidth = 2;
    gdc.gridx = 0;
    gdc.gridy = 1;
    add(key_lb,gdc);
    key_tf = new TextField(30);
    gdc.gridwidth = 2;
    gdc.gridx = 2;
    gdc.gridy = 1;
    add(key_tf,gdc);
    gdc.fill = GridBagConstraints.HORIZONTAL;
    gdc.gridwidth = 2;
    gdc.gridx = 0;
    gdc.gridy = 2;
    add(text_lb,gdc);
    gdc.gridwidth = 2;
    gdc.gridwidth = 2;
    gdc.gridx = 2;
    add(text_ta,gdc);
    gdc.fill = GridBagConstraints.HORIZONTAL;
    gdc.gridwidth = 5;
    gdc.gridx = 0;
    gdc.gridy = 3;
    gdc.ipady = 10;
    encrypt.setBackground(Color.lightGray);
    encrypt.setForeground(Color.black);
    add(encrypt,gdc);
    gdc.fill = GridBagConstraints.HORIZONTAL;
    gdc.gridwidth = 2;
    gdc.gridx = 0;
    gdc.gridy = 4;
    add(final_lb,gdc);
    gdc.gridx = 2;
    add(final_ta,gdc);

    enc.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                final_lb.setText("Encrypted Text:");
                encrypt.setLabel("Encrypt");
                text_lb.setText("Enter normal text: ");
                final_lb.setIcon(final_ico);
                encrypt.setIcon(enc_ico);
                key_tf.setText("");
                text_ta.setText("");
                final_ta.setText("");
            }
        });
    dec.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                final_lb.setText("Decrypted Text:");
                encrypt.setLabel("Decrypt");
                text_lb.setText("Enter cipher text: ");
                final_lb.setIcon(final_ico_2);
                encrypt.setIcon(dec_ico);
                key_tf.setText("");
                text_ta.setText("");
                final_ta.setText("");

            }
        });

    encrypt.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            ciphertext = "";
            ciphertxt = "";
            decryptedtext = "";
            decypheredtxt = "";
            mainstring = "";
            mainstringog = "";
            mainstringlowcase = "";
            if( command.equals( "Encrypt" ))  {
                mainstring = text_ta.getText().toString();
                key = key_tf.getText().toString().toLowerCase();
                mainstringog = mainstring;
                mainstring = mainstring.toLowerCase();
                if(key.length() == 0)
                {
                    key = "key";
                }

                if (mainstring.equals("")||!(mainstring.matches("^[a-zA-Z ]*$"))||mainstring == null||
                        key.equals("")||!(key.matches("^[a-zA-Z]*$"))||key == null||key.length()<=1){
//                    Frame f = new Frame();
//                    f.setLocationRelativeTo(null);
//                    error_dialog = new Dialog(f,"Error!!",true);
//                    error_dialog.setLayout(new FlowLayout());
//                    Button b = new Button("Ok");
//                    b.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            error_dialog.setVisible(false);
//                            text_ta.setText("");
//                            key_tf.setText("");
//                        }
//                    });
//                    error_dialog.add(new Label("Error! Please enter a valid text"));
//                    error_dialog.add(b);
//                    error_dialog.setSize(300,300);
//                    error_dialog.setVisible(true);
                    JOptionPane.showMessageDialog(vignerecipher1.this, "Please enter valid text", "Error",
                            JOptionPane.ERROR_MESSAGE);

                } else {
                    if (key.length() < mainstring.length()) {
                        i = 0;
                        while (true) {

                            if (mainstring.length() == key.length()) {
                                break;
                            }
                            key += key.charAt(i);
                            i++;
                        }
                        System.out.println("New key: " + key);
                    } else if (key.length() > mainstring.length()) {
                        key = key.substring(0, mainstring.length());
                    }

                    for (i = 0; i < mainstring.length(); i++) {
                        if (mainstring.charAt(i) == ' ') {
                            ciphertext += " ";
                            continue;
                        }
                        String p = String.valueOf(mainstring.charAt(i));
                        String k = String.valueOf(key.charAt(i));
                        val = (values.indexOf(p) + values.indexOf(k)) % 26;
                        System.out.println(ciphertext);
                        ciphertext += String.valueOf(values.charAt(val));
                    }
                    ciphertxt = "";
                    String a = new String();
                    int x = 99;
                    System.out.println("Cipher texttt"+ciphertext);
                    for (i = 0; i < ciphertext.length(); i++) {
                        x = mainstringog.charAt(i);

                        if (x <= 90 && x != 32) {
                            a = String.valueOf(ciphertext.charAt(i));
                            ciphertxt += a.toUpperCase();
                            System.out.println("cc: " + ciphertxt);
                        } else {
                            ciphertxt += ciphertext.charAt(i);

                        }
                    }
                    System.out.println(ciphertxt);
                    final_ta.setText(ciphertxt);
                }


            }
            if(command.equals("Decrypt")){
            key = key_tf.getText().toLowerCase();
            ciphertext = text_ta.getText();
            ciphertxt = ciphertext;
            ciphertext = ciphertext.toLowerCase();
            String a = new String();
                if (ciphertext.equals("")||!(ciphertext.matches("^[a-zA-Z ]*$"))||ciphertext == null||
                        key.equals("")||!(key.matches("^[a-zA-Z]*$"))||key == null||key.length()<=1)
                {
//                    Frame f = new Frame();
//                    f.setLocationRelativeTo(null);
//                    error_dialog = new Dialog(f,"Error!!",true);
//                    error_dialog.setLayout(new FlowLayout());
//                    Button b = new Button("Ok");
//                    b.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            error_dialog.setVisible(false);
//                            text_ta.setText("");
//                            key_tf.setText("");
//                        }
//                    });
//                    error_dialog.add(new Label("Error! Please enter a valid text"));
//                    error_dialog.add(b);
//                    error_dialog.setSize(300,300);
//                    error_dialog.setVisible(true);
                      JOptionPane.showMessageDialog(vignerecipher1.this, "Please enter valid text", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                else
                {

                    if (key.length() < ciphertext.length()) {
                        i = 0;
                        while (true) {

                            if (ciphertext.length() == key.length()) {
                                break;
                            }
                            key += key.charAt(i);
                            i++;
                        }
                        System.out.println("New key: " + key);
                    } else if (key.length() > ciphertext.length()) {
                        key = key.substring(0, ciphertext.length());
                    }

                    for (i = 0; i < ciphertext.length(); i++) {
                        if (ciphertext.charAt(i) == ' ') {
                            decryptedtext += " ";
                            continue;
                        }
                        String k = String.valueOf(key.charAt(i));
                        String c = String.valueOf(ciphertext.charAt(i));
                        val1 = (values.indexOf(c) - values.indexOf(k) + 26) % 26;
                        decryptedtext += String.valueOf(values.charAt(val1));
                    }
                    int x = 99;
                    a = "";
                    for (i = 0; i < decryptedtext.length(); i++) {
                        System.out.println(decryptedtext);
                        x = ciphertxt.charAt(i);
                        if (x <= 90 && x != 32) {
                            a = String.valueOf(decryptedtext.charAt(i));
                            decypheredtxt += a.toUpperCase();
                        } else {
                            decypheredtxt += decryptedtext.charAt(i);
                        }
                    }
                    System.out.println(decypheredtxt);
                    final_ta.setText(decypheredtxt);
                }

            }

        }
    });

    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

    }



}
