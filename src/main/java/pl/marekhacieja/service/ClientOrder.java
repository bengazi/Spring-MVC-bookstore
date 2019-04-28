package pl.marekhacieja.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.marekhacieja.model.Book;
import pl.marekhacieja.model.Order;

@Component
@SessionScope
public class ClientOrder {
    private Order order;

    public ClientOrder() {
        clear();
    }

    Order getOrder() {
        return order;
    }

    void add(Book book) {
        order.getBooks().add(book);
    }

    void delete(Book book) {
        //TODO FIX
        order.getBooks().remove(book);
    }

    void clear() {
        order = new Order();
    }
}
