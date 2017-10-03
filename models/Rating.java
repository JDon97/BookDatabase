package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;
/**
 * Ratings class where the object Rating is defined
 * @author Jack Donoghue
 *
 */
public class Rating 
{  
	public static Long   counter = 0l;
  public Long   id;
  public Long bookID;
  public String userID;
  public String rating;
  public String BookID= "BookID";
  public String UserID = "UserID";
  public String Rating = "Rating";
 
  public Rating()
  {
  }
  /**
   * Rating constructor that defines the values and their types. 
   * @param movieID
   * @param userID
   * @param rating
   */
  public Rating(Long bookID, String userID, String rating)
  {
	  this.id=counter++;
    this.bookID=bookID;
    this.userID=userID;
    this.rating=rating;
  }
  /**
   * toString method displays rating's values.
   */
  @Override
  /**
   * toString method that prints the respective values of the Ratings
   */
  public String toString()
  {
	  
    return toStringHelper(this).addValue(id)
    		                   .add(BookID, bookID)
                               .add(UserID,userID)
                               .add(Rating,rating)
                               .toString();
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.bookID, this.userID, this.rating);  
  } 
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Rating)
    {
      final Rating other = (Rating) obj;
      return Objects.equal(bookID,  other.bookID)
          && Objects.equal(userID,  other.userID)
          && Objects.equal(rating,     other.rating);    
    }
    else
    {
      return false;
    }
  }
}