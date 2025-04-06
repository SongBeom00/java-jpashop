package jpabook.jpashopthy.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class Address {

    private String city;
    private String street;
    private String zipcode;

}
