package com.teamSupport.allSport;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import com.teamSupport.allSport.dto.Contest;

public class PoiRead {
	static Connection con = null; 
	static PreparedStatement pstmt; 
	static String driver = "com.mysql.cj.jdbc.Driver"; 
	static String url = "jdbc:mysql://127.0.0.1:3306/allsportdb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&autoReconnection=true"; // 연결문자열 
	static String user = "allsport"; 
	static String pw = "allsport123";
	static String SQL = "insert into contest values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
	
	public static void insert(String a[]) {
		try { 
			Class.forName(driver); 
			con = DriverManager.getConnection(url, user, pw);  
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, Integer.parseInt(a[0]));
			pstmt.setInt(2, Integer.parseInt(a[1])); 
			pstmt.setString(3, a[2]); 
			pstmt.setString(4, a[3]); 
			pstmt.setString(5, a[4]); 
			pstmt.setString(6, a[5]); 
			pstmt.setString(7, a[6]); 
			pstmt.setString(8, a[7]); 
			pstmt.setString(9, a[8]); 
			pstmt.setString(10, a[9]); 
			pstmt.setString(11, a[10]); 
			pstmt.setString(12, a[11]); 
			pstmt.setString(13, a[12]); 
			int r = pstmt.executeUpdate(); 
			System.out.println("변경된 row : " + r); } 
		catch (SQLException e) { 
			System.out.println("[SQL Error : " + e.getMessage() + "]"); } 
		catch (ClassNotFoundException e1) { 
			System.out.println("[JDBC Connector Driver 오류 : " + e1.getMessage() + "]"); } 
		}
	
	public static void main(String[] args) throws Exception {
		File path = new File(".");
		System.out.println(path.getAbsolutePath());
		FileInputStream fis = null;
		Workbook workbook = null;
		pstmt = null;
		try {
			//2~10 12~14 
			// /Users/hwangseon-a/Downloads/AllSport-master/doc/20190820.xls 상대주소로바꿔야함 
			fis = new FileInputStream("/Users/hwangseon-a/AllSport-master/doc/20190820.xls"); // Excel file
			workbook = WorkbookFactory.create(fis); // Excel 파일을 POI로 읽어옴
			Sheet sheet = workbook.getSheetAt(0); // 첫번째 Sheet 읽어옴
			int rowNumS = sheet.getFirstRowNum(); // 첫번째 Row 번호
			int rowNumE = sheet.getLastRowNum(); // 마지막 Row 번호
			for (int rownum = 8; rownum <= rowNumE
					; rownum++) { // 처움부터 마지막 Row까지 순차적으로 처리
				Row row = sheet.getRow(rownum); // Row 조회
				if (row != null) {
					int cellNumS = row.getFirstCellNum(); // Row 의 첫번째 Cell 번호
					int cellNumE = row.getLastCellNum(); // Row의 마지막 Cell 번호
					Contest contest = new Contest();
					int idx = 0;
					String arr[] = new String[13];
					for (int cellnum = cellNumS; cellnum < cellNumE; cellnum++) { // 처움부터 마지막 Cell까지 순차적으로 처리
						Cell cell = row.getCell(cellnum); // Cell 조회
						if (cell != null) {
							if(cellnum == 10 || cellnum == 14 || cellnum == 15) continue;
							arr[idx++] = String.valueOf(cell);
						}
					}
					insert(arr);
				}				
			}
		} finally {
			if (workbook != null) {
				workbook.close(); // Excel 리소스 반환
			}
			if (fis != null) {
				fis.close(); // 파일 리소스 반환
			}
		}
		pstmt.close();
		if (con != null) { 
			con.close(); 
		}
	}

}
