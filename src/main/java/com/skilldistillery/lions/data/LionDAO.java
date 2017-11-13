package com.skilldistillery.lions.data;

import java.util.List;

public interface LionDAO {
	Lion addLion(Lion l);//create
	List<Lion> getAllLions();//retrieve
	Lion getLionById(int id);
	Lion updateLion(Lion l);//update
	Lion deleteLion(Lion l);//delete

}
