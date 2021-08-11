package com.Santana.bookexample.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Santana.bookexample.models.Book;

//	We need to import @Repository so Spring boot knows this file has permission to interact with the db
@Repository
//	We extend and import the CrudRepository since that is the premade (not made by us) Java library with all the queries we want
//	It will need 2 values in the <> at the end
//	The first value is the name of the Class that has the table we made. Here that would be Book
//	The second is the Data type of the Primary key (Id). In this example Long
public interface BookRepository extends CrudRepository<Book, Long>{

}
