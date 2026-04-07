/**
 * Uma classe que mantém as informações sobre um livro.
 * Isso talvez faça parte de uma aplicação maior
 * como um sistema de biblioteca, por exemplo.
 *
 * @author Jonathan Alexande
 * @version 12/10/2025
 */
public class Book {
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    private int borrowed;

    public Book(String bookAuthor, String bookTitle, int numPages) {
        author = bookAuthor;
        title = bookTitle;
        pages = numPages;
        refNumber = "";
        borrowed = 0;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public void setRefNumber(String ref) {
        if (ref.length() >= 3) {
            refNumber = ref;
        } else {
            System.out.println("Erro: o número de referência deve ter pelo menos 3 caracteres.");
        }
    }

    public void borrow() {
        borrowed++;
    }

    public void printAuthor() {
        System.out.println("Autor: " + author);
    }

    public void printTitle() {
        System.out.println("Título: " + title);
    }

    public void printDetails() {
        String ref = refNumber.length() > 0 ? refNumber : "ZZZ";
        System.out.println("Título: " + title + ", Autor: " + author +
                           ", Páginas: " + pages + ", Referência: " + ref +
                           ", Emprestado: " + borrowed + " vez(es)");
    }
}
