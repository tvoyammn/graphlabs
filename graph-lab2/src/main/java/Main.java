import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

class Guitar extends JPanel implements ActionListener {
    double bigPoly[][] = { {-175, 80}, {-50, 0}, {-175, -80}, {-150, 0} };
    double smallPoly[][] = { {120, 0}, {160, 30}, {142, 0}, {160, -30} };
    Timer timer;

    private double scale = 1;
    private double delta = 0.01;


    private static int maxWidth;
    private static int maxHeight;

    public static void main(String[] args) {
        JFrame frame = new JFrame("lab2");
        frame.add(new Guitar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }

    public Guitar() {
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setBackground(new Color(255, 215, 0));
        g2d.clearRect(0, 0, maxWidth + 1, maxHeight + 1);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);


        g2d.translate(200, 125);

        GeneralPath bigPol = new GeneralPath();
        bigPol.moveTo(bigPoly[0][0], bigPoly[0][1]);
        for (int k = 1; k < bigPoly.length; k++)
            bigPol.lineTo(bigPoly[k][0], bigPoly[k][1]);
        bigPol.closePath();

        GeneralPath smallPol = new GeneralPath();
        smallPol.moveTo(smallPoly[0][0], smallPoly[0][1]);
        for (int k = 1; k < smallPoly.length; k++)
            smallPol.lineTo(smallPoly[k][0], smallPoly[k][1]);
        smallPol.closePath();

        g2d.setColor(Color.BLUE);
        g2d.fill(bigPol);
        g2d.fill(smallPol);

        GradientPaint gp = new GradientPaint(5, 25,
                Color.PINK, 20, 2, Color.CYAN, true);
        g2d.setPaint(gp);
        g2d.fillOval(-130, -25, 50, 50);

        g2d.setColor(Color.BLACK);
        g2d.drawLine(-117, -10, 140, -10);
        g2d.drawLine(-117, -6, 140, -6);
        g2d.drawLine(-117, -2, 140, -2);
        g2d.drawLine(-117, 2, 140, 2);
        g2d.drawLine(-117, 6, 140, 6);
        g2d.drawLine(-117, 10, 140, 10);


        g2d.translate(0, 409);
        BasicStroke bs = new BasicStroke(8, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_MITER);
        g2d.setStroke(bs);
        g2d.drawRect(-196, -125, 378, 250);


        g2d.scale(scale, 0.99);


        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) scale));


        g2d.setColor(Color.BLUE);
        g2d.fill(bigPol);
        g2d.fill(smallPol);

        g2d.setPaint(gp);
        g2d.fillOval(-130, -25, 50, 50);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke());
        g2d.drawLine(-117, -10, 140, -10);
        g2d.drawLine(-117, -6, 140, -6);
        g2d.drawLine(-117, -2, 140, -2);
        g2d.drawLine(-117, 2, 140, 2);
        g2d.drawLine(-117, 6, 140, 6);
        g2d.drawLine(-117, 10, 140, 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( scale < 0.01 ) {
            delta = -delta;
        } else if (scale > 0.99) {
            delta = -delta;
        }
        scale += delta;
        repaint();
    }
}
