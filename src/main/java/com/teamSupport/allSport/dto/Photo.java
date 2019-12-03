package com.teamSupport.allSport.dto;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
	private int idPhoto;
	private String photo_path;
	private String photo_name;
	private String photo_type;
	private String photo_size;
	@OneToOne
	@JoinColumn(name = "idArticle")
	private int idArticle;

}
