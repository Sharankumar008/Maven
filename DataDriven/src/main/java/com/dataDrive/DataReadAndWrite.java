package com.dataDrive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReadAndWrite {

	public static void readData() throws IOException {
		File f = new File(System.getProperty("user.dir") + "\\Resources\\data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet sheet = w.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);

		CellType cellType = cell.getCellType();

		if (cellType.equals(CellType.STRING)) {
			System.out.println(cell.getStringCellValue());
		} else if (cellType.equals(CellType.NUMERIC)) {
			System.out.println((int) cell.getNumericCellValue());
		}
		fi.close();

	}

	public static void readMultiData() throws IOException {
		File f = new File(System.getProperty("user.dir") + "\\Resources\\Book.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet sheet = w.getSheet("Sheet2");

		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();

		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row row = sheet.getRow(i);
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < physicalNumberOfCells; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();

				if (cellType.equals(CellType.STRING)) {
					System.out.println(cell.getStringCellValue());
				} else if (cellType.equals(CellType.NUMERIC)) {
					System.out.println((int) cell.getNumericCellValue());
				}

			}
		}
		fi.close();

	}

	public static void writeData() throws IOException {
		File f = new File(System.getProperty("user.dir") + "\\Resources\\data.xlsx");
		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);
		Sheet sheet = w.createSheet("Sheet3");
		Row row0 = sheet.createRow(0);

		row0.createCell(0).setCellValue("sharan");
		row0.createCell(1).setCellValue("kumar");
		row0.createCell(2).setCellValue("ram");
		row0.createCell(3).setCellValue("viji");
		
		Row row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("a");
		row1.createCell(1).setCellValue("b");
		row1.createCell(2).setCellValue("c");
		row1.createCell(3).setCellValue("d");
		
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);

		fo.close();
		w.close();
		fi.close();

	}

	public static void main(String[] args) throws IOException {
		readData();
		readMultiData();
		writeData();
	}

}
