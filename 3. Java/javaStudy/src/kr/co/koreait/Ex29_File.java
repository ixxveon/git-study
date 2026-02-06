package kr.co.koreait;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex29_File {
	public static void main(String[] args) {
		Path path = Paths.get("Ex29_Hello.txt");
		
		try(BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
			writer.write("파일에 작성중!!!");
			System.out.println("쓰기 완료");
		} catch(IOException e) {
			
		}
		// 스트림생성, 스트림은 데이터통로
		try(BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			String text = reader.readLine();
			System.out.println("파일 내용 : " + text);
		} catch(IOException e) {
			
		}
	}
}
