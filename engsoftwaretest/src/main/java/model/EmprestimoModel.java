package model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmprestimoModel{

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EmprestimoModel{" +
				"id=" + id +
				'}';
	}
}
