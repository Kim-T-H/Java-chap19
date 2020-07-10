package chap19;

import java.util.Arrays;
import java.util.List;

class Person{
	 private String name;
	 private String gender;
	 private int age;
	 public Person(String name, String gender, int age) {
		 this.name=name;
		 this.gender = gender;
		 this.age=age;
	 }
	 public String getName() {return name;}
	 public String getGender() {return gender;}
	 public int getAge() {return age;}
 }
public class FilterStreamEx2 {

	public static void main(String[] args) {
		List<Person> list =Arrays.asList(
				new Person("ȫ�浿","��",30),new Person("�̸���","��",40),
				new Person("������","��",20),new Person("�����","��",22));
		System.out.print("���� �̸�(����) ����ϱ�:");
		list.stream().filter(p->p.getGender().equals("��")).forEach(p->System.out.print(p.getName()+"("+p.getAge()+")"+","));
		System.out.println();
		System.out.print("���� �̸�(����) ����ϱ�:");
		System.out.println("��� �̸��� ���");
		list.stream().filter(p->p.getGender()=="��").forEach(p->System.out.printf("%s(%d),",p.getName(),p.getAge()));
		
		
		System.out.println();
		
	
		//mapXXX()
		//mapToInt : Stream �� �ٽ� IntStream ���·� ��ȯ
		
		double ageAvg= list.stream().filter(p->p.getGender().contentEquals("��")).mapToInt(Person::getAge).average().getAsDouble();
		System.out.print("���ڵ��� ��� ����:"+ageAvg);
		
		ageAvg= list.stream().filter(p->p.getGender().contentEquals("��")).mapToInt(p->p.getAge()).average().getAsDouble();
		System.out.print("���ڵ��� ��� ����:"+ageAvg);
		
		//list.stream().forEach(System.out::println);  //-->ToString �޼��尡 �������̵� ��������. 
		list.stream().map(Person::getName).forEach(System.out::println);
	}

}
