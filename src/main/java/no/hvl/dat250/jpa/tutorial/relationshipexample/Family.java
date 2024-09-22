package no.hvl.dat250.jpa.tutorial.relationshipexample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "family")
    private final List<Person> members = new ArrayList<>();

    public Collection<Object> getMembers() {
        return Collections.singleton(members);
    }

    public void setDescription(String familyForTheKnopfs) {
        this.description = familyForTheKnopfs;
    }

    // getters and setters

}