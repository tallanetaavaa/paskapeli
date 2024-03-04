package entity;

import main.KeyHandler;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    private int x, y;
    GamePanel gp;
    KeyHandler KeyH;
    public Player(GamePanel gp, KeyHandler KeyH){

        this.gp = gp;
        this.KeyH = KeyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){

        try{
          /*  up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
           left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
          left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
          right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
           right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
*/
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/mies7.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/mies6.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/mies0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/mies1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/mies5.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/mies4.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/mies2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/mies3.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){

        if (KeyH.upPressed || KeyH.downPressed || KeyH.leftPressed || KeyH.rightPressed) {

            if (KeyH.upPressed) {
                direction = "up";
                y -= speed;
            }
            if (KeyH.downPressed) {
                direction = "down";
                y += speed;
            }
            if (KeyH.leftPressed) {
                direction = "left";
                x -= speed;
            }
            if (KeyH.rightPressed) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter > 20) {
                if (spriteNum == 1){
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }


    }
    public void draw(Graphics2D g2){
        // neliö
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
