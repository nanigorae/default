package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ex13 {
	
	public static void main(String[] args) throws Exception {
		// C:\aaa
		//	폴더 내부 ox.txt 파일만 남기고 나머지 파일 전부 삭제 후 진행
		//
		// Q.
		//	1000개의 OX들이 있다.
		//	O는 1점, X는 점수가 없고, 
		//	만약 연속으로 O가 등장할 경우 점수가 2배가 된다.
		//	ex) OOXXXXOO : 1 + 2 + 1 + 2 => 6점
		//		OOOOXOOO : 1 + 2 + 4 + 8 + 1 + 2 + 4 => 22점
		//	1000개의 OX 점수합을 구하면?
		
		File dir = new File("C:" + File.separator + "aaa");
		File file = new File(dir, "ox.txt");
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		int sum = 0;
		while(true) 
		{
			String msg = br.readLine();
			// = message
			// BufferedReader 클래스의 readLine() 메서드?
			//	줄의 내용을 포함하는 문자열을 반환(줄 끝 문자를 포함하지 않음) 
			//	또는 문자열을 읽지 않고 스트림의 끝에 도달한 경우 null을 반환
			if(msg == null) 
			{
				break;
			}
			System.out.println(msg);
			
			char[] arr = msg.toCharArray();
			// (java.lang.)String 클래스의 toCharArray() 메서드?
			//	문자열을 새 char 배열로 변환
			int plus1 = 1;
			// +1점용 객체 생성
			for(int i = 0; i < arr.length; i++) 
			{
				if(arr[i] == 'O') {
					sum += plus1;
					plus1 *= 2; // plus1 = plus1 * 2;
				} else {
					plus1 = 1;
				}
			}
		}
		System.out.println("=> OX 점수의 합=?");
		System.out.println(sum);
		
		br.close();		
	}
	
}
