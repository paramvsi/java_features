package designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class BP04Iterator {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();
        collection.addBook(new Book("The Hobbit"));
        collection.addBook(new Book("1984"));
        collection.addBook(new Book("Brave New World"));

        Iterator iterator = collection.createIterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }

    public interface Iterator {
        boolean hasNext();

        Object next();
    }

    public interface Aggregate {
        Iterator createIterator();
    }

    public static class BookCollection implements Aggregate {
        private List<Book> books;

        public BookCollection() {
            this.books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public List<Book> getBooks() {
            return books;
        }

        @Override
        public Iterator createIterator() {
            return new BookIterator(this);
        }

        // Inner class for a specific iterator for books
        private class BookIterator implements Iterator {
            private BookCollection bookCollection;
            private int currentIndex;

            public BookIterator(BookCollection bookCollection) {
                this.bookCollection = bookCollection;
                this.currentIndex = 0;
            }

            @Override
            public boolean hasNext() {
                return currentIndex < bookCollection.getBooks().size();
            }

            @Override
            public Object next() {
                return hasNext() ? bookCollection.getBooks().get(currentIndex++) : null;
            }
        }
    }

    static class Book {
        private String name;

        public Book(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
