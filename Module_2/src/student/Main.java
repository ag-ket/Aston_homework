package student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		List <Student> studentList = new ArrayList<>();
		
		Student stud1 = new Student("Иван","Иванов");
		
		stud1.books.add(new Book("Книга первая", 2001, 100));
		stud1.books.add(new Book("Книга вторая", 2002, 100));
		stud1.books.add(new Book("Книга третья", 2003, 100));
		stud1.books.add(new Book("Книга четвёртая", 2004, 100));
		stud1.books.add(new Book("Книга пятая", 2005, 100));
		
		Student stud2 = new Student("Пётр","Петров");
		
		stud2.books.add(new Book("Книга красная", 1998, 107));
		stud2.books.add(new Book("Книга оранжевая", 1999, 115));
		stud2.books.add(new Book("Книга жёлтая", 2000, 94));
		stud2.books.add(new Book("Книга зелёная", 2001, 238));
		stud2.books.add(new Book("Книга голубая", 2002, 201));
		stud2.books.add(new Book("Книга синяя", 2003, 97));
		stud2.books.add(new Book("Книга фиолетовая", 2004, 101));
		
		Student stud3 = new Student("Василиса","Васильева");
		
		stud3.books.add(new Book("Книга третья", 2003, 100));
		stud3.books.add(new Book("Книга фиолетовая", 2004, 101));
		stud3.books.add(new Book("Книга старая", 1975, 314));
		stud3.books.add(new Book("Книга древняя", 1899, 23));
		stud3.books.add(new Book("Книга новая", 2020, 179));
		
		studentList.add(stud1);
		studentList.add(stud2);
		studentList.add(stud3);
		
		
		studentList.stream()
			.peek(System.out::println)
			.map(v -> v.getBookList())
			//.peek(System.out::println)
			.flatMap(v->v.stream())
			//.peek(System.out::println)
			.sorted(Comparator.comparing(Book::getPages))
			//.peek(System.out::println)
			.filter(v->v.getYear()>2000)
			//.peek(System.out::println)
			.distinct()
			//.peek(System.out::println)
			.limit(3)
			//.peek(System.out::println)
			.map(Book::getYear)
			//.peek(System.out::println)
			.findAny()
			.ifPresentOrElse(v->{System.out.println("Год выпуска: "+v);}, ()->System.out.println("Книга отсутствует"));
			
			
		

	}

}
