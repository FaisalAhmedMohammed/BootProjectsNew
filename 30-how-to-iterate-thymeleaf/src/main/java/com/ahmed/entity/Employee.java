package com.ahmed.entity;

/* PagingAndSortingRepository (interface)
   |
   |-- findAll(Sort sort) : Iterable<T>
   |
   |-- findAll(Pageable pageable) : Page<T>
                    |
                    |
               Pageable (interface)
                    |
               PageRequest (class)
                    |
        PageRequest.of(pageNo, pageSize)
        
Pagination is used to split large results into smaller chunks (pages), improving performance and usability.
Spring Data JPA makes pagination very easy using the PagingAndSortingRepository or simply JpaRepository.
In Spring Data JPA, Pageable and Page are two key interfaces that support pagination.
*/
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "NEW_EMP")
public class Employee {

	@Id
	private Long empno;

	private String ename;

	private Double sal;

	private Integer dept;

}
