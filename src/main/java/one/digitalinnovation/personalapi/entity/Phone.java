package one.digitalinnovation.personalapi.entity;


import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personalapi.enums.PhoneType;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType  type;
    @Column(nullable = false)
    private String name;
}
