//
package com.vti.backend.datalayer;

/**
 * This class is .interface ICandidateRepository
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public interface ICandidateRepository {
	Boolean login(String userName, String password);
}
