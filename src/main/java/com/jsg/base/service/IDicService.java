package com.jsg.base.service;

import com.jsg.base.model.BasePage;
import com.jsg.base.model.DicCategory;

public interface IDicService extends IBaseService {
	
	BasePage queryDicCategory(DicCategory dicCategory,int pageNo,int pageSize);
}
