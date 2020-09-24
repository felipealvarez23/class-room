package com.ez.classroom.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "class_rooms")
public class ClassRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String teacherName;

	@JsonIgnoreProperties("class_room")
	@OneToMany(mappedBy = "classRoom", cascade = CascadeType.REMOVE)
	private List<VirtualRoom> virtualRooms;

	@OneToMany(mappedBy = "classRoom", cascade = CascadeType.REMOVE)
	private List<Scheduling> schedulingList;
}
