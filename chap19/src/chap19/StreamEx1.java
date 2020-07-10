package chap19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

//goodee.txt 문서를 분석하여 저장된 단어의 갯수를 출력하기.
public class StreamEx1 {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("goodee.txt");
		//FileReader fr= new FileReader(path.toFile());
		FileReader fr= new FileReader(new File("goodee.txt"));
		BufferedReader br = new BufferedReader(fr);
		Map<String, Long>wordcount = br.lines().flatMap(str->{	//flatMap : 다른 형태의 스트림으로 변경
			str=str.replace("가"," ");	//의미없는 글자 제거
			str=str.replace("는"," ");
			str=str.replace("을"," ");
			str=str.replace("."," ");
			str=str.replace(","," ");
			str=str.replace("!"," ");
			String[] strarr=str.split("\\s+");	//  \\s+ :  \s:공백문자,    + : 공백문자 1개이상
			return Arrays.stream(strarr);	//단언들을 Stream 화
		}).collect(Collectors.groupingBy(String::toString,	//각각의 단어들이 들어감.
				Collectors.mapping(String::toString,Collectors.counting())));	//단어들마다 사용된 갯수 생성.
		System.out.println(wordcount);
		//갯수의 내림차순으로 정렬
		//map(...): Stream<Map.Entry> => Stream<String> 변환.
		wordcount.entrySet().stream().map(s->s.getKey()+","+s.getValue()).sorted((a,b)->{
			String str1 =a.substring(a.lastIndexOf(",")+1);
			String str2 =b.substring(b.lastIndexOf(",")+1);
			return Integer.parseInt(str2)-Integer.parseInt(str1);
			
		}).forEach(s->System.out.println(s));

	}

}
