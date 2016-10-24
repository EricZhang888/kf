package com.bohosi.yhf.dao.repositories.base;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 1号房JPA repo基础类，集成分页排序，并自定义条件搜索API入口
 * 
 * @author Administrator
 */
@NoRepositoryBean
public interface IBaseRepo<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>
{

	Page<T> search(SearchCriteria criteria, Pageable pageable);

}
