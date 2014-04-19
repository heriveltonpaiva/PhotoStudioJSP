package br.unirn.dao;

import java.util.List;



public interface GenericDao{
	
	/**
	 * Inser��o
	 * @param entity
	 */
	public void insert(Object entity);

	/**
	 * Atualiza��o
	 * @param entity
	 */
	public void update(Object entity);
	
	/**
	 * Remo��o
	 * @param entity
	 */
	public void delete(Object entity);
    /**
     * Listar todos
     * @return
     */
	public List<Object> findAll();
	/**
	 * Retornar Objeto por ID
	 * @param id
	 * @return
	 */
	public Object findById(Integer id);
	

	

}