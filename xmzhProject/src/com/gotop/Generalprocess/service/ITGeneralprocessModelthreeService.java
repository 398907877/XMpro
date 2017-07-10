package com.gotop.Generalprocess.service;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelthreeDAO;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelThree;
import com.gotop.Generalprocess.model.TGeneralprocessModelthree;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface ITGeneralprocessModelthreeService {
    /**
     * 通过spring注入DAO的set类.
     * @abatorgenerated
     */
    void settGeneralprocessModelthreeDAO(ITGeneralprocessModelthreeDAO tGeneralprocessModelthreeDAO) throws Exception;

    /**
     * 通过spring注入DAO的get类.
     * @abatorgenerated
     */
    ITGeneralprocessModelthreeDAO gettGeneralprocessModelthreeDAO() throws Exception;

    

	void handleModelThree(MUOUserSession muo, ProcessModelThree modelThree,ProcessModelOne modelOne,
			TaskAssgineeDto taskAssgineeDto,File[] files,String[] filesFileName,File[] files2,String[] files2FileName) throws Exception;

	ProcessModelThree queryModelThree(ProcessModelThree modelThree);

	List queryReportTime(ProcessModelThree modelThree);
}