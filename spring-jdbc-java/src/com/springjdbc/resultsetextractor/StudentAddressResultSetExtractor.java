package com.springjdbc.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentAddressResultSetExtractor implements ResultSetExtractor<Map<String, List<String>>> {

	@Override
	public Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {

		HashMap<String, List<String>> studentTable = new HashMap<>();

		while (rs.next()) {
			String studentAdddressKey = rs.getString("address");
			String studentNameValue = rs.getString("name");

			List<String> studentsNameList = studentTable.get(studentAdddressKey);

			if (studentsNameList == null) {

				List<String> newStudentList = new ArrayList<>();
				newStudentList.add(studentNameValue);

				studentTable.put(studentAdddressKey, newStudentList);
			} else {
				studentsNameList.add(studentNameValue);
			}
		}

		return studentTable;
	}

}
