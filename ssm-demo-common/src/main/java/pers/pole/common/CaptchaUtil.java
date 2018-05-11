package pers.pole.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class CaptchaUtil
{

	/**
	 * 生成验证码图片
	 * 
	 * @return
	 * @throws IOException
	 */
	public static byte[] createImage(String captcha )
	{
		Random random = new Random();
		int width = 100;
		int height = 34;
		int fontSize = 30;
		int fontBottom = height - 10;
		int fontLeft = 10;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Arial Black", Font.PLAIN, fontSize));
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(new Color(random.nextInt(255), random.nextInt(100), random.nextInt(255)));
//		for (int i = 0; i < 200; i++) // 干扰线
//		{
//			int x = random.nextInt(width);
//			int y = random.nextInt(height);
//			int x1 = random.nextInt(2);
//			int y1 = random.nextInt(2);
//			g2d.drawLine(x, y, x + x1, y + y1);
//		}
		for (int i = 0; i < captcha.length(); i++)
		{
			double angle = 0;
			if (random.nextBoolean())
			{
				angle = random.nextDouble() / 2;
			} else
			{
				angle = -random.nextDouble() / 2;
			}
			g2d.rotate(angle, fontLeft + i * 20, height / 2);
			TextLayout textLayout = new TextLayout(String.valueOf(captcha.charAt(i)), g2d.getFont(), g2d.getFontRenderContext());
			AffineTransform translateInstance = AffineTransform.getTranslateInstance(fontLeft + i * 20, fontBottom);
			Shape shape = textLayout.getOutline(translateInstance);
			g2d.draw(shape);
			g2d.rotate(-angle, fontLeft + i * 20, height / 2);
		}
		int[] xPoint =
		{ random.nextInt(20), 20 + random.nextInt(20), 40 + random.nextInt(20), 60 + random.nextInt(20), 80 + random.nextInt(20), };
		int[] yPoint =
		{ random.nextInt(34), random.nextInt(34), random.nextInt(34), random.nextInt(34), random.nextInt(34) };
		g2d.drawPolyline(xPoint, yPoint, 5);
		g2d.dispose();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "JPEG", baos);
			baos.close();
		} catch (IOException e) {
		}
		return baos.toByteArray();
	}
}
