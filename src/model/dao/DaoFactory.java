package model.dao;

import model.impl.DepartmentDaoJDBC;
import model.impl.SellerDaoJDBC;

public interface DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC();
	}

}
