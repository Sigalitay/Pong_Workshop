
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import javax.swing.*;

public class GameDriver extends JComponent implements KeyListener, MouseListener, MouseMotionListener {

    //instance variables
    static final int WIDTH = 1080;
    static final int HEIGHT = 800;

    //Default Constructor
    public GameDriver() {
        //Setting up the GUI
        JFrame gui = new JFrame(); //This makes the gui box
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes sure program can close
        gui.setTitle("Default Title Name"); //This is the title of the game, you can change it
        gui.setPreferredSize(new Dimension(WIDTH, HEIGHT + 23)); //Setting the size for gui
        gui.setResizable(false); //Makes it so the gui cant be resized
        gui.getContentPane().add(this); //Adding this class to the gui

        gui.pack(); //Packs everything together
        gui.setLocationRelativeTo(null); //Makes so the gui opens in the center of screen
        gui.setVisible(true); //Makes the gui visible
        gui.addKeyListener(this);//stating that this object will listen to the keyboard
        gui.addMouseListener(this); //stating that this object will listen to the Mouse
        gui.addMouseMotionListener(this); //stating that this object will acknowledge when the Mouse moves

    }

    //All your UI drawing goes in here
    public void paintComponent(Graphics g) {
    }

    public void loop() {
        repaint();//How the UI refreshes
    }

    public void start(final int ticks) {
        Thread gameThread = new Thread(() -> {
            while (true) {
                loop();
                try {
                    Thread.sleep(1000 / ticks);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        gameThread.start();
    }

    public static void main(String[] args) {
        GameDriver g = new GameDriver();
        g.start(60);
    }


    //Action Listeners
    //These method will acknowledge user input
    public void keyPressed(KeyEvent e) {
        //getting the key pressed
        int key = e.getKeyCode();
        //System.out.println(key);
    }

    public void keyReleased(KeyEvent e) {
        //System.out.println(e.getKeyCode() + " " + e.getKeyChar());
        int key = e.getKeyCode();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }
}
