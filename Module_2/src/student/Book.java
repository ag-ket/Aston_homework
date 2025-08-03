package student;

import java.util.Objects;

public class Book {
	
	String title;
	int year;
	int pages;

	public Book(String title, int year, int pages) {
		this.title = title;
		this.year = year;
		this.pages = pages;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getPages()
	{
		return pages;
	}
	
	@Override
	public String toString()
	{
		return title;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) { 
            return false; 
        }

       Book book = (Book) o;
       
       return title.equals(book.title) &&
		           year == book.year &&
		           pages == book.pages;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(title, year, pages);
	}
	

}
