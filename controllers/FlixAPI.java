package controllers;

import java.util.Collection;
import java.util.Collections;

import com.google.common.base.Optional;

import java.util.HashMap;
import java.util.Map;

import utils.Serializer;
import models.Rating;
import models.Book;
import models.User;
/**
 * API for the book database.
 * @author Jack Donoghue
 *
 */
public class FlixAPI
{
  public Serializer serializer;
  
  public Map<Long,   User>   userIndex       = new HashMap<>();
  public Map<Long, Book>   bookIndex      = new HashMap<>();
  public Map<Long, Rating>   ratingIndex      = new HashMap<>();
  public Collection<User> users = getUsers();
 
      
  public FlixAPI()
  {}
  
  public FlixAPI(Serializer serializer)
  {
    this.serializer = serializer;
  }
  /**
   * load method populates the HashMaps with the saved data
   * counter is also saved here to prevent bug where
   * id is reset to 0 when loaded in.
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public void load() throws Exception
  {
    serializer.read();
    ratingIndex     = (Map<Long, Rating>)   serializer.pop();
    userIndex       = (Map<Long, User>)     serializer.pop();
    bookIndex     = (Map<Long, Book>)   serializer.pop();
    
    Rating.counter = (Long) serializer.pop();
    User.counter = (Long) serializer.pop();
    Book.counter= (Long) serializer.pop();
 
   
 

  }
  /**
   * takes the contents of the HashMaps and stores them to xml
   * counter is also saved from here.
   * @throws Exception
   */
  void store() throws Exception
  {
	  serializer.push(Book.counter);
	  serializer.push(User.counter);
	  serializer.push(Rating.counter);
    serializer.push(bookIndex);
    serializer.push(userIndex);
    serializer.push(ratingIndex);
    serializer.write(); 
  }
  

  /**
   * Users are saved to Collection
   * @return
   */
  public Collection<User> getUsers ()
  {
    return userIndex.values();
  }
  /**
   * This is where new users are created and added to the userIndex HashMap.
   * @param firstName
   * @param lastName
   * @param age
   * @param occupation
   * @param gender
   * @return
   */
  public User addUser(String firstName, String lastName, String age, String occupation, String gender)
  {
    User user = new User (firstName, lastName, age, occupation, gender);
    userIndex.put(user.id, user);
    return user;
  }
  /**
   * This is where objects of Rating are created and added to the ratingIndex Map.
   * @param bookID
   * @param userID
   * @param rating
   * @return
   */
  public Rating addRating(Long bookID, String userID, String rating)
  {
    Rating rate = new Rating (bookID, userID, rating);
    ratingIndex.put(rate.id, rate);
    return rate;
  }
  

/**
 * Used for finding a user using their id.
 * @param id
 * @return
 */
  public User getUser(Long id) 
  {
    return userIndex.get(id);
  }
  /**
   * Find a book by referencing its id.
   * @param id
   * @return
   */
  public Book getBook(Long id) 
  {
    return bookIndex.get(id);
  }
/**
 * deletes a user from the userIndex using id.
 * @param id
 */
  public void deleteUser(String id) 
  {
    userIndex.remove(id);
  }
  /**
   * deletes a movie from movieIndex using id.
   * @param id
   */
  public void deleteBook(String id) 
  {
	 bookIndex.remove(id);
  }
  /**
   * Delete a Rating
   * @param id
   */
  public void deleteRating(String id) 
  {
	 ratingIndex.remove(id);
  }
  /**
   * Retrieve a rating
   * @param id
   */
  public void getRate(String id)
  {
	  ratingIndex.get(id);
  }

  /**
   * 
   * get a users rating
   * @param id
   * @return
   */
  public Book getBookRating (Long id)
  {
    return bookIndex.get(id);
    
  }
  
  /**
   * Creates a new Book and stores it in bookIndex.
   * @param title
   * @param year
   * @param url
   * @return
   */
  public Book addBook(String title, String year, String author) 
  {
	   Book book = new Book (title, year, author);
	    bookIndex.put(book.id, book);
	    return book;
    }
  }

