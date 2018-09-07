import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSortTest {

    public static void main(String[] args) {
        // 두 책을 생성한다.
        List<Book> list = new ArrayList<>();

        list.add(new Book("자바의 정석", 4000));
        list.add(new Book("알고리즘", 3000));
        list.add(new Book("알고리즘2", 5000));


        // 두 책을 가격으로 비교하여 정렬한다.
        Collections.sort(list);

        System.out.println("가격으로 비교 정렬");
        for (Book book : list) {
            System.out.println(book.getTitle() + " " + book.getPrice());
        }
        System.out.println("");

        // 두 책을 제목으로 비교하여 정렬한다.
        Collections.sort(list, new BookComparator());

        System.out.println("제목으로 비교 정렬");
        for (Book book : list) {
            System.out.println(book.getTitle() + " " + book.getPrice());
        }
    }
}

class Book implements Comparable<Book> {
    private String title;
    private int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Book o) {
        return price - o.price;
    }
}

class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}