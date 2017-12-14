package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class image {
    public static int[] ran() {
        //设置图片宽度和高度
        int width = 150;
        int height = 60;
        //干扰线条数
        int lines = 10;
//        验证码数组
        int[] random = new int[4];
        Random r = new Random();
        BufferedImage b = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = b.getGraphics();
        g.setFont(new Font("宋体", Font.BOLD, 30));
        for (int i = 0; i < 4; i++) {
            int number = r.nextInt(10);
            random[i] = number;
            int y = 10+r.nextInt(40);// 10~40范围内的一个整数，作为y坐标
            //随机颜色，RGB模式
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g.setColor(c);
//            g.drawString("" + a, 5 + i * width / 4, y);
            //写验证码
            g.drawString(Integer.toString(number), 5 + i * width / 4, y);
        }
        for (int i = 0; i < lines; i++) {
            //设置干扰线颜色
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g.setColor(c);
            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
        }
        try {
            //清空缓冲
            g.dispose();
            //向文件中写入
            ImageIO.write(b, "jpg", new File("E:\\IntelliJ IDEA\\mail\\web\\imagecode\\test.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return random;
    }

    //测试
    public static void main(String[] args) {
        ran();
    }
}
