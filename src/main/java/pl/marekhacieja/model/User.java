package pl.marekhacieja.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;

	@NotEmpty(message = "{pl.marekhacieja.model.User.username.NotEmpty}")
	@Column(name = "username", unique = true)
	private String username;

	@NotEmpty(message = "{pl.marekhacieja.model.User.password.NotEmpty}")
	@Column(name = "password")
	private String password;

	@Email(message = "{pl.marekhacieja.model.User.email.Email}")
	@NotEmpty(message = "{pl.marekhacieja.model.User.email.NotEmpty}")
	@Column(name = "email")
	private String email;

	@NotEmpty(message = "{pl.marekhacieja.model.User.firstname.NotEmpty}")
	@Column(name = "firstname")
	private String firstname;

	@NotEmpty(message = "{pl.marekhacieja.model.User.lastname.NotEmpty}")
	@Column(name = "lastname")
	private String lastname;

	@NotEmpty(message = "{pl.marekhacieja.model.User.address.NotEmpty}")
	@Column(name = "address")
	private String address;

	// User <-> UserDetails
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<UserRole> roles = new HashSet<>();

	// User <-> Orders
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE }, orphanRemoval = true)
	private List<Order> orders = new ArrayList<>();

	public User() {
	}

	public User(String username, String password, String email, String firstname, String lastname, String address) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}


	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", address=" + address + ", roles=" + roles + ", orders=" + orders + "]";
	}

}
