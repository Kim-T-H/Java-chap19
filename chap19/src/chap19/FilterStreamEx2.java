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
				new Person("홍길동","남",30),new Person("이몽룡","남",40),
				new Person("성춘향","여",20),new Person("향단이","여",22));
		System.out.print("남자 이름(나이) 출력하기:");
		list.stream().filter(p->p.getGender().equals("남")).forEach(p->System.out.print(p.getName()+"("+p.getAge()+")"+","));
		System.out.println();
		System.out.print("여자 이름(나이) 출력하기:");
		System.out.println("모든 이름을 출력");
		list.stream().filter(p->p.getGender()=="여").forEach(p->System.out.printf("%s(%d),",p.getName(),p.getAge()));
		
		
		System.out.println();
		
	
		//mapXXX()
		//mapToInt : Stream 을 다시 IntStream 형태로 변환
		
		double ageAvg= list.stream().filter(p->p.getGender().contentEquals("남")).mapToInt(Person::getAge).average().getAsDouble();
		System.out.print("남자들의 평균 나이:"+ageAvg);
		
		ageAvg= list.stream().filter(p->p.getGender().contentEquals("여")).mapToInt(p->p.getAge()).average().getAsDouble();
		System.out.print("여자들의 평균 나이:"+ageAvg);
		
		//list.stream().forEach(System.out::println);  //-->ToString 메서드가 오버라이딩 되지않음. 
		list.stream().map(Person::getName).forEach(System.out::println);
	}

}
