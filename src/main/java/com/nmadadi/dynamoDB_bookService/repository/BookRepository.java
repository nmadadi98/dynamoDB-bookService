package com.nmadadi.dynamoDB_bookService.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.nmadadi.dynamoDB_bookService.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public BookRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Book save(Book book) {
        dynamoDBMapper.save(book);
        return book;
    }

    public Book getBookById(String id) {
        return dynamoDBMapper.load(Book.class, id);
    }

    public String delete(String id) {
        Book book = dynamoDBMapper.load(Book.class, id);
        dynamoDBMapper.delete(book);
        return "Book Deleted!";
    }

    public String update(String id, Book book) {
        dynamoDBMapper.save(book,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("id",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(id)
                                )));
        return id;
    }
}