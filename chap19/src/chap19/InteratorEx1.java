package chap19;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
 * 외부 반복자와 내부 반복자.
 * 기존의 방식으로 조회하는 방법과 스트림식 조회 방법 비교
 */
public class InteratorEx1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","김삿갓","이몽룡","성춘향","임꺽정","향단이");
		System.out.println("외부 반복자 이용(기존)");
		Iterator it = list.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		System.out.println("내부 반복자 이용(Stream 방식)");
		list.stream().forEach(s->System.out.println(s));
		
		Stream<String> st = list.stream();
		System.out.println("forEach 메서드 사용하기1");
		st.forEach(s->System.out.println(s));
		System.out.println("forEach 메서드 사용하기2");
		list.stream().forEach(s->System.out.println(s));	//스트림은 내부 반복자를 사용.
	}

}
