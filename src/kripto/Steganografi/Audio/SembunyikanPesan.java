/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kripto.Steganografi.Audio;

import Lib.Audio.AudioPlayer;
import Lib.Audio.RecordTimer;
import Lib.Audio.Stego;
import Lib.RC4;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import kripto.Beranda;
import kripto.RC4.Dekripsi;

/**
 *
 * @author marti
 */
public class SembunyikanPesan extends javax.swing.JFrame {

    private boolean _encryptMessage = false;
    private File fullImagePath;
    String fileName = "";

    String EncodeAudioPath;
    private String SaveEncodeAudio;
    byte[] audioBytes;
    int pEmbedJIFNo;
    AudioInputStream audioInputStreamForEncode;
    private RecordTimer timer;
    private Thread playbackThread;
    private final AudioPlayer player = new AudioPlayer();
    private boolean isPlaying = false;
    File tempFile;

    /**
     * Creates new form SembunyikanPesan
     */
    public SembunyikanPesan() {
        initComponents();

        this.pEmbedJIFNo = pEmbedJIFNo;
        this.setLocationRelativeTo(null);

        jLabel3.setVisible(false);
        encryptKeyField.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        audioPath = new javax.swing.JTextField();
        selectButton = new javax.swing.JButton();
        encryptQuestion = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        encryptKeyField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageField = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        backButton.setText("Kembali");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel1.setText("SEMBUNYIKAN PESAN KE DALAM BERKAS AUDIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(jLabel1))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel2.setText("Pilih File Audio yang Akan Digunakan:");

        audioPath.setEditable(false);

        selectButton.setText("Pilih File");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        encryptQuestion.setText("Enkripsikan Pesan yang Disembunyikan");
        encryptQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                encryptQuestionMouseClicked(evt);
            }
        });

        jLabel3.setText("Masukkan Kunci Enkripsi");

        jLabel4.setText("Pesan yang akan Disembunyikan:");

        messageField.setColumns(20);
        messageField.setRows(5);
        jScrollPane1.setViewportView(messageField);

        submitButton.setText("Lakukan Penyembunyian");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(encryptKeyField)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(audioPath, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(selectButton))
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(encryptQuestion)
                            .addComponent(jScrollPane1))
                        .addGap(21, 21, 21))))
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(submitButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(audioPath, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addGap(26, 26, 26)
                .addComponent(encryptQuestion)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encryptKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(submitButton)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        new Beranda().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void encryptQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encryptQuestionMouseClicked
        // TODO add your handling code here:
        jLabel3.setVisible(!this._encryptMessage);
        encryptKeyField.setVisible(!this._encryptMessage);

        this._encryptMessage = !this._encryptMessage;
    }//GEN-LAST:event_encryptQuestionMouseClicked

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        String selectedFileName = audioPath.getText();
        boolean isEncrypt = encryptQuestion.isSelected();
        String encryptKey = encryptKeyField.getText();
        String message = messageField.getText();

        if (selectedFileName.equals("")) {
            JOptionPane.showMessageDialog(null, "Pilih File Audio Yang Akan Digunakan !!", "Kesalahan", JOptionPane.ERROR_MESSAGE);

            return;
        }

        if (message.equals("")) {
            JOptionPane.showMessageDialog(null, "Masukkan Pesan Yang Akan Disembunyikan !!", "Kesalahan", JOptionPane.ERROR_MESSAGE);

            return;
        }

        if (isEncrypt && encryptKey.equals("")) {
            JOptionPane.showMessageDialog(null, "Masukkan Kunci Enkripsi RC4 !!", "Kesalahan", JOptionPane.ERROR_MESSAGE);

            return;
        }

        if (isEncrypt) {
            RC4 rc4 = new RC4();

            message = RC4.Encryption_Decryption(message, encryptKey);
        }
        
        Date date = new Date();
        long time = date.getTime();

        String file = ((System.getenv("USERPROFILE")) + ("\\Documents\\"));
        File newTextFile = new File(file + time +"_"+ fileName +"_hasil_steganografi.wav");
        String output = newTextFile.getAbsolutePath();
        
        try {
            tempFile = File.createTempFile("AudioSteganographypyTemp" + this.pEmbedJIFNo, ".txt");
            BufferedWriter output2 = new BufferedWriter(new FileWriter(tempFile));
            output2.write(this.messageField.getText());
            output2.close();
        } catch (IOException ex) {
            Logger.getLogger(SembunyikanPesan.class.getName()).log(Level.SEVERE, null, ex);
        }
        String inputTextFileString = tempFile.getAbsolutePath();
        Stego e = new Stego(selectedFileName, inputTextFileString, output);
        e.encode();
        JOptionPane.showMessageDialog(this, "Berhasil Memasukkan Pesan ke Dalam Audio.\nHasil disimpan di: "+ newTextFile);
    }//GEN-LAST:event_submitButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        showFileDialog(true);
    }//GEN-LAST:event_selectButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SembunyikanPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SembunyikanPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SembunyikanPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SembunyikanPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SembunyikanPesan().setVisible(true);
            }
        });
    }

    private java.io.File showFileDialog(final boolean open) {
        JFileChooser fc = new JFileChooser("Open a File");
        javax.swing.filechooser.FileFilter ff = new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                String name = f.getName().toLowerCase();
                if (open) {
                    return f.isDirectory()
                            || name.endsWith(".wav");
                }
                return f.isDirectory() || name.endsWith(".wav");
            }

            @Override
            public String getDescription() {
                if (open) {
                    return "Audio (*.wav)";
                }
                return "Audio (*.wav)";
            }
        };
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(ff);

        java.io.File f = null;
        if (open && fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            EncodeAudioPath = fc.getSelectedFile().getAbsolutePath();
            audioPath.setText(fc.getSelectedFile().getAbsolutePath());
        } else if (!open && fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

            SaveEncodeAudio = fc.getSelectedFile().getAbsolutePath();

            /**
             * ************ now write the byte array to an audio file. ***********************
             */
            File fileOut = new File(SaveEncodeAudio);
            ByteArrayInputStream byteIS = new ByteArrayInputStream(audioBytes);
            AudioInputStream audioIS = new AudioInputStream(byteIS,
                    audioInputStreamForEncode.getFormat(), audioInputStreamForEncode.getFrameLength());
            if (AudioSystem.isFileTypeSupported(AudioFileFormat.Type.WAVE, audioIS)) {
                try {
                    AudioSystem.write(audioIS, AudioFileFormat.Type.WAVE, fileOut);
                    System.out.println("Steganographed WAV file is written as "
                            + SaveEncodeAudio + ".wav");
                    System.out.println();
                } catch (Exception e) {
                    System.err.println("Sound File write error");
                }
            }
        }
        
        fileName = fc.getSelectedFile().getName();
        return f;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField audioPath;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField encryptKeyField;
    private javax.swing.JCheckBox encryptQuestion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageField;
    private javax.swing.JButton selectButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
