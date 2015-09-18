package com.qizhu.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

/**
 * java生成缩略图
 * 
 * @author zq
 * 
 */
public class ThumbnailatorUtil {

	private static List<String> filelist = new ArrayList<String>();

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// BufferedImage originalImage = ImageIO.read(new
		// File("D:\\springmvc\\DATA\\aa.jpg"));
		//
		// BufferedImage thumbnail = Thumbnails.of(originalImage)
		// .scale(1f)
		// .asBufferedImage();

		 testHandlePicture();
		// 递归显示C盘下所有文件夹及其中文件

//		 List<String> aaList =refreshFileList("D:\\aa\\bb");
//		 dealAllIage("D:\\aa\\bb", aaList);
		// for(String bb:aaList){
		// System.out.println(bb);
		// }
//		dealAllIage();
//		getFileList("D:\\aa");

	}

	public static void testHandlePicture() throws Exception {

		// 创建图片文件(此处为1024×768px的图片)和处理后的图片文件
		// File fromPic=new File("picture/测试图片1024px-768px.jpg");
		File fromPic = new File("D:\\springmvc\\DATA\\aa.jpg");
		// File toPic=new File("picture/结果图片.jpg");
		File toPic = new File("D:\\springmvc\\DATA\\bb.jpg");
		File waterPic = new File("picture/水印图片.jpg");// 作为水印的图片
		// F:\soft\apache-tomcat-7.0.40（ITSM64）\webapps\ROOT\2015\03
		// //递归显示C盘下所有文件夹及其中文件
		// File root = new File("D:\\aa");
		// List<String> aaList =showAllFiles(root);
		// for(String bb:aaList){
		// System.out.println(bb);
		// }

		List<File> iterable = new ArrayList<File>();
		iterable.add(new File("D:\\aa\\aa.jpg"));
		iterable.add(new File("D:\\aa\\bb.png"));
		iterable.add(new File("D:\\aa\\cc.jpg"));
		// 按指定大小把图片进行缩和放（会遵循原图高宽比例）
		// 此处把图片压成400×500的缩略图
		// Thumbnails.of(fromPic).size(400,500).toFile(toPic);//变为400*300,遵循原图比例缩或放到400*某个高度
		// 图片尺寸不变，压缩图片文件大小outputQuality实现,参数1为最高质量
		// Thumbnails.of(fromPic).scale(1f).outputQuality(0.25f).toFile(toPic);
		// URL url = new URL("http://wx.qi-zhu.com//2015/06/23/yunshirili.png");
		 Thumbnails.of(fromPic).scale(1f).outputQuality(0.25f).toFile(toPic);
//		Thumbnails.of(new File("D:\\aa").listFiles()).scale(1f)
//				.outputQuality(0.25f)
//				// .toFiles(Rename.PREFIX_DOT_THUMBNAIL);
//				.toFiles(iterable);
	}

	/**
	 * 处理图片
	 * @param dir
	 * @param aaList
	 * @throws IOException
	 */
	public static void dealAllIage(String dir,List<String> aaList) throws IOException {
		// List<String> aaList
		// =refreshFileList("F:\\soft\\apache-tomcat-7.0.40（ITSM64）\\webapps\\ROOT\\2015\\03");
//		List<String> aaList = refreshFileList("D:\\aa");
		List<File> iterable = new ArrayList<File>();
		for (String bb : aaList) {
			System.out.println(bb);
			iterable.add(new File(bb));
		}
		if (iterable != null&&iterable.size()>0) {

			Thumbnails.of(new File(dir).listFiles()).scale(1f)
					.outputQuality(0.25f)
					// .toFiles(Rename.PREFIX_DOT_THUMBNAIL);
					.toFiles(iterable);
		}
	}

	/**
	 * 遍历文件夹下所有的文件
	 * 
	 * @param strPath
	 * @return
	 */
	public static List<String> refreshFileList(String strPath) {
		File dir = new File(strPath);
		File[] files = dir.listFiles();

		if (files == null) {
			return null;
		}
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {

				refreshFileList(files[i].getAbsolutePath());
			} else {
				String strFileName = files[i].getAbsolutePath().toLowerCase();
				// System.out.println("---"+strFileName);
				filelist.add(files[i].getAbsolutePath());
			}
		}
		return filelist;
	}

	/**
	 * 遍历文件夹下所有的文件
	 * 
	 * @param strPath
	 * @return
	 * @throws IOException 
	 */
	public static List<String> getFileList(String strPath) throws IOException {
		
		List<String> filelist = new ArrayList<String>();
		
		File dir = new File(strPath);
		File[] files = dir.listFiles();

		if (files == null) {
			return null;
		}
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {

				refreshFileList(files[i].getAbsolutePath());
			} else {
				String strFileName = files[i].getAbsolutePath().toLowerCase();
				// System.out.println("---"+strFileName);
				filelist.add(files[i].getAbsolutePath());
				
			}
		}
		
		List<File> iterable = new ArrayList<File>();
		for (String bb : filelist) {
			System.out.println(bb);
			iterable.add(new File(bb));
		}
		Thumbnails.of(new File(strPath).listFiles()).scale(1f)
		.outputQuality(0.25f)
		// .toFiles(Rename.PREFIX_DOT_THUMBNAIL);
		.toFiles(iterable);
		return filelist;
	}
	
	
	

}
