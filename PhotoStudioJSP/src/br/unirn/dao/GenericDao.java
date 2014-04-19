package br.unirn.dao;

import java.util.List;



public interface GenericDao{
	
	/**
	 * Inserção
	 * @param entity
	 */
	public void insert(Object entity);

	/**
	 * Atualização
	 * @param entity
	 */
	public void update(Object entity);
	
	/**
	 * Remoção
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