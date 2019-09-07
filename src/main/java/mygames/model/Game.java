package mygames.model;

//POJO Plain Old Java Object
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "games")
public class Game {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "game")
	private String game;

	@Column(name = "year")
	private int year;

	@Column(name = "genre")
	private String genre;

	@Column(name = "developer")
	private String developer;

	@Column(name = "processor")
	private String processor;

	@Column(name = "videocard")
	private String videocard;

	@Column(name = "memory")
	private double memory;

	@Column(name = "freesize")
	private double freesize;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "launcher")
	private String launcher;

	@Column(name = "installed")
	private boolean installed;

	public Game() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getVideocard() {
		return videocard;
	}

	public void setVideocard(String videocard) {
		this.videocard = videocard;
	}

	public double getMemory() {
		return memory;
	}

	public void setMemory(double memory) {
		this.memory = memory;
	}

	public double getFreesize() {
		return freesize;
	}

	public void setFreesize(double freesize) {
		this.freesize = freesize;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getLauncher() {
		return launcher;
	}

	public void setLauncher(String launcher) {
		this.launcher = launcher;
	}

	public boolean isInstalled() {
		return installed;
	}

	public void setInstalled(boolean installed) {
		this.installed = installed;
	}



	@Override
	public String toString() {
		return "Game{" +
				"id=" + id +
				", game='" + game + '\'' +
				", year=" + year +
				", genre='" + genre + '\'' +
				", developer='" + developer + '\'' +
				", processor='" + processor + '\'' +
				", videocard='" + videocard + '\'' +
				", memory='" + memory + '\'' +
				", freesize=" + freesize +
				", price=" + price +
				", launcher='" + launcher + '\'' +
				", installed=" + installed +
				'}';
	}
}
