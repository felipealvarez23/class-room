package com.ez.classroom.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "virtual_rooms")
public class VirtualRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String password;
    private boolean active;

    @ManyToOne()
    @JsonIgnoreProperties("virtualRooms")
    @JoinColumn(name = "class_room_id")
    private ClassRoom classRoom;
}
