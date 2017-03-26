import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File("3.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color firstColor = new Color(img.getRGB(0,0));
        Color nextColor = null;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                nextColor = new Color(img.getRGB(i,j));
                if(!nextColor.equals(firstColor)){
                    image.setRGB(i, j, new Color(255, 255, 255).getRGB());
                }
            }
        }


        File file = new File("output.png");
        ImageIO.write(image, "png", file);

    }
}
