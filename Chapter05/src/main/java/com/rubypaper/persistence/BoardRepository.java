package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

public interface BoardRepository extends CrudRepository<Board,Long>{
	// Title로 검색
	List<Board> findByTitle(String searchKeyword);
	
	// Content 항목 Like 연산자 사용
	List<Board> findByContentContaining(String searchKeyword);
	
	// Title 혹은 Content에 특정 단어가 포함된 글 목록을 조회
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	//제목에 특정 단어가 포함된 글 목록을 내림차순으로 조회
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	// 한 화면에 보여주고 싶은 데이터 수 지정 후 조회 
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

	/*
	// %?1% 의 ?1는 첫번째 파라미터를 의미
	// 위치 기반 파라미터
//	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchKeyword);

	
	// 쿼리문에 사용된 %:searchKeyword% 를 사용하여 매개변수로 받은 값이 바인딩 되도록
	// Param 어노테이션을 추가
	@Query("SELECT b FROM Board b "
			+ "WHERE b.title like %:searchKeyword% "
			+ "ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
	
	// @Query를 이용할 때 엔티티를 통째로 검색하지 않고 특정 변수만 조회 가능
	@Query("SELECT b.seq, b.title, b.writer, b.createDate " 
			+ "FROM Board b " 
			+ "WHERE b.title like %?1% "
			+ "ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	
	//특정 DB에서만 사용하는 네이티브 쿼리 실행
	@Query(value="SELECT seq, title, writer, create_date "
			+ "FROM Board WHERE title like '%'||?1||'%' "
			+ "ORDER BY seq DESC", nativeQuery=true)
	List<Object[]> queryAnnotationTest3(String searchKeyword);
	
	
	// @Query 사용 페이징 처리
	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest4(Pageable paging);
	*/
}
