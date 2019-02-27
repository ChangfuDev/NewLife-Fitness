package com.newlife.fitness.rearend.web.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.newlife.fitness.entity.Course;
import com.newlife.fitness.entity.FUser;
import com.newlife.fitness.entity.Train;


public class WorkUtils
{
	/**
	 * 课程
	 * @param Path
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static List<Course> importCourse(InputStream file) throws IOException {
		List<Course> courses = new ArrayList<Course>();
		POIFSFileSystem fs = new POIFSFileSystem(file);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Course course = new Course();
			HSSFRow row = sheet.getRow(i);
			if (row != null) {
				HSSFCell cell = row.getCell(0);
				course.setcName(cell.getStringCellValue().toString());
				cell = row.getCell(1);
				course.setcIsvip(cell.getStringCellValue().toString());
				courses.add(course);
			}
		}
		return courses;
	}
	
	/**
	 * 导入教练
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static List<Train> importTrain(InputStream file) throws IOException {
		List<Train> trains = new ArrayList<Train>();
		POIFSFileSystem fs = new POIFSFileSystem(file);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
 			Train train = new Train();
			HSSFRow row = sheet.getRow(i);
			if (row != null) {
				HSSFCell cell = row.getCell(0);
				train.settUsername(cell.getStringCellValue().toString());
				cell = row.getCell(1);
				train.settLoginname(cell.getStringCellValue().toString());
				cell = row.getCell(2);
				train.settPassword(cell.getStringCellValue().toString());
				cell = row.getCell(3);
				train.settSex(cell.getStringCellValue().toString());
				cell = row.getCell(4);
				train.settAge((int) cell.getNumericCellValue());
				cell = row.getCell(5);
				train.settAddress(cell.getStringCellValue().toString());
				cell = row.getCell(6);
				train.settEmail(cell.getStringCellValue().toString());
				cell = row.getCell(7);
				DecimalFormat df = new DecimalFormat("#");
				String phone = df.format(cell.getNumericCellValue());
				train.settPhone(phone);
				cell = row.getCell(8);
				train.settIsvip(cell.getStringCellValue().toString());
				cell = row.getCell(9);
				train.settImgurl(cell.getStringCellValue().toString());
				
				trains.add(train);
			}
		}
		return trains;
	}
	
	@SuppressWarnings("resource")
	public static List<FUser> importFUser(InputStream file) throws IOException {
		List<FUser> fUsers = new ArrayList<FUser>();
		POIFSFileSystem fs = new POIFSFileSystem(file);
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			FUser fuser = new FUser();
			HSSFRow row = sheet.getRow(i);
			if (row != null) {
				HSSFCell cell = row.getCell(0);
				fuser.setfUserName(cell.getStringCellValue().toString());
				cell = row.getCell(1);
				fuser.setfLoginname(cell.getStringCellValue().toString());
				cell = row.getCell(2);
				fuser.setfPassword(cell.getStringCellValue().toString());
				cell = row.getCell(3);
				fuser.setfSex(cell.getStringCellValue().toString());
				cell = row.getCell(4);
				fuser.setfAge((int) cell.getNumericCellValue());
				cell = row.getCell(5);
				fuser.setfAddress(cell.getStringCellValue().toString());
				cell = row.getCell(6);
				fuser.setfEmail(cell.getStringCellValue().toString());
				cell = row.getCell(7);
				DecimalFormat df = new DecimalFormat("#");
				String phone = df.format(cell.getNumericCellValue());
				fuser.setfPhone(phone);
				cell = row.getCell(8);
				fuser.setfIsvip(cell.getStringCellValue().toString());
				cell = row.getCell(9);
				fuser.setfImgurl(cell.getStringCellValue().toString());
				fUsers.add(fuser);
			}
		}
		return fUsers;
	}
	
}
