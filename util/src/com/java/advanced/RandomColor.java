package com.java.advanced;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * 随机颜色生成
 * @author 许源
 * 2019.3.12
 */
public class RandomColor {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        //生成redRandom
        int red = random.nextInt(256);
        //生成greenRandom
        int green = random.nextInt(256);
        //生成blueRandom
        int blue = random.nextInt(256);
        System.out.println("R:" + red + ",G:" + green + ",B:" + blue);
        //开始使用随机颜色绘制图片
        //1 先生成缓冲区生成一个图片对象
        BufferedImage bufferedImage = new BufferedImage(120, 40, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = bufferedImage.getGraphics();
        //设置一个字体
        Font font = new Font("微软雅黑", Font.BOLD, 16);
        g.setFont(font);
        //设置画笔颜色,使用随机的颜色
        Color color = new Color(red, green, blue);
        g.setColor(color);
        //开始绘制,充满绘制矩形，充满缓冲区
        g.fillRect(0, 0, 120, 40);
        //绘制文字
        g.setColor(color.BLACK);
        Graphics2D graphics2d = (Graphics2D) g;
        String s = "ABCDEFGHGKLMNPQRSTUVWXYZ23456789";
        Random random1 = new Random();
//session中要用到
        String msg="";
        int x = 5;
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(32);
            String content = String.valueOf(s.charAt(index));
            msg+=content;
            double theta = random.nextInt(45) * Math.PI / 180;
            //让字体扭曲
            graphics2d.rotate(theta, x, 18);
            graphics2d.drawString(content, x, 18);
            graphics2d.rotate(-theta, x, 18);
            x += 30;
        }
        //输出图片
        //指定文件路径
        File file = new File("D:/code.jpg");
        for(int i=0;i<16;i++){
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            //画线
            g.drawLine(random.nextInt(70), random.nextInt(340), random.nextInt(70), random.nextInt(40));
        }
        //获取字节输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片从缓冲区通过字节流
        ImageIO.write(bufferedImage, "jpg", outputStream);
        //关闭输出流
        outputStream.close();
        ArrayList<Object> array = new ArrayList<Object>();
        for (int i = 0; i < 4; i++) {
            int choice = random.nextInt(3);
            switch (choice) {
                case 0:
                    int num = random.nextInt(9);
                    array.add(num);
                    break;
                case 1:
                    int num2 = random.nextInt(25) + 65;
                    char low = (char) num2;
                    array.add(low);
                    break;
                case 2:
                    int num3 = random.nextInt(25) + 97;
                    char high = (char) num3;
                    array.add(high);
                    break;
                default:
                    break;
            }
        }
        System.out.println("你得到的四位验证码：");
        for (Object object : array) {
            System.out.print(object);
        }
    }

}


