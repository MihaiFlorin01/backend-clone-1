package com.example.backendclone1.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="storager")
public class Clone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(columnDefinition = "active")
    private boolean active;

    public Clone() {

    }

    public Clone(boolean status) {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Clone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clone clone = (Clone) o;
        return Objects.equals(url, clone.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}