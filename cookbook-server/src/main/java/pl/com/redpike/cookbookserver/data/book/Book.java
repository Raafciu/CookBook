package pl.com.redpike.cookbookserver.data.book;

import java.util.Objects;

public class Book {

    private Integer id;
    private String author;
    private String title;
    private String pages;

    public Book() {
    }

    public Book(Integer id, String author, String title, String pages) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                Objects.equals(pages, book.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, pages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages='" + pages + '\'' +
                '}';
    }
}
