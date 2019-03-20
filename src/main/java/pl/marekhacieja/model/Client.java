package pl.marekhacieja.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Long id;

	@NotEmpty(message = "{pl.marekhacieja.model.Client.username.NotEmpty}")
	@Column(name = "username", unique = true)
	private String username;

	@NotEmpty(message = "{pl.marekhacieja.model.Client.password.NotEmpty}")
	@Column(name = "password")
	private String password;

	@Email(message = "{pl.marekhacieja.model.Client.email.Email}")
	@NotEmpty(message = "{pl.marekhacieja.model.Client.email.NotEmpty}")
	@Column(name = "email")
	private String email;
	
	@NotEmpty(message = "{pl.marekhacieja.model.Client.firstname.NotEmpty}")
	@Column(name = "firstname")
	private String firstname;

	@NotEmpty(message = "{pl.marekhacieja.model.Client.lastname.NotEmpty}")
	@Column(name = "lastname")
	private String lastname;

	@NotEmpty(message = "{pl.marekhacieja.model.Client.address.NotEmpty}")
	@Column(name = "address")
	private String address;

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE }, orphanRemoval = true)
	private List<Order> orders = new ArrayList<>();

	public Client() {
	}

	

	public Client(String username, String password, String email, String firstname, String lastname, String address){
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order order) {
		order.setClient(this);
		getOrders().add(order);
	}
}
