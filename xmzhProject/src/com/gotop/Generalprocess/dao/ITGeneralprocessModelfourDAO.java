package com.gotop.Generalprocess.dao;

import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelFourMistake;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ITGeneralprocessModelfourDAO {

	ProcessModelFour queryModelFour(HashMap<String, Object> map);

	void addModelFour(ProcessModelFour modelFour);

	void uptModelFour(ProcessModelFour modelFour);
	
	ProcessModelFour queryModelFourById(String processModelId);

	void addModelFourMistake(ProcessModelFourMistake mistake);

	List<ProcessModelFourMistake> queryFourMistake(HashMap<String, Object> map);

	void deleteModelFourMistake(ProcessModelFour modelFour);

	List<ProcessModelFourMistake> queryFourMistakeByFlowId(
			HashMap<String, Object> map);

	void saveMistakeInfo(Map<String, Object> map);

	List<ProcessModelFourMistake> queryMistakes(Map<String, Object> map2);

	ProcessModelFour queryProceeModelId(Map<String, Object> map);

	void saveProcessModelFour(Map<String, Object> map);
}