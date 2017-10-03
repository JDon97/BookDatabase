package models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Objects;
/**
 * User class responsible for defining user objects values and types.
 * @author Jack Donoghue
 */
public class User 
{
  public static Long   counter = 0l;

  public Long   id;
  public String firstName;
  public String lastName;
  public String age;
  public String gender;
  public String occupation;
  

  
  public User()
  {
  }
  /**
   * Constructor for user defines the inputs and their types.
   * @param firstName
   * @param lastName
   * @param age
   * @param gender
   * @param occupation
   */
  public User(String firstName, String lastName, String age, String gender, String occupation)
  {
    this.id        = counter++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
    this.occupation = occupation;
  }
  /**
   * toString method that displays Users's values
   */
  public String toString()
  {
    return toStringHelper(this).addValue(id)
    		                   .addValue(firstName)
                               .addValue(lastName)
                               .addValue(age)      
                               .addValue(gender)
                               .addValue(occupation)
                               .toString();
  }

  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.firstName, this.lastName, this.age, this.gender, this.occupation);  
  }  
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof User)
    {
      final User other = (User) obj;
      return  
    	   Objects.equal(firstName, other.firstName) 
          && Objects.equal(lastName,  other.lastName)
          && Objects.equal(age,     other.age)
          && Objects.equal(gender,  other.gender)
          && Objects.equal(occupation,  other.occupation);
    }
    else
    {
      return false;
    }
  }
}