package org.prueba.service;

import java.util.List;

import org.prueba.entity.Cliente;
import org.prueba.entity.ClienteDetalle;
import org.prueba.entity.ClienteKpi;



public interface ClienteService {
	
	
	public List<Cliente> FindAll();
	
	public Cliente FindById(Long id);

	public Cliente Save(Cliente persona);
	
	public ClienteKpi kpIdeClientes();
	
	public List<ClienteDetalle> listClientes();
}
