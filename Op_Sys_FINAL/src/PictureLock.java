import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class PictureLock {
  private JPanel transparentLayer;
  private JPanel first;
  private JPanel second;
  private JPanel third;
  private JPanel four;
  private JPanel five;
  private JPanel six;
  private JPanel entrance;
  
  JLayeredPane layers = new JLayeredPane();
  static File file = new File("///Users/admin/Desktop/CS/Op_Sys_FINAL/src/tacolego.jpg");
 

  public PictureLock() throws IOException {
    int width = 1000;
    int height = 900;
    Image img = ImageIO.read(file);
    final JButton unlockButton = new JButton( "PRESS TO UNLOCK" );
    JButton openButton1 = new JButton( "1" );
    openButton1.setPreferredSize(new Dimension(500,200));
    JButton openButton2 = new JButton( "2" );
    openButton2.setPreferredSize(new Dimension(100,70));
    JButton openButton3 = new JButton( "3" );
    openButton3.setPreferredSize(new Dimension(70,70));
    JButton openButton4 = new JButton( "4" );
    openButton4.setPreferredSize(new Dimension(70,70));
    JButton openButton5 = new JButton( "5" );
    openButton5.setPreferredSize(new Dimension(70,70));
    JButton openButton6 = new JButton( "6" );
    openButton6.setPreferredSize(new Dimension(70,70));
    
    ActionListener actionListener = new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent e ) {
        boolean pressed = e.getSource() == unlockButton;
        transparentLayer.setVisible( pressed );
        first.setVisible( pressed );
        
      }
    };
    ActionListener actionListener2 = new ActionListener() {
        @Override
        public void actionPerformed( ActionEvent e ) {
          boolean pressed = e.getSource() == openButton1;
          transparentLayer.setVisible( pressed );
          //openButton1.setVisible(!pressed);
          first.setVisible(!pressed);
          second.setVisible(pressed);
        }
      };
     
    unlockButton.addActionListener( actionListener );

    JPanel welcomeLayer = new JPanel();
    welcomeLayer.add( unlockButton );
    welcomeLayer.add( new JLabel( "Welcome" ) );
    welcomeLayer.setBounds( 0, 0, width, height );
    layers.setLayout( null );
    layers.setLayer( welcomeLayer, 0 );
    layers.add( welcomeLayer );
    
    ActionListener actionListener3 = new ActionListener() {
        @Override
        public void actionPerformed( ActionEvent e ) {
          boolean pressed = e.getSource() == openButton2;
          second.setVisible(!pressed);
          third.setVisible(pressed);
        }
      };
      
	  ActionListener actionListener4 = new ActionListener() {
	      @Override
	      public void actionPerformed( ActionEvent e ) {
	        boolean pressed = e.getSource() == openButton3;
	        third.setVisible(!pressed);
	        four.setVisible(pressed);
	      }
	    };
	    
	    ActionListener actionListener5 = new ActionListener() {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	          boolean pressed = e.getSource() == openButton4;
	          four.setVisible(!pressed);
	          five.setVisible(pressed);
	        }
	      };
	    ActionListener altactionListener5 = new ActionListener() {
	          @Override
	          public void actionPerformed( ActionEvent e ) {
	            boolean pressed = e.getSource() == openButton4;
	            transparentLayer.setVisible( !pressed );
	            four.setVisible(!pressed);
	            unlockButton.setVisible(!pressed);
	            entrance.setVisible(pressed);
	          }
	        };
	     /*ActionListener actionListener6 = new ActionListener() {
	          @Override
	          public void actionPerformed( ActionEvent e ) {
	            boolean pressed = e.getSource() == openButton5;
	            five.setVisible(!pressed);
	            six.setVisible(pressed);
	          }
	        };
	        
        ActionListener actionListener7 = new ActionListener() {
	          @Override
	          public void actionPerformed( ActionEvent e ) {
	            boolean pressed = e.getSource() == openButton6;
	            transparentLayer.setVisible( !pressed );
	            six.setVisible(!pressed);
	            unlockButton.setVisible(!pressed);
	            entrance.setVisible(pressed);
	          }
	        };
    */
    transparentLayer = new JPanel() {
      @Override
      public void paint( Graphics g ){
    	Image scaledImage = img.getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH);
        g.fillRect( 0, 0, getWidth(), getHeight() );
        g.drawImage(scaledImage, 0, 0, this);
      }
    };
    transparentLayer.setOpaque( false );
    transparentLayer.setBounds( 0, 0, width, height );
    transparentLayer.addMouseListener( new MouseAdapter() {} );
    transparentLayer.setVisible( false );
    layers.setLayer( transparentLayer, 1 );
    layers.add( transparentLayer );
    
    openButton1.addActionListener( actionListener2 );
    openButton2.addActionListener( actionListener3 );
    openButton3.addActionListener( actionListener4 );
    openButton4.addActionListener( altactionListener5 );
    //openButton4.addActionListener( actionListener5 );
    //openButton5.addActionListener( actionListener6 );
    //openButton6.addActionListener( actionListener7 );
    
    first = new JPanel();
    first.setBounds( width / 2 - 500, height / 2 + 190 , 600, 280 );
    first.setOpaque(false);
    openButton1.setOpaque(false);
    openButton1.setContentAreaFilled(false);
    openButton1.setBorderPainted(false);
    first.add( openButton1 );
    first.setVisible( false );
    layers.setLayer( first, 2 );
    layers.add( first );
    
    second = new JPanel();
    second.setBounds( width / 2 - 105, height / 2 - 40, 100, 100 );
    second.setOpaque(false);
    openButton2.setOpaque(false);
    openButton2.setContentAreaFilled(false);
    openButton2.setBorderPainted(false);
    second.add( openButton2 );
    second.setVisible( false );
    layers.setLayer( second, 3 );
    layers.add( second );
    
    third = new JPanel();
    third.setBounds( width / 2 + 50, height / 2 + 250, 100, 100 );
    third.setOpaque(false);
    openButton3.setForeground(Color.WHITE);
    openButton3.setOpaque(false);
    openButton3.setContentAreaFilled(false);
    openButton3.setBorderPainted(false);
    third.add( openButton3 );
    third.setVisible( false );
    layers.setLayer( third, 4 );
    layers.add( third );
    
    four = new JPanel();
    four.setBounds( width / 2 + 140, height / 2 - 400, 100, 100 );
    four.setOpaque(false);
    openButton4.setForeground(Color.WHITE);
    openButton4.setOpaque(false);
    openButton4.setContentAreaFilled(false);
    openButton4.setBorderPainted(false);
    four.add( openButton4 );
    four.setVisible( false );
    layers.setLayer( four, 5 );
    layers.add( four );
    
   /* five = new JPanel();
    five.setBounds( width / 2 - 200, height / 2 - 250, 100, 100 );
    five.setOpaque(false);
    openButton5.setOpaque(false);
    openButton5.setContentAreaFilled(false);
    openButton5.setBorderPainted(false);
    five.add( openButton5 );
    five.setVisible( false );
    layers.setLayer( five, 6 );
    layers.add( five );
    
    six = new JPanel();
    six.setBounds( width / 2 - 200, height / 2 + 200, 100, 100 );
    six.setOpaque(false);
    openButton6.setOpaque(false);
    openButton6.setContentAreaFilled(false);
    openButton6.setBorderPainted(false);
    six.add( openButton6 );
    six.setVisible( false );
    layers.setLayer( six, 7 );
    layers.add( six );*/
    
    entrance = new JPanel();
    entrance.setBounds( width / 2 - 50, height / 2 - 50, 100, 100 );
    entrance.add( new JLabel( "Now Unlocked" ) );
    entrance.setVisible( false );
    layers.setLayer( entrance, 8 );
    layers.add( entrance );

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setBounds( ( screenSize.width - width ) / 2, ( screenSize.height - height ) / 2, width, height );
    frame.add( layers );
    frame.setVisible( true );
  }

  
}