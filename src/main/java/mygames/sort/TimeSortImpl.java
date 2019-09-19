package mygames.sort;

import org.springframework.stereotype.Component;

import java.util.Date;



@Component
public class TimeSortImpl implements ITimeSort {
	public TimeSortImpl() {
	}

	@Override
	public int getYear() {
		return  new Date().getYear();
	}
}
