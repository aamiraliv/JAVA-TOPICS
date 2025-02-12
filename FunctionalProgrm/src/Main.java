import com.sun.source.tree.LambdaExpressionTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Books {
    String book;
    double price;

    public Books(int price, String book) {
        this.book = book;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Books> book = new ArrayList<>();
        book.add(new Books(100, "alkamist"));
        book.add(new Books(500, "Alchemist"));
        book.add(new Books(150, "Rich Dad Poor Dad"));
        book.add(new Books(300, "Atomic Habits"));
        book.add(new Books(700, "Deep Work"));

        System.out.println("available books: ");
        System.out.println("------------------");
        for (Books bk : book) {
            System.out.println(bk.book);
        }
        Predicate<Books> isExpensive = b -> b.price > 300;
        List<Books> expensive = book.stream()
                .filter(isExpensive)
                .toList();
        System.out.println("\nexpensive books: ");
        System.out.println("--------------------");
        for (Books b : expensive) {
            System.out.println(b.book);
        }

        while (true) {
            System.out.println("\ndo you want to see the book details: ");
            System.out.println("y/n");
            String choice = s.nextLine();
            if (Objects.equals(choice, "y")) {
                Function<Books, String> details = b -> "📖 " + b.book + " costs $" + b.price;
                for (Books b: book){
                    System.out.println(details.apply(b));
                }
            } else if (Objects.equals(choice, "n")) {
                return;
            }
        }

    }
}
