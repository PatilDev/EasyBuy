package com.dev.modelviewcontroller.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class UserTable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column
public int id;
@Column
public String name;
@Column(unique = true)
public String email;
@Column
public String password;
@Column
public double mobileno;

    public UserTable() {
    }

    public UserTable(int id, String name, String email, String password, double mobileno) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobileno = mobileno;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMobileno() {
        return this.mobileno;
    }

    public void setMobileno(double mobileno) {
        this.mobileno = mobileno;
    }

    public UserTable id(int id) {
        setId(id);
        return this;
    }

    public UserTable name(String name) {
        setName(name);
        return this;
    }

    public UserTable email(String email) {
        setEmail(email);
        return this;
    }

    public UserTable password(String password) {
        setPassword(password);
        return this;
    }

    public UserTable mobileno(double mobileno) {
        setMobileno(mobileno);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserTable)) {
            return false;
        }
        UserTable userTable = (UserTable) o;
        return id == userTable.id && Objects.equals(name, userTable.name) && Objects.equals(email, userTable.email) && Objects.equals(password, userTable.password) && mobileno == userTable.mobileno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, mobileno);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", mobileno='" + getMobileno() + "'" +
            "}";
    }

}
