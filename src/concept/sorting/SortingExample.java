package concept.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExample {

	public void main(String args[]) {
		sortingWithoutLambdas();
		System.out.println();
		sortingWithLambdas();
	}
	
	// Human 생성자
	public class Human {
		private String name;
		private int age;
		public Human(String string, int i) {
			// TODO Auto-generated constructor stub
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		
	}

	// without lambdas 
	public void sortingWithoutLambdas() {
		List<Human> humans = new ArrayList<>();
		humans.add(new Human("Ohora", 12));
		humans.add(new Human("A-yo", 27));
				
		Collections.sort(humans, new Comparator<Human>() {
			@Override
			public int compare(Human h1, Human h2) {
				System.out.println(h1.getName().compareTo(h2.getName()));
				return h1.getName().compareTo(h2.getName());
			}
		});
	
	}
	
	// with lambdas
	public void sortingWithLambdas() {
		List<Human> humans = new ArrayList<>(Arrays.asList(new Human("Ohora",12),new Human("A-yo",27)));
		
		humans.sort((Human h1, Human h2) ->h1.getName().compareTo(h2.getName()));
	}
	
	
}