package pl.marekhacieja.model;

import java.io.Serializable;
import java.util.*;

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

	@NotEmpty(message = "{pl.marekhacieja.model.User.address.NotEmpty}")
	@Column(name = "telephone_number", length=9)
	private String telephone;

	// User <-> UserDetails
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<UserRole> roles = new HashSet<>();

	// User <-> Orders
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE }, orphanRemoval = true)
	private List<Order> orders = new ArrayList<>();

	public User() {
	}

	public User(String username, String password, String email, String firstname, String lastname, String address, String telephone) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.telephone = telephone;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", address='" + address + '\'' +
				", telephone='" + telephone + '\'' +
				", roles=" + roles +
				", orders=" + orders +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id) &&
				Objects.equals(username, user.username) &&
				Objects.equals(password, user.password) &&
				Objects.equals(email, user.email) &&
				Objects.equals(firstname, user.firstname) &&
				Objects.equals(lastname, user.lastname) &&
				Objects.equals(address, user.address) &&
				Objects.equals(telephone, user.telephone) &&
				Objects.equals(roles, user.roles) &&
				Objects.equals(orders, user.orders);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, password, email, firstname, lastname, address, telephone, roles, orders);
	}
}
