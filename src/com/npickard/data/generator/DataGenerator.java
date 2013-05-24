package com.npickard.data.generator;

import com.npickard.data.DataSet;
import com.npickard.data.info.DataInformation;
import com.npickard.data.type.Data;

public interface DataGenerator {

	public DataSet generateDataSet(DataInformation dataInformation, int numData, Class clazz) throws Exception;
}
