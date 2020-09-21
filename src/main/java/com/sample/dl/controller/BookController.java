package com.sample.dl.controller;

import com.sample.dl.model.Book;
import com.sample.dl.service.BookService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Collection;

@Component
@Path("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    @GET
//    @Path("/header")
//    @Produces("application/json")
//    public Response getHeader(@HeaderParam("testcase") String testCase){
////    public String getHeader(@HeaderParam("testcase") String testCase){
////        String output = "User agent :"+ userAgent +" sent :"+length +" bytes";
//        String output = "{'tc': '" + testCase + "'}";
//        System.out.println(output);
//        return Response.status(200).entity(output).build();
//    }

    @GET
    @Produces("application/json")
    public Collection<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("/register")
    @Produces("application/json")
    public Collection<Book> testBookHeader() {
        return bookService.getAllBooks();
    }

    @GET
    @Produces("application/json")
    @Path("/{oid}")
    public Book getBook(@PathParam("oid") String oid) {
        return bookService.getBook(oid);
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addBook(Book book) {
        bookService.addBook(book);
        return Response.created(URI.create("/" + book.getOid())).build();
    }

    @PUT
    @Consumes("application/json")
    @Path("/{oid}")
    public Response updateBook(@PathParam("oid") String oid, Book book) {
        bookService.updateBook(oid, book);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{oid}")
    public Response deleteBook(@PathParam("oid") String oid) {
        bookService.deleteBook(oid);
        return Response.ok().build();
    }
}
