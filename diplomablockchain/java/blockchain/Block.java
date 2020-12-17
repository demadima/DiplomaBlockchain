package blockchain;

import java.time.Instant;

import org.bouncycastle.util.test.FixedSecureRandom.BigInteger;

public class Block {
	private Instant time;
	private String name;
	private String surname;
	private int mark;
	private String markl;
	private String hash;

	public Block() {
	}

	public Block(Instant time, String name, String surname, int mark, String markl , String hash) {
		this.time = time;
		this.name = name;
		this.surname = surname;
		this.mark = mark;
		this.markl = markl;
		this.hash = hash;
	}
	
	public Block(String name, String surname, int mark, String markl, String hash) {
		this.name = name;
		this.surname = surname;
		this.mark = mark;
		this.markl = markl;
		this.hash = hash;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getMarkl() {
		return markl;
	}

	public void setMarkl(String markl) {
		this.markl = markl;
	}

}
