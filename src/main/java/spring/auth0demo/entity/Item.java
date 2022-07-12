package spring.auth0demo.entity;

import com.sun.istack.NotNull;

import lombok.*;
import org.intellij.lang.annotations.Pattern;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Item {
    @Id
    private Long id;

    // ✨ New! Decorated class instance variables ✨

    private String name;

    private  Long price;

    private  String description;

    private  String image;

    public Item updateWith(Item item) {
        return new Item(
                this.id,
                item.name,
                item.price,
                item.description,
                item.image
        );
    }
}