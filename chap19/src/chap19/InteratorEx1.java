package chap19;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
 * �ܺ� �ݺ��ڿ� ���� �ݺ���.
 * ������ ������� ��ȸ�ϴ� ����� ��Ʈ���� ��ȸ ��� ��
 */
public class InteratorEx1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("ȫ�浿","���","�̸���","������","�Ӳ���","�����");
		System.out.println("�ܺ� �ݺ��� �̿�(����)");
		Iterator it = list.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		System.out.println("���� �ݺ��� �̿�(Stream ���)");
		list.stream().forEach(s->System.out.println(s));
		
		Stream<String> st = list.stream();
		System.out.println("forEach �޼��� ����ϱ�1");
		st.forEach(s->System.out.println(s));
		System.out.println("forEach �޼��� ����ϱ�2");
		list.stream().forEach(s->System.out.println(s));	//��Ʈ���� ���� �ݺ��ڸ� ���.
	}

}
