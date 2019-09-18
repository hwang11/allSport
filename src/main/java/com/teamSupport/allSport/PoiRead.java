//package com.teamSupport.allSport;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//
//import com.teamSupport.allSport.ContestMapper;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//public class PoiRead {
//	@Autowired
//	static
//	 ContestMapper contestMapper;
//	public static void main(String[] args) throws Exception {
//		File path = new File(".");
//		System.out.println(path.getAbsolutePath());
//		FileInputStream fis = null;
//		Workbook workbook = null;
//		try {
//			//2~10 12~14 
//			// /Users/hwangseon-a/Downloads/AllSport-master/doc/20190820.xls 상대주소로바꿔야함 
//			fis = new FileInputStream("/Users/hwangseon-a/Downloads/AllSport-master/doc/20190820.xls"); // Excel file
//			workbook = WorkbookFactory.create(fis); // Excel 파일을 POI로 읽어옴
//			Sheet sheet = workbook.getSheetAt(0); // 첫번째 Sheet 읽어옴
//
//			int rowNumS = sheet.getFirstRowNum(); // 첫번째 Row 번호
//			int rowNumE = sheet.getLastRowNum(); // 마지막 Row 번호
//			//contestMapper = new ContestMapper();
//			//int idContext = contestMapper.selectCount(); //현재 등록된 contest개수 부터 시작하기 
//			int idContest = 0;
//			for (int rownum = 8; rownum <= rowNumE
//					; rownum++) { // 처움부터 마지막 Row까지 순차적으로 처리
//				Row row = sheet.getRow(rownum); // Row 조회
//				String arr[] = new String[13];
//				if (row != null) {
//					int cellNumS = row.getFirstCellNum(); // Row 의 첫번째 Cell 번호
//					int cellNumE = row.getLastCellNum(); // Row의 마지막 Cell 번호
//					Contest contest = new Contest();
//					int idx = 0;
//					for (int cellnum = cellNumS; cellnum < cellNumE; cellnum++) { // 처움부터 마지막 Cell까지 순차적으로 처리
//						Cell cell = row.getCell(cellnum); // Cell 조회
//						if (cell != null) {
//							//System.out.print(cell); // Cell 출력
//							if(cellnum == 10 || cellnum == 14 || cellnum == 15) continue;
//							arr[idx++] = String.valueOf(cell);
//						}
//						//System.out.print(" | "); // 구분자 출력
//					}
//					for(int i=0;i<arr.length;i++) {
//						switch (i) {
//						case 0: // no
//						contest.setId(idContest);
//						break;
//						case 1: // no
//						int to2 = Integer.parseInt(arr[1]);
//						contest.setNum(to2);
//						break;
//						case 2: // 시작일 
//						contest.setStartDate(arr[2]);
//						break;
//						case 3: // 끝나는날 
//						contest.setEndDate(arr[3]);
//						break;
//						case 4: // 기관 
//							contest.setSOCName(arr[4]);
//							break;
//						case 5: // 종목 
//							contest.setKind(arr[5]);
//							break;
//						case 6: // 제목 
//							contest.setTitle(arr[6]);
//							break;	
//						case 7: // 내용 
//							contest.setContext(arr[7]);
//							break;
//						case 8: // 국내 국제  
//							contest.setCountry(arr[8]);
//							break;
//						case 9: // 대상  
//							contest.setTarget(arr[9]);
//							break;
//						case 10: // 장소  
//							contest.setPlace(arr[10]);
//							break;
//						case 11: // URL
//							contest.setURL(arr[11]);
//							break;
//						case 12: // 전화번호  
//							contest.setPhone(arr[12]);
//							break;
//						default:
//						break;
//						}
//					}
//					System.out.println(contest.toString());
//					contestMapper.insertContest(contest);
//					
//					//ContestController contestController;
//					//contestController.show();
//				}				
//				System.out.println(); // 줄 바꿈 출력
//				idContest++;
//				//System.out.println("count"+contestMapper.selectCount());
//				
//			}
//		} finally {
//			if (workbook != null) {
//				workbook.close(); // Excel 리소스 반환
//			}
//			if (fis != null) {
//				fis.close(); // 파일 리소스 반환
//			}
//		}
//	}
//
//}
