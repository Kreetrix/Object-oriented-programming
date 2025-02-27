package View;

import Model.Pet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PetView extends JPanel {
    private Pet pet;
    private BufferedImage petImage;
    private int targetX, targetY;
    private boolean isMouseInsideCanvas = false;

    public PetView(Pet pet) {
        this.pet = pet;
        this.targetX = pet.getX();
        this.targetY = pet.getY();
        setPreferredSize(new Dimension(800, 600));
        try {
            petImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/pet.png")));
        } catch (IOException e) {
            System.err.println("No image");
            e.printStackTrace();
        }

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                targetX = e.getX();
                targetY = e.getY();
                isMouseInsideCanvas = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseInsideCanvas = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (petImage != null) {
            g.drawImage(petImage, pet.getX(), pet.getY(), this);
        } else {
            System.out.println("No image!");
        }
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public boolean isMouseInsideCanvas() {
        return isMouseInsideCanvas;
    }
}