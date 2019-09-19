package mygames.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import mygames.model.Game;

@Entity
@Table(name = "developers")
public class Developer implements Serializable {

//	public Set<Game> getGames() {
//		return games;
//	}
//
//	public void setGames(Set<Game> games) {
//		this.games = games;
//	}
//
//	@OneToMany(mappedBy = "gameDeveloper", cascade = @OneToMany(mappedBy = "gameDeveloper", cascade = {CascadeType.PERSIST,CascadeType.MERGE }, fetch = FetchType.LAZY)
//	private Set<Game> games = new HashSet<>();


	@Id
	@Column(name = "dev_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dev_id;

	@Column(name = "name")
	private String name;

	public int getDev_id() {
		return dev_id;
	}

	public void setDev_id(int dev_id) {
		this.dev_id = dev_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Developer(String name) {
		this.name = name;
	}

	public Developer() {
	}




}
