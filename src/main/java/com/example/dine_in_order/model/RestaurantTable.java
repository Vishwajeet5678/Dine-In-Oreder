package com.example.dine_in_order.model;

import com.example.dine_in_order.enums.TableStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tables")
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Long tableId;

    @Column(name = "table_number")
    private int tableNumber;

    @Column(name = "table_capacity")
    private int tableCapacity;

    @Column(name = "table_status")
    @Enumerated(EnumType.STRING)
    private TableStatus tableStatus;

    @ManyToOne
    private Restaurant restaurant;
}
