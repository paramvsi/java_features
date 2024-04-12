package java8features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

record User(String username, String email) {

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class UserRepository {
    private final List<User> users = Arrays.asList(
            new User("alice", "alice@example.com"),
            new User("bob", "bob@example.com")
    );

    public Optional<User> findUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.username().equals(username))
                .findFirst();
    }
}

public class J03Optionals {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        // Try to find an existing user
        Optional<User> foundUser = repo.findUserByUsername("alice");
        foundUser.ifPresent(user -> System.out.println("Found: " + user));

        // Try to find a non-existing user
        Optional<User> notFoundUser = repo.findUserByUsername("charlie");
        notFoundUser.ifPresent(user -> System.out.println("Found: " + user));
        System.out.println("Not Found Message: " + notFoundUser.orElse(new User("default", "no-reply@example.com")));
    }
}

