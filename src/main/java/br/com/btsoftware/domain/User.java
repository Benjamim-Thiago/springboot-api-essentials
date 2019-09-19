package br.com.btsoftware.domain;

import br.com.btsoftware.domain.enums.Role;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name="users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 20, nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<Request> requests = new ArrayList<Request>();

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<RequestStage> stages = new ArrayList<RequestStage>();

    public User() {
    }

    public User(Long id, String name, String email, String password, Role role, List<Request> requests, List<RequestStage> stages) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.requests = requests;
        this.stages = stages;
    }
    
    public Long getId() {
        return id;
    }

   
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }
    
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<RequestStage> getStages() {
        return stages;
    }

    public void setStages(List<RequestStage> stages) {
        this.stages = stages;
    }
}
