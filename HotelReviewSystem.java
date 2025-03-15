import java.util.*;

class Review {
    String hotelName;
    String reviewer;
    String comment;
    int rating;

    public Review(String hotelName, String reviewer, String comment, int rating) {
        this.hotelName = hotelName;
        this.reviewer = reviewer;
        this.comment = comment;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel: " + hotelName + " | Reviewer: " + reviewer + " | Rating: " + rating + "/5 | Comment: " + comment;
    }
}

public class HotelReviewSystem {
    static List<Review> reviews = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addReview() {
        System.out.print("Enter hotel name: ");
        String hotelName = sc.nextLine();
        System.out.print("Enter your name: ");
        String reviewer = sc.nextLine();
        System.out.print("Enter rating (1-5): ");
        int rating = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter comment: ");
        String comment = sc.nextLine();

        reviews.add(new Review(hotelName, reviewer, comment, rating));
        System.out.println("Review added successfully!\n");
    }

    public static void displayReviews() {
        if (reviews.isEmpty()) {
            System.out.println("No reviews available.");
            return;
        }
        for (Review r : reviews) {
            System.out.println(r);
        }
    }

    public static void sortReviewsByRating() {
        reviews.sort((r1, r2) -> Integer.compare(r2.rating, r1.rating));
        System.out.println("Reviews sorted by rating (High to Low).\n");
    }

    public static void filterReviewsByHotel() {
        System.out.print("Enter hotel name to filter: ");
        String hotelName = sc.nextLine();
        boolean found = false;
        for (Review r : reviews) {
            if (r.hotelName.equalsIgnoreCase(hotelName)) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No reviews found for this hotel.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHOTEL REVIEW SYSTEM");
            System.out.println("1. Add Review");
            System.out.println("2. Display Reviews");
            System.out.println("3. Sort Reviews by Rating");
            System.out.println("4. Filter Reviews by Hotel");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addReview();
                    break;
                case 2:
                    displayReviews();
                    break;
                case 3:
                    sortReviewsByRating();
                    break;
                case 4:
                    filterReviewsByHotel();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

