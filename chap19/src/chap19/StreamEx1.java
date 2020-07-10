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

//goodee.txt ������ �м��Ͽ� ����� �ܾ��� ������ ����ϱ�.
public class StreamEx1 {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("goodee.txt");
		//FileReader fr= new FileReader(path.toFile());
		FileReader fr= new FileReader(new File("goodee.txt"));
		BufferedReader br = new BufferedReader(fr);
		Map<String, Long>wordcount = br.lines().flatMap(str->{	//flatMap : �ٸ� ������ ��Ʈ������ ����
			str=str.replace("��"," ");	//�ǹ̾��� ���� ����
			str=str.replace("��"," ");
			str=str.replace("��"," ");
			str=str.replace("."," ");
			str=str.replace(","," ");
			str=str.replace("!"," ");
			String[] strarr=str.split("\\s+");	//  \\s+ :  \s:���鹮��,    + : ���鹮�� 1���̻�
			return Arrays.stream(strarr);	//�ܾ���� Stream ȭ
		}).collect(Collectors.groupingBy(String::toString,	//������ �ܾ���� ��.
				Collectors.mapping(String::toString,Collectors.counting())));	//�ܾ�鸶�� ���� ���� ����.
		System.out.println(wordcount);
		//������ ������������ ����
		//map(...): Stream<Map.Entry> => Stream<String> ��ȯ.
		wordcount.entrySet().stream().map(s->s.getKey()+","+s.getValue()).sorted((a,b)->{
			String str1 =a.substring(a.lastIndexOf(",")+1);
			String str2 =b.substring(b.lastIndexOf(",")+1);
			return Integer.parseInt(str2)-Integer.parseInt(str1);
			
		}).forEach(s->System.out.println(s));

	}

}
