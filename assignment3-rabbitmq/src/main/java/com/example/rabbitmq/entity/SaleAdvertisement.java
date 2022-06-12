package com.example.rabbitmq.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sale_advertisements")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleAdvertisement {
    @Id
    @GeneratedValue(generator = "saleAdvertisementPk_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "saleAdvertisementPk_sequence", sequenceName = "saleAdvertisementPk_sequence", allocationSize = 1)
    private Long saleAdvertisementPk;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String photo;
    @Column(columnDefinition = "text", name = "detail_messages", nullable = false)
    private String detailMessage;
    @Column(name = "price_graph_path")
    private String priceGraphPath;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
            targetEntity = User.class)
    private User user;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SaleAdvertisement that = (SaleAdvertisement) o;
        return saleAdvertisementPk != null && Objects.equals(saleAdvertisementPk, that.saleAdvertisementPk);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
