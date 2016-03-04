/**
 * 
 */
package controllers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.ImageOutputStreamImpl;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * @author guangpeng.zhao
 *
 */
public class ImageCheckAction extends Controller{
	
	
	/**
	 * 获取二维码
	 * @return
	 */
	public static Result getCheckImage(){
		response().setHeader("Pragma", "No-cache");  
        response().setHeader("Cache-Control", "No-cache");  
        response().setContentType("image/jpeg");
        
        int width=76,height=26;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        //创建画笔
        Graphics g = image.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        
        Random random = new Random();
        Font mfont = new Font("楷体", Font.BOLD, 18);
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(mfont);
        g.setColor(getRandColor(180, 200));
        
        //回执100条颜色和位置全部为随机产生的线条，该线条为2f
        for(int i=0;i<100;i++){  
            int x=random.nextInt(width-1);  
            int y=random.nextInt(height-1);  
            int x1=random.nextInt(6)+1; //6 
            int y1=random.nextInt(12)+1;//12  
            BasicStroke bs=new BasicStroke(2f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL); //定制线条样式  
            Line2D line=new Line2D.Double(x,y,x+x1,y+y1);  
            g2d.setStroke(bs);  
            g2d.draw(line);     //绘制直线  
        } 
        
      //输出由英文，数字，和中文随机组成的验证文字，具体的组合方式根据生成随机数确定。  
        String sRand="";  
        String ctmp="";  
        int itmp=0;  
        
        //制定输出的验证码为四位  
        for(int i=0;i<4;i++){  
            switch(random.nextInt(3)){  
                case 1:     //生成A-Z的字母  
                     itmp=random.nextInt(26)+65;  
                     ctmp=String.valueOf((char)itmp);  
                     break;  
                case 2:     //生成数字 
                	 itmp=random.nextInt(10)+48;  
                     ctmp=String.valueOf((char)itmp);  
                     break;  
                default:  
                     itmp=random.nextInt(10)+48;  
                     ctmp=String.valueOf((char)itmp);  
                     break;  
            }  
            sRand+=ctmp;  
            Color color=new Color(20+random.nextInt(110),20+random.nextInt(110),random.nextInt(110));  
            g.setColor(color);  
            //将生成的随机数进行随机缩放并旋转制定角度 PS.建议不要对文字进行缩放与旋转,因为这样图片可能不正常显示  
            /*将文字旋转制定角度*/  
            Graphics2D g2d_word=(Graphics2D)g;  
            AffineTransform trans=new AffineTransform();  
            trans.rotate((45)*3.14/180,15*i+8,7);  
            /*缩放文字*/  
            float scaleSize=random.nextFloat()+0.8f;  
            if(scaleSize>1f) scaleSize=1f;  
            trans.scale(scaleSize, scaleSize);  
            g2d_word.setTransform(trans);  
            g.drawString(ctmp, 15*i+16, 12); //  g.drawString(ctmp, 15*i+18, 14);
        }
  
        g.dispose();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
			ImageIO.write(image, "JPEG", bos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sRand);
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		return ok(bis);
		
	}
	
	 /*该方法主要作用是获得随机生成的颜色*/   
    public static Color getRandColor(int s,int e){  
        Random random=new Random ();  
        if(s>255) s=255;  
        if(e>255) e=255;  
        int r,g,b;  
        r=s+random.nextInt(e-s);    //随机生成RGB颜色中的r值  
        g=s+random.nextInt(e-s);    //随机生成RGB颜色中的g值  
        b=s+random.nextInt(e-s);    //随机生成RGB颜色中的b值  
        return new Color(r,g,b);  
    }  

}
