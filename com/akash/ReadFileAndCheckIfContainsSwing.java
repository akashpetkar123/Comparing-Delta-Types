package com.akash;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileAndCheckIfContainsSwing extends JFrame implements ActionListener {

    private JButton btnClick,btnClickFile1,btnClickFile2;
    private JLabel lblFile1,lblFile2,lblResponse,lblFile1Path,lblFile2Path;
    private JTextArea txtArea;
    private JFileChooser jfcFile1,jfcFile2;
    String file1Path="";
    String file2Path="";

    ReadFileAndCheckIfContainsSwing(){

        btnClick=new JButton("CLICKK");
        btnClickFile1=new JButton("File1");
        btnClickFile2=new JButton("File2");
        lblFile1=new JLabel("File1");
        lblFile2=new JLabel("File2");
        lblFile1Path=new JLabel("");
        lblFile2Path=new JLabel("");
        txtArea=new JTextArea("");
        jfcFile1=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfcFile2=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        lblResponse=new JLabel("");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 900);
        setVisible(true);
        setLayout(new FlowLayout());

        add(lblFile1);
        add(btnClickFile1);
        add(lblFile1Path);
        add(lblFile2);
        add(btnClickFile2);
        add(lblFile2Path);
        add(txtArea);
        add(btnClick);
        add(lblResponse);

        btnClickFile1.addActionListener(ep->{
            selectFile1();
        });
        btnClickFile2.addActionListener(ep->{
            selectFile2();
        });
        btnClick.addActionListener(this);

    }

    public static void main(String[] args) {
        ReadFileAndCheckIfContainsSwing readFileAndCheckIfContainsSwing=new ReadFileAndCheckIfContainsSwing();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lblResponse.setVisible(false);
        jfcFile1.setVisible(false);
        jfcFile2.setVisible(false);
        lblFile1Path.setVisible(false);
        lblFile2Path.setVisible(false);

        if(!file1Path.isEmpty() && !file2Path.isEmpty()){
            FileInputStream fis2=null;
            Scanner sc2=null;
            try(FileInputStream  fis1=new FileInputStream(file1Path); Scanner sc1=new Scanner(fis1);) {
                while(sc1.hasNextLine()) {
                    boolean areEqual = true;
                    String sc1String=sc1.nextLine().trim().replace("\"","").replace(",","");
                    fis2=new FileInputStream(file2Path);
                    sc2=new Scanner(fis2);
                    while(sc2.hasNextLine()) {
                        String sc2String=sc2.nextLine().trim().replace("\"","").replace(",","");
                        if(sc1String.equals(sc2String)) {
                            areEqual = false;
                            break;
                        }
                    }
                    if(areEqual) txtArea.append(sc1String+"\n");
                    if(fis2!=null) fis2.close();
                    if(sc2!=null) sc2.close();
                }
            }
            catch(IOException ex) {
                System.out.println(ex.toString());
                //e.printStackTrace();
            }
        }else{
            lblResponse.setText("Something is Wrong");
            lblResponse.setVisible(true);
        }
        txtArea.setBounds(700,700, 700,700);
        txtArea.setVisible(true);
    }

    public void selectFile1(){
        if (jfcFile1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            file1Path=jfcFile1.getSelectedFile().getPath();
            lblFile1Path.setText(file1Path);
            lblFile1Path.setVisible(true);
        } else {
            file1Path="";
        }
    }

    public void selectFile2(){
        if (jfcFile2.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            file2Path=jfcFile2.getSelectedFile().getPath();
            lblFile2Path.setText(file2Path);
            lblFile2Path.setVisible(true);
        } else {
            file2Path="";
        }
    }

}

