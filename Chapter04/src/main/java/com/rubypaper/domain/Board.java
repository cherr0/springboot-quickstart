package com.rubypaper.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Data
@Entity
public class Board implements Serializable {

	@Id
	@GeneratedValue
	private Long seq;
	private String title;
	private String writer;
	private String content;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private Long cnt;
	
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content="
				+ content + ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}
}
