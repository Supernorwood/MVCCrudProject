package com.skilldistillery.lions.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public class LionDAOInMemoryImpl implements LionDAO{

	Map<Integer, Lion> lions;
	
	private int id =1;
	

	public LionDAOInMemoryImpl() {
		lions = new HashMap<>();
		loadSampleLions();
	}
	
	private void loadSampleLions() {
		lions.put(id, new Lion(id++, "Gregory", "male", "https://i.ytimg.com/vi/BgwSMJ-Tbf8/maxresdefault.jpg"));
		lions.put(id, new Lion(id++, "Amy", "female", "http://www.thirteenmonths.com/images/tanzania/tz_inpop/tz_nser_lionkill2_in.jpg"));
		lions.put(id, new Lion(id++, "Charis", "female", "https://i.ytimg.com/vi/1Fna-rhmVlw/maxresdefault.jpg"));
	}
	
	
	@Override
	public Lion addLion(Lion l) {
		l.setId(id++);
		return lions.put(l.getId(), l);
	}

	@Override
	public List<Lion> getAllLions() {
		return new ArrayList<Lion>(lions.values());
	}

	@Override
	public Lion getLionById(int id) {
		return lions.get(id);
	}


	@Override
	public Lion updateLion(Lion l) {
		return lions.put(l.getId(), l);
	}

	@Override
	public Lion deleteLion(Lion l) {
		return lions.remove(l.getId());
	}

}
