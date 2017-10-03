package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import com.google.common.base.Objects;
/**
 * Book class defines the requirements for a book object.
 * @author Jack Donoghue
 *
 */
public class Book
{
  public static Long counter = 0l;
  public Long   id;
  public String title;
  public String year;
  public String author;

  
  public Book()
  {
  }
  /**
   * Book constructor defines the values and types for books.
   * @param title
   * @param year
   * @param author
   */
  public Book (String title, String year, String author)
  {
	  this.id        = counter++;
    this.title  = title;
    this.year = year;
    this.author = author;
  }
  /**
   * Displays movies values in order.
   */
  @Override
  public String toString()
  {
    return toStringHelper(this).addValue(id)
                               .addValue(title)
                               .addValue(year)
                               .addValue(author)
                               .toString();
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.title, this.year, this.author);  
  } 
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Book)
    {
      final Book other = (Book) obj;
      return 
    	  Objects.equal(title, other.title) 
    	  &&  Objects.equal(year, other.year) 
          && Objects.equal(author, other.author);
    }
    else
    {
      return false;
    }
  }
}