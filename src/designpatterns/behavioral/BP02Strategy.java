package designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class BP02Strategy {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding items
        cart.addItem(new Item("1234", 10));
        cart.addItem(new Item("5678", 40));

        // Choosing payment method
        cart.setPaymentStrategy(new PaypalPayment("myemail@example.com", "mypassword"));
        cart.pay();

        // Change payment method
        cart.setPaymentStrategy(new CreditCardPayment("John Doe", "1234567890123456", "786", "12/22"));
        cart.pay();
    }

    public interface PaymentStrategy {
        void pay(int amount);
    }

    public static class Item {
        private final String id;
        private final int price;

        public Item(String id, int price) {
            this.id = id;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public int getPrice() {
            return price;
        }

    }

    public static class CreditCardPayment implements PaymentStrategy {
        private String name;
        private String cardNumber;
        private String cvv;
        private String dateOfExpiry;

        public CreditCardPayment(String nm, String ccNum, String cvv, String expiryDate) {
            this.name = nm;
            this.cardNumber = ccNum;
            this.cvv = cvv;
            this.dateOfExpiry = expiryDate;
        }

        @Override
        public void pay(int amount) {
            System.out.println(amount + " paid with credit/debit card");
        }
    }

    public static class PaypalPayment implements PaymentStrategy {
        private String emailId;
        private String password;

        public PaypalPayment(String email, String pwd) {
            this.emailId = email;
            this.password = pwd;
        }

        @Override
        public void pay(int amount) {
            System.out.println(amount + " paid using PayPal.");
        }
    }

    public static class GooglePayPayment implements PaymentStrategy {
        private String accountEmail;

        public GooglePayPayment(String email) {
            this.accountEmail = email;
        }

        @Override
        public void pay(int amount) {
            System.out.println(amount + " paid using Google Pay.");
        }
    }

    public static class ShoppingCart {
        private final List<Item> items;
        private PaymentStrategy paymentStrategy;

        public ShoppingCart() {
            this.items = new ArrayList<>();
        }

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void addItem(Item item) {
            this.items.add(item);
        }

        public void removeItem(Item item) {
            this.items.remove(item);
        }

        public int calculateTotal() {
            int sum = 0;
            for (Item item : items) {
                sum += item.getPrice();
            }
            return sum;
        }

        public void pay() {
            int amount = calculateTotal();
            paymentStrategy.pay(amount);
        }
    }


}
