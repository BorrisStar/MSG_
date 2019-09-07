package mygames.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
/*
@Digits(integer = 10, fraction = 2)



    @Size(min=2, max=30)
    private String name;

    @NotNull
    @Min(18)
    private Integer age;
 */

public class GameDto {

	@Null
	private int id;

	@Size(min=3, max=50)
	@Pattern(regexp = "^([-_a-zA-Z0-9.:]{3,})$"
			, message = "Название игры может содержать только латинские буквы, цифры, знаки тире, подчеркивания, двоеточие и точку.")
	private String game;

	@DecimalMax("2050")
	@DecimalMin("1995")
	private int year;

	@Size(min=3, max=20)
	private String genre;

	@Size(min=3, max=50)
	@Pattern(regexp = "^([-_a-zA-Z0-9.]{3,})$"
			, message = "Название разработчика игры может содержать только латинские буквы, цифры, знаки тире, подчеркивания и точку.")
	private String developer;

	@Size(min=3, max=50)
	@Pattern(regexp = "^([-a-zA-Z0-9.]{3,})$"
			, message = "Название процессора может содержать только латинские буквы, цифры, знаки тире и точку.")
	private String processor;

	@Size(min=3, max=50)
	@Pattern(regexp = "^([-_a-zA-Z0-9.+()]{3,})$"
			, message = "Название видеокарты может содержать только латинские буквы, цифры, знаки тире, плюса и скобки.")
	private String videocard;

	@Digits(integer = 10, fraction = 2, message = "Не более 10-х знаков")
	@DecimalMin(value = "0.1", inclusive = false)
	private double memory;

	@Digits(integer = 10, fraction = 2, message = "Не более 10-х знаков")
	@DecimalMin(value = "0.1", inclusive = false)
	private double freesize;

	@Digits(integer = 10, fraction = 2, message = "Не более 10-х знаков")
	private BigDecimal price;

	@Size(min=3, max=50)
	@Pattern(regexp = "^([-a-zA-Z0-9.]{3,})$"
			, message = "Название платформы может содержать только латинские буквы, цифры, знаки тире и точку.")
	private String launcher;

	private boolean installed;

	public GameDto() {
	}

	public GameDto(int id, String game, int year, String genre, String developer, String processor, String videocard, double memory, double freesize, BigDecimal price, String launcher, boolean installed) {
		this.id = id;
		this.game = game;
		this.year = year;
		this.genre = genre;
		this.developer = developer;
		this.processor = processor;
		this.videocard = videocard;
		this.memory = memory;
		this.freesize = freesize;
		this.price = price;
		this.launcher = launcher;
		this.installed = installed;
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
}
