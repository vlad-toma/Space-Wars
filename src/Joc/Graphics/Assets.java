package Joc.Graphics;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage invisible;
    public static BufferedImage rock1;
    public static BufferedImage rock2;
    public static BufferedImage planeta1;
    public static BufferedImage planeta2;
    public static BufferedImage planeta3;
    public static BufferedImage nava1;
    public static BufferedImage projectile_up1;
    public static BufferedImage projectile_down1;
    public static BufferedImage enemy1_1;
    public static BufferedImage enemy1_2;
    public static BufferedImage boss1_1;

    public static BufferedImage enemy2_1;
    public static BufferedImage enemy2_2;
    public static BufferedImage boss2_1;
    public static BufferedImage boss2_2;
    public static BufferedImage enemy3_1;
    public static BufferedImage enemy3_2;
    public static BufferedImage boss3_1;
    public static BufferedImage boss3_2;

    public static void Init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/tilemap1.png"));
        invisible = sheet.crop(0, 0);
        rock1 = sheet.crop(1, 0);
        rock2 = sheet.crop(2, 0);
        planeta1 = sheet.crop(3, 0);
        planeta2 = sheet.crop(4, 0);
        planeta3 = sheet.crop(5, 0);
        nava1 = ImageLoader.LoadImage("/nava1.png");
        projectile_up1 = ImageLoader.LoadImage("/projectile_up1.png");
        enemy1_1 = ImageLoader.LoadImage("/level 1/Inamic1.png");
        enemy1_2 = ImageLoader.LoadImage("/level 1/Inamic2.png");
        projectile_down1 = ImageLoader.LoadImage("/projectile_down1.png");
        boss1_1 = ImageLoader.LoadImage("/level 1/Boss1.png");
        enemy2_1 = ImageLoader.LoadImage("/level 2/inamic2.png");
        enemy2_2 = ImageLoader.LoadImage("/level 2/inamic3.png");
        boss2_1 = ImageLoader.LoadImage("/level 2/inamic1.png");
        boss2_2 = ImageLoader.LoadImage("/level 2/inamic4.png");
        enemy3_1 = ImageLoader.LoadImage("/level 3/inamic1.png");
        enemy3_2 = ImageLoader.LoadImage("/level 3/inamic2.png");
        boss3_1 = ImageLoader.LoadImage("/level 3/boss1.png");
        boss3_2 = ImageLoader.LoadImage("/level 3/boss2.png");
    }
}
