import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class HoverButton extends JLabel {

    private static final int LIFT = 10;
    private static final int ALPHA_CUTOFF = 40;   // 0-255, pixels fainter than this don't count

    private final BufferedImage img;
    private final int imgW, imgH;
    private boolean hovered = false;

    public HoverButton(String path, int x, int y, int w, int h, Runnable onClick) {
        this.imgW = w;
        this.imgH = h;

        // draw the PNG into a BufferedImage so we can read its pixels
        Image original = new ImageIcon(path).getImage();
        img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.drawImage(original, 0, 0, w, h, null);
        g2.dispose();

        setBounds(x, y - LIFT, w, h + LIFT);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                onClick.run();
            }
        });
    }

    // Only the visible (non-transparent) part of the image counts as the button
    @Override
    public boolean contains(int px, int py) {
        int ix = px;
        int iy = py - LIFT;   // always test the resting position, so it never flickers
        if (ix < 0 || ix >= imgW || iy < 0 || iy >= imgH) {
            return false;
        }
        int alpha = (img.getRGB(ix, iy) >>> 24) & 0xFF;
        return alpha > ALPHA_CUTOFF;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0, hovered ? 0 : LIFT, null);
    }
}