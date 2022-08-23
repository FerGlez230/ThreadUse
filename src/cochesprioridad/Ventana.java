/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cochesprioridad;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author maryf
 */
public class Ventana extends JFrame implements ActionListener {
    private Graphics gBuffer;
    BufferedImage buffer;
    Image imageFondo, image;
    int xAnimacion=0;
    String urlAnimacion="";
    private Data data;
    private JButton btnSur, btnNorte;
    
    public void inicializar(){ 
        setSize(800,500);
        setTitle("Problema carretera");
        setLayout(null);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        
        btnSur=new JButton("Agregar");
        btnSur.setBounds(660,20,100,30);
        btnSur.setForeground(Color.BLACK);
        btnSur.setBackground(Color.WHITE);
        
        btnNorte=new JButton("Agregar");
        btnNorte.setBounds(20,20,100,30);
        btnNorte.setForeground(Color.BLACK);
        btnNorte.setBackground(Color.WHITE);
        
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        btnSur.setBorder(compound);
        btnSur.addActionListener(this);
        
        btnNorte.setBorder(compound);
        btnNorte.addActionListener(this);
        
        
        add(btnSur);
        add(btnNorte);
        //
        String url = "/img/fondo.png";
        imageFondo = new ImageIcon(getClass().getResource(url)).getImage();
        
       
        setVisible(true);
        }
     public Ventana(Data data){
        this.data=data;
        inicializar();
    }
     public void paint(Graphics g){
        super.paint(g);
        add(btnSur);
        add(btnNorte);
        update(g);
       
    }
     public void dibujarFondo(){
       buffer=new BufferedImage(800,500,BufferedImage.TYPE_INT_ARGB);
       gBuffer=buffer.getGraphics();
       
      
       gBuffer.drawImage(imageFondo, 0, 100, 800,500,this);
       add(btnSur);
       add(btnNorte);
       gBuffer.setColor(Color.BLACK);
       gBuffer.fillRect(0, 320, 210, 500);
       gBuffer.fillRect(590, 320, 800, 500);
       showInfo("Total: "+data.getNorte(),20,250);
       showInfo("Total: "+data.getSur(),670,250);
       dibujarAuto("cocheNorte.png",0,310,data.getNorte());
       dibujarAuto("cocheSur.png",590,310,data.getSur());
     }
     public void update(Graphics g){ 
     
       dibujarFondo();
      
       image = new ImageIcon(getClass().getResource("/img/"+urlAnimacion)).getImage();
       gBuffer.drawImage(image, xAnimacion, 380,68,68, this);
       
       g.drawImage(buffer, 0, 0, this);
       
    }
      public void showInfo(String msg,int x, int y){
        Graphics2D g2 = (Graphics2D) gBuffer;
        g2.setColor(Color.BLACK);
        Font fuente=new Font("Tahoma", Font.BOLD, 19);
        g2.setFont(fuente);
        g2.setStroke(new BasicStroke(3));
        g2.drawString(msg,x, y);
    }
    public void dibujarAuto(String url, int xInicial, int yInicial, int total){
        int x=xInicial;
        int y=yInicial;
        int cont=0;
        for(int i=0; i<total; i++){
            image = new ImageIcon(getClass().getResource("/img/"+url)).getImage();
            gBuffer.drawImage(image, x, y,68,68, this);
            x+=70;
            cont++;
            if(cont==3){
                x=xInicial;
                y+=35;
                cont=0;
            }
        }
    }
    public void animacionAuto(String url, int x){
       //380 se avanza
        
 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnSur) {
            data.setSur(data.getSur()+1);
            update(getGraphics());
        }
        if (e.getSource()==btnNorte) {
            data.setNorte(data.getNorte()+1);
            update(getGraphics());
        }
    }
      
}
