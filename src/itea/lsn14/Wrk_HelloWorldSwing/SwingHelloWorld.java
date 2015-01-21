package itea.lsn14.Wrk_HelloWorldSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Swing Hello World
 */
public class SwingHelloWorld {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
        System.out.println("Main thread finished");
    }
    private static void createAndShowGUI() {
        JLabel label = new JLabel("Hello World!", SwingConstants.CENTER);
        label.setFont(new Font(null, Font.PLAIN, 72));
        JMenu menu = new JMenu();
        JMenuItem mItFile = new JMenuItem();
        mItFile.setText("File");
        menu.add(mItFile);
        JMenuItem mItHelp = new JMenuItem();
        mItHelp.setText("Help");
        menu.add(mItHelp);
        //JButton button = new JButton();
        //button.setText("1234");
        JFrame frame = new HelloWorldFrame("Hello!");
        frame.getContentPane().add(label, BorderLayout.CENTER);
        //frame.getContentPane().add(menu, BorderLayout.PAGE_START);
        //frame.getContentPane().add(button, BorderLayout.CENTER);
        /*When the last displayable window within the Java virtual machine (VM) is disposed of,
        the VM may terminate.*/
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*Sets preferred size (minimum to layout components)*/
        //frame.pack();
        frame.setVisible(true);
    }
    static class HelloWorldFrame extends JFrame {
        private static final int DEFAULT_WIDTH = 640;
        private static final int DEFAULT_HEIGHT = 480;
        public HelloWorldFrame(String title) throws HeadlessException {
            super(title);
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
}
