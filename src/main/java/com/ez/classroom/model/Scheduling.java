
package com.ez.classroom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.DayOfWeek;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "scheduling")
@NoArgsConstructor
@AllArgsConstructor
public class Scheduling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private DayOfWeek dayOfWeek;
	private String hour;

	@ManyToOne()
	@JsonIgnoreProperties("scheduling_list")
	@JoinColumn(name = "class_room_id")
	private ClassRoom classRoom;
}
