package pl.marekhacieja.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "user_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "order_books", joinColumns = {
            @JoinColumn(name = "order_id", referencedColumnName = "id_order")}, inverseJoinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "id_book")})
    private List<Book> books = new ArrayList<>();

    @Column(name = "date_issued")
    private String dateIssued;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_value")
    private double totalValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> book) {
        this.books = book;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Double.compare(order.totalValue, totalValue) == 0 &&
				Objects.equals(id, order.id) &&
				Objects.equals(books, order.books) &&
				Objects.equals(dateIssued, order.dateIssued) &&
				Objects.equals(user, order.user);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, books, dateIssued, user, totalValue);
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", books=" + books +
				", dateIssued='" + dateIssued + '\'' +
				", user=" + user +
				", totalValue=" + totalValue +
				'}';
	}
}
