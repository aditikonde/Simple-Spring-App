package spirng.mvcframework.Simple.Spring.App.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spirng.mvcframework.Simple.Spring.App.model.Author;
import spirng.mvcframework.Simple.Spring.App.model.Book;
import spirng.mvcframework.Simple.Spring.App.model.Publisher;
import spirng.mvcframework.Simple.Spring.App.repositories.AuthorRepository;
import spirng.mvcframework.Simple.Spring.App.repositories.BookRepository;
import spirng.mvcframework.Simple.Spring.App.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started----");
//-------------------- Publishers --------------------------
        Publisher publisher1 = new Publisher("Penguin", "Yelahanka, Bengaluru - 560064");
        publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher("LightHouse", "NaviPeth, Pune - 411052");
        publisherRepository.save(publisher2);

        System.out.println("Number of publishers : " + publisherRepository.count());
//------------------- Author1 and book1 add details ------------------
        Author author1 = new Author("Reeva", "Desai");
        Book book1 = new Book("Different shades of Indian Politics", "IC3424");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);
//------------------- Save author 1 and book 1 data to database -----------
        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher1);
//------------------- Author2 and Book 2 add details ---------------------------
        Author author2 = new Author("Narain", "Chopra");
        Book book2 = new Book("Marketing Strategies for DigiAge", "PL7879");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        book2.setPublisher(publisher2);
        publisher2.getBooks().add(book2);
//------------------- Save author 1 and book 1 data to database --------------
        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher2);

//------------------ Book 3 add details -------------------------
        Book book3 = new Book("DataBases and its Management", "GI78629");

        author1.getBooks().add(book3);
        book3.getAuthors().add(author1);
        book3.setPublisher(publisher2);
        publisher2.getBooks().add(book3);
//----------------- Save book 3 to database --------------------
        authorRepository.save(author1);
        bookRepository.save(book3);
        publisherRepository.save(publisher2);
//------------------------------------------------------------------------------------
        System.out.println("Number of books as of now : " + bookRepository.count());
        System.out.println("Publisher 2 \n\tName: " + publisher2.getName() + " \n\tBooks count - " + publisher2.getBooks().size());
    }
}
